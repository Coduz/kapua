/*******************************************************************************
 * Copyright (c) 2023, 2022 Eurotech and/or its affiliates and others
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
package org.eclipse.kapua.service.systeminfo.test;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Singleton;
import com.google.inject.name.Names;
import io.cucumber.java.Before;
import org.eclipse.kapua.KapuaException;
import org.eclipse.kapua.commons.configuration.metatype.KapuaMetatypeFactoryImpl;
import org.eclipse.kapua.commons.metric.MetricsService;
import org.eclipse.kapua.commons.metric.MetricsServiceImpl;
import org.eclipse.kapua.commons.model.query.QueryFactoryImpl;
import org.eclipse.kapua.commons.setting.system.SystemSetting;
import org.eclipse.kapua.locator.KapuaLocator;
import org.eclipse.kapua.model.config.metatype.KapuaMetatypeFactory;
import org.eclipse.kapua.model.query.QueryFactory;
import org.eclipse.kapua.qa.common.MockedLocator;
import org.eclipse.kapua.service.account.AccountFactory;
import org.eclipse.kapua.service.account.AccountService;
import org.eclipse.kapua.service.account.internal.AccountFactoryImpl;
import org.eclipse.kapua.service.authorization.AuthorizationService;
import org.eclipse.kapua.service.authorization.permission.Permission;
import org.eclipse.kapua.service.authorization.permission.PermissionFactory;
import org.eclipse.kapua.service.systeminfo.SystemInfoFactory;
import org.eclipse.kapua.service.systeminfo.SystemInfoService;
import org.eclipse.kapua.service.systeminfo.internal.SystemInfoFactoryImpl;
import org.eclipse.kapua.service.systeminfo.internal.SystemInfoServiceImpl;
import org.mockito.Matchers;
import org.mockito.Mockito;

@Singleton
public class SystemInfoLocatorConfiguration {

    /**
     * Setup DI with Google Guice DI.
     * Create mocked and non mocked service under test and bind them with Guice.
     * It is based on custom MockedLocator locator that is meant for service unit tests.
     */
    @Before(value = "@setup", order = 1)
    public void setupDI() {
        MockedLocator mockedLocator = (MockedLocator) KapuaLocator.getInstance();

        AbstractModule module = new AbstractModule() {

            @Override
            protected void configure() {
                bind(String.class).annotatedWith(Names.named("metricModuleName")).toInstance("tests");
                bind(MetricsService.class).to(MetricsServiceImpl.class).in(Singleton.class);

                // Inject mocked Authorization Service method checkPermission
                AuthorizationService mockedAuthorization = Mockito.mock(AuthorizationService.class);
                try {
                    Mockito.doNothing().when(mockedAuthorization).checkPermission(Matchers.any(Permission.class));
                } catch (KapuaException e) {
                    // skip
                }

                bind(QueryFactory.class).toInstance(new QueryFactoryImpl());

                bind(AuthorizationService.class).toInstance(mockedAuthorization);
                // Inject mocked Permission Factory
                bind(PermissionFactory.class).toInstance(Mockito.mock(PermissionFactory.class));
                // Set KapuaMetatypeFactory for Metatype configuration
                bind(KapuaMetatypeFactory.class).toInstance(new KapuaMetatypeFactoryImpl());

                // binding Account related services
                bind(AccountService.class).toInstance(Mockito.mock(AccountService.class));
                bind(AccountFactory.class).toInstance(Mockito.spy(new AccountFactoryImpl()));

                // Inject actual System Info service related services
                bind(SystemInfoService.class).toInstance(new SystemInfoServiceImpl(new SystemInfoFactoryImpl(), SystemSetting.getInstance()));
                bind(SystemInfoFactory.class).toInstance(new SystemInfoFactoryImpl());

            }
        };

        Injector injector = Guice.createInjector(module);
        mockedLocator.setInjector(injector);
    }
}