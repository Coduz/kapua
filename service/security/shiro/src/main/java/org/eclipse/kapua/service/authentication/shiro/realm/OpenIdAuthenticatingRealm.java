/*******************************************************************************
 * Copyright (c) 2025, 2025 Eurotech and/or its affiliates and others
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
package org.eclipse.kapua.service.authentication.shiro.realm;

import com.google.common.base.Strings;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.ShiroException;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.util.Destroyable;
import org.eclipse.kapua.KapuaException;
import org.eclipse.kapua.commons.security.KapuaSecurityUtils;
import org.eclipse.kapua.locator.KapuaLocator;
import org.eclipse.kapua.plugin.sso.openid.JwtProcessor;
import org.eclipse.kapua.plugin.sso.openid.OpenIDLocator;
import org.eclipse.kapua.plugin.sso.openid.OpenIDService;
import org.eclipse.kapua.plugin.sso.openid.exception.OpenIDException;
import org.eclipse.kapua.service.account.Account;
import org.eclipse.kapua.service.authentication.OpenIdCredentials;
import org.eclipse.kapua.service.authentication.credential.Credential;
import org.eclipse.kapua.service.authentication.credential.CredentialStatus;
import org.eclipse.kapua.service.authentication.credential.handler.shiro.OpenIdCredentialTypeHandler;
import org.eclipse.kapua.service.authentication.credential.shiro.CredentialImpl;
import org.eclipse.kapua.service.authentication.shiro.OpenIdCredentialsImpl;
import org.eclipse.kapua.service.authentication.shiro.setting.KapuaAuthenticationSetting;
import org.eclipse.kapua.service.authentication.shiro.setting.KapuaAuthenticationSettingKeys;
import org.eclipse.kapua.service.user.User;
import org.eclipse.kapua.service.user.UserService;
import org.jose4j.jwt.consumer.JwtContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.json.JsonObject;

/**
 * {@link OpenIdCredentials} based {@link AuthenticatingRealm} implementation.
 *
 * @since 2.1.0
 */
public class OpenIdAuthenticatingRealm extends KapuaAuthenticatingRealm implements Destroyable {

    private static final Logger LOG = LoggerFactory.getLogger(OpenIdAuthenticatingRealm.class);

    private final Boolean ssoUserExternalIdAutofill;
    private final Boolean ssoUserExternalUsernameAutofill;
    // Get services
    private final UserService userService = KapuaLocator.getInstance().getService(UserService.class);
    private final OpenIDService openIDService = KapuaLocator.getInstance().getComponent(OpenIDLocator.class).getService();
    private final KapuaAuthenticationSetting authenticationSetting = KapuaLocator.getInstance().getComponent(KapuaAuthenticationSetting.class);

    /**
     * JWT Processor.
     */
    private final JwtProcessor jwtProcessor;

    /**
     * Realm name.
     */
    public static final String REALM_NAME = "openIdAuthenticatingRealm";

    /**
     * Constructor.
     *
     * @since 1.0.0
     */
    public OpenIdAuthenticatingRealm() {
        setName(REALM_NAME);

        try {
            jwtProcessor = KapuaLocator.getInstance().getComponent(OpenIDLocator.class).getProcessor();
        } catch (OpenIDException se) {
            throw new ShiroException("Unexpected error while creating JWT Processor!", se);
        }

        ssoUserExternalIdAutofill = authenticationSetting.getBoolean(KapuaAuthenticationSettingKeys.AUTHENTICATION_SSO_USER_EXTERNAL_ID_AUTOFILL);
        ssoUserExternalUsernameAutofill = authenticationSetting.getBoolean(KapuaAuthenticationSettingKeys.AUTHENTICATION_SSO_USER_EXTERNAL_USERNAME_AUTOFILL);
    }

    @Override
    protected void onInit() {
        super.onInit();

        setCredentialsMatcher(new OpenIdCredentialsMatcher(jwtProcessor));
    }

    @Override
    public void destroy() throws Exception {
        if (jwtProcessor != null) {
            jwtProcessor.close();
        }
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        // Extract credentials
        OpenIdCredentialsImpl openIdCredentials = (OpenIdCredentialsImpl) authenticationToken;
        String openIdIdToken = openIdCredentials.getIdToken();

        // Get the associated user by external id
        User user;
        try {
            String userExternalId = extractExternalId(openIdIdToken);

            user = KapuaSecurityUtils.doPrivileged(() -> userService.findByExternalId(userExternalId));

            // Update User.externalUsername if not populated and if autofill is enabled
            if (ssoUserExternalUsernameAutofill &&
                    user != null &&
                    Strings.isNullOrEmpty(user.getExternalUsername())) {

                String externalUsername = extractExternalUsername(openIdIdToken);

                if (!Strings.isNullOrEmpty(externalUsername)) {
                    user.setExternalUsername(externalUsername);
                    user = updateUser(user);
                }
            }
        } catch (AuthenticationException ae) {
            throw ae;
        } catch (Exception e) {
            throw new ShiroException("Unexpected error while looking for the user", e);
        }

        if (user == null) {
            // User not found by User.externalId (OpenID Connect 'sub' claim).
            // Checking by other claims (claim checked is configurable in the OpenIDService.
            try {
                String externalUsername = extractExternalUsername(openIdIdToken);
                LOG.debug("OpenID idToken contains external username: {}", externalUsername);

                if (!Strings.isNullOrEmpty(externalUsername)) {
                    user = KapuaSecurityUtils.doPrivileged(() -> userService.findByExternalUsername(externalUsername));

                    // Update User.externalId if autofill is enabled
                    if (ssoUserExternalIdAutofill && user != null) {
                        String userExternalId = extractExternalId(openIdIdToken);
                        user.setExternalId(userExternalId);
                        user = updateUser(user);
                    }
                } else {
                    user = resolveExternalUsernameWithOpenIdProvider(openIdCredentials);
                }
            } catch (AuthenticationException ae) {
                throw ae;
            } catch (Exception e) {
                throw new ShiroException("Unexpected error while looking for the user", e);
            }
        }

        // Check user
        checkUser(user);

        // Check account
        Account account = checkAccount(user.getScopeId());

        // Create credential
        Credential credential = new CredentialImpl(user.getScopeId(), user.getId(), OpenIdCredentialTypeHandler.TYPE, openIdIdToken, CredentialStatus.ENABLED, null);

        // Build AuthenticationInfo
        return new LoginAuthenticationInfo(getName(),
                account,
                user,
                credential,
                null);
    }

