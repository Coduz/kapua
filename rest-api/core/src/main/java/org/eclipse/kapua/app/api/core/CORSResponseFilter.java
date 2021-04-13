/*******************************************************************************
 * Copyright (c) 2016, 2021 Eurotech and/or its affiliates and others
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Eurotech - initial API and implementation
 *******************************************************************************/
package org.eclipse.kapua.app.api.core;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.kapua.KapuaException;
import org.eclipse.kapua.app.api.core.settings.KapuaApiSetting;
import org.eclipse.kapua.app.api.core.settings.KapuaApiSettingKeys;
import org.eclipse.kapua.commons.security.KapuaSecurityUtils;
import org.eclipse.kapua.locator.KapuaLocator;
import org.eclipse.kapua.model.id.KapuaId;
import org.eclipse.kapua.service.account.AccountFactory;
import org.eclipse.kapua.service.account.AccountListResult;
import org.eclipse.kapua.service.account.AccountQuery;
import org.eclipse.kapua.service.account.AccountService;
import org.eclipse.kapua.service.endpoint.EndpointInfo;
import org.eclipse.kapua.service.endpoint.EndpointInfoFactory;
import org.eclipse.kapua.service.endpoint.EndpointInfoListResult;
import org.eclipse.kapua.service.endpoint.EndpointInfoQuery;
import org.eclipse.kapua.service.endpoint.EndpointInfoService;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import liquibase.util.StringUtils;
import org.apache.shiro.web.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CORSResponseFilter implements Filter {

    private final KapuaLocator locator = KapuaLocator.getInstance();
    private final AccountService accountService = locator.getService(AccountService.class);
    private final AccountFactory accountFactory = locator.getFactory(AccountFactory.class);
    private final EndpointInfoService endpointInfoService = locator.getService(EndpointInfoService.class);
    private final EndpointInfoFactory endpointInfoFactory = locator.getFactory(EndpointInfoFactory.class);

    private static final String ACCESS_CONTROL_ALLOW_CREDENTIALS = "Access-Control-Allow-Credentials";
    private static final String ACCESS_CONTROL_ALLOW_HEADERS = "Access-Control-Allow-Headers";
    private static final String ACCESS_CONTROL_ALLOW_METHODS = "Access-Control-Allow-Methods";
    private static final String ACCESS_CONTROL_ALLOW_ORIGIN = "Access-Control-Allow-Origin";
    private static final String ORIGIN = "Origin";

    private final Logger logger = LoggerFactory.getLogger(CORSResponseFilter.class);

    private final ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
    private ScheduledFuture<?> refreshTask;

    private Multimap<String, KapuaId> allowedOrigins = HashMultimap.create();
    private final List<String> allowedSystemOrigins = KapuaApiSetting.getInstance().getList(String.class, KapuaApiSettingKeys.API_CORS_ORIGINS_ALLOWED);

    @Override
    public void init(FilterConfig filterConfig) {
        logger.info("Initializing with FilterConfig: {}", filterConfig);
        int intervalSecs = KapuaApiSetting.getInstance().getInt(KapuaApiSettingKeys.API_CORS_REFRESH_INTERVAL, 60);
        initRefreshThread(intervalSecs);
    }

    @Override
    public void destroy() {
        logger.info("Shutting down...");
        if (refreshTask != null) {
            refreshTask.cancel(true);
        }
        logger.info("Shutting down... DONE!");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse httpResponse = WebUtils.toHttp(response);
        HttpServletRequest httpRequest = WebUtils.toHttp(request);
        String origin = httpRequest.getHeader(ORIGIN);
        if (StringUtils.isEmpty(origin)) {
            // Not a CORS request. Move along.
            chain.doFilter(request, response);
            return;
        }

        httpResponse.addHeader(ACCESS_CONTROL_ALLOW_METHODS, "GET, POST, DELETE, PUT");
        httpResponse.addHeader(ACCESS_CONTROL_ALLOW_HEADERS, "X-Requested-With, Content-Type, Authorization");

        if (httpRequest.getMethod().equals("OPTIONS")) {
            // Preflight request
            if (checkOrigin(origin, null)) {
                // Origin matches at least one defined Endpoint
                httpResponse.addHeader(ACCESS_CONTROL_ALLOW_CREDENTIALS, "true");
                httpResponse.addHeader(ACCESS_CONTROL_ALLOW_ORIGIN, origin);
                httpResponse.addHeader("Vary", ORIGIN);
            } else {
                throw new ServletException(String.format("HTTP Origin not allowed: %s", origin));
            }
        } else {
            // Actual request
            if (checkOrigin(origin, KapuaSecurityUtils.getSession().getScopeId())) {
                // Origin matches at least one defined Endpoint
                httpResponse.addHeader(ACCESS_CONTROL_ALLOW_CREDENTIALS, "true");
                httpResponse.addHeader(ACCESS_CONTROL_ALLOW_ORIGIN, origin);
                httpResponse.addHeader("Vary", ORIGIN);
            } else {
                throw new ServletException(String.format("HTTP Origin not allowed: %s", origin));
            }
        }
        chain.doFilter(request, response);
    }

    private String getExplicitOrigin(String origin) throws MalformedURLException {
        URL originUrl = new URL(origin);
        if (originUrl.getPort() != -1) {
            return origin;
        }
        switch (originUrl.getProtocol()) {
            case "http":
                return origin + ":80";
            case "https":
                return origin + ":443";
            default:
                return origin;
        }
    }

    private boolean checkOrigin(String origin, KapuaId scopeId) {
        String explicitOrigin;
        try {
            explicitOrigin = getExplicitOrigin(origin);
        } catch (MalformedURLException malformedURLException) {
            return false;
        }
        if (scopeId == null) {
            // No scopeId, so the call is no authenticated. Return true only if origin
            // is enabled in any account or system settings
            return allowedOrigins.containsKey(explicitOrigin);
        } else {
            // scopeId has a value, so validate the account as well
            Collection<KapuaId> allowedAccountIds = allowedOrigins.get(explicitOrigin);
            return allowedAccountIds.contains(scopeId) || allowedAccountIds.contains(KapuaId.ANY);
        }
    }

    private synchronized void initRefreshThread(int intervalSecs) {
        if (refreshTask == null) {
            refreshTask = executorService.scheduleAtFixedRate(this::refreshOrigins, 0, intervalSecs, TimeUnit.SECONDS);
        }
    }

    private synchronized void refreshOrigins() {
        try {
            logger.info("Refreshing list of origins...");
            Multimap<String, KapuaId> newAllowedOrigins = HashMultimap.create();
            AccountQuery accounts = accountFactory.newQuery(null);
            AccountListResult accountListResult = KapuaSecurityUtils.doPrivileged(() -> accountService.query(accounts));
            accountListResult.getItems().forEach(account -> {
                EndpointInfoQuery endpointInfoQuery = endpointInfoFactory.newQuery(account.getId());
                try {
                    EndpointInfoListResult endpointInfoListResult = KapuaSecurityUtils.doPrivileged(() -> endpointInfoService.query(endpointInfoQuery, EndpointInfo.ENDPOINT_TYPE_CORS));
                    endpointInfoListResult.getItems().forEach(endpointInfo -> newAllowedOrigins.put(endpointInfo.toStringURI(), account.getId()));
                } catch (KapuaException kapuaException) {
                    logger.warn("Unable to add endpoints for account {} to CORS filter", account.getId().toCompactId(), kapuaException);
                }
            });
            for (String allowedSystemOrigin : allowedSystemOrigins) {
                try {
                    String explicitAllowedSystemOrigin = getExplicitOrigin(allowedSystemOrigin);
                    newAllowedOrigins.put(explicitAllowedSystemOrigin, KapuaId.ANY);
                } catch (MalformedURLException malformedURLException) {
                    logger.warn(String.format("Unable to parse origin %s", allowedSystemOrigin), malformedURLException);
                }
            }
            allowedOrigins = newAllowedOrigins;
            logger.info("Refreshing list of origins... DONE!");
        } catch (Exception exception) {
            logger.warn("Unable to refresh list of origins", exception);
        }
    }

}
