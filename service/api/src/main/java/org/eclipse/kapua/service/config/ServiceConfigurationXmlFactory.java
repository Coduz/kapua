/*******************************************************************************
 * Copyright (c) 2019, 2021 Eurotech and/or its affiliates and others
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
package org.eclipse.kapua.service.config;

import org.eclipse.kapua.locator.KapuaLocator;
import org.eclipse.kapua.model.xml.KapuaXmlFactory;

import javax.xml.bind.annotation.XmlRegistry;

/**
 * {@link ServiceConfiguration} {@link KapuaXmlFactory} implementation.
 *
 * @see KapuaXmlFactory
 * @since 1.0.0
 */
@XmlRegistry
public class ServiceConfigurationXmlFactory implements KapuaXmlFactory {

    private static final KapuaLocator LOCATOR = KapuaLocator.getInstance();
    private static final ServiceConfigurationFactory SERVICE_CONFIGURATION_FACTORY = LOCATOR.getFactory(ServiceConfigurationFactory.class);

    /**
     * Instantiates a new {@link ServiceConfiguration}.
     *
     * @return The newly instantiated {@link ServiceConfiguration}
     * @since 1.0.0
     */
    public ServiceConfiguration newConfiguration() {
        return SERVICE_CONFIGURATION_FACTORY.newConfigurationInstance();
    }

    /**
     * Instantiates a new {@link ServiceComponentConfiguration}.
     *
     * @return The newly instantiated {@link ServiceComponentConfiguration}
     * @since 1.0.0
     */
    public ServiceComponentConfiguration newComponentConfiguration() {
        return SERVICE_CONFIGURATION_FACTORY.newComponentConfigurationInstance(null);
    }
}