    @Override
    protected void assertCredentialsMatch(AuthenticationToken authcToken, AuthenticationInfo info)
            throws AuthenticationException {
        LoginAuthenticationInfo kapuaInfo = (LoginAuthenticationInfo) info;

        super.assertCredentialsMatch(authcToken, info);

        // Populate Session with info
        populateSession(SecurityUtils.getSubject(), kapuaInfo);
    }

    @Override
    public boolean supports(AuthenticationToken authenticationToken) {
        return authenticationToken instanceof OpenIdCredentialsImpl;
    }
    // Private methods

    /**
     * Extract the subject information
     *
     * @param openIdIdToken the idToken to use
     * @return the subject, never returns {@code null}
     * @throws ShiroException in case the subject could not be extracted
     * @since 1.0.0
     */
    private String extractExternalId(String openIdIdToken) {
        String id;
        try {
            JwtContext jwtContext = jwtProcessor.process(openIdIdToken);
            id = jwtContext.getJwtClaims().getClaimValueAsString(jwtProcessor.getExternalIdClaimName());
        } catch (Exception e) {
            throw new ShiroException("Failed to parse OpenId idToken to extract the externalId claim", e);
        }

        if (Strings.isNullOrEmpty(id)) {
            throw new ShiroException("'sub' missing on OpenId idToken");
        }

        return id;
    }

    /**
     * Extract the external username information
     *
     * @param openIdIdToken the idToken to use.
     * @return the external username.
     * @since 2.0.0
     */
    private String extractExternalUsername(String openIdIdToken) {
        final String externalUsername;
        try {
            JwtContext ctx = jwtProcessor.process(openIdIdToken);
            externalUsername = ctx.getJwtClaims().getClaimValueAsString(jwtProcessor.getExternalUsernameClaimName());
        } catch (Exception e) {
            throw new ShiroException("Failed to parse OpenID idToken", e);
        }

        return externalUsername;
    }

    /**
     * Extract the external username
     *
     * @param userInfo the userInfo to use.
     * @return the external username.
     * @since 2.0.0
     */
    private String extractExternalUsername(JsonObject userInfo) {
        final String externalUsername;
        try {
            // Using JsonObject.getString(String, null) to return 'null' when field is not present in the UserInfo JsonObject.
            // JsonObject.getString(String) throws NPE when element is not present.
            // See JsonObject.getString(String) javadoc.
            externalUsername = userInfo.getString(jwtProcessor.getExternalUsernameClaimName(), null);
        } catch (Exception e) {
            throw new ShiroException("Failed to parse userInfo to read the externalUsername property", e);
        }

        return externalUsername;
    }

    /**
     * Tries to resolve {@link User#getExternalUsername()} using the {@link OpenIDService#getUserInfo(String)} resource.
     *
     * @param openIdCredentials The {@link OpenIdCredentials}.
     * @return The updated user.
     * @throws KapuaException
     * @since 2.1.0
     */
    private User resolveExternalUsernameWithOpenIdProvider(OpenIdCredentials openIdCredentials) throws KapuaException {

        // Ask the OpenID Provider the user's info
        JsonObject userInfo = openIDService.getUserInfo(openIdCredentials.getAccessToken());
        String externalUsername = extractExternalUsername(userInfo);

        User user = null;
        // If externalUsername is returned try to find the User
        if (!Strings.isNullOrEmpty(externalUsername)) {
            user = KapuaSecurityUtils.doPrivileged(() -> userService.findByExternalUsername(externalUsername));

            // Update User.externalId if autofill is configured
            if (ssoUserExternalIdAutofill && user != null) {
                String userExternalId = extractExternalId(openIdCredentials.getIdToken());

                if (!Strings.isNullOrEmpty(userExternalId)) {
                    user.setExternalId(userExternalId);
                    user = updateUser(user);
                }
            }
        }

        return user;
    }

    /**
     * Updates the given {@link User}.
     *
     * @param user The user to update.
     * @return The updated user.
     * @throws KapuaException
     * @since 2.1.0
     */
    private User updateUser(User user) throws KapuaException {
        return KapuaSecurityUtils.doPrivileged(() -> userService.update(user));
    }
}
