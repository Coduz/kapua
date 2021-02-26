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
package org.eclipse.kapua.service.device.management.configuration;

import org.eclipse.kapua.locator.KapuaLocator;
import org.eclipse.kapua.model.xml.KapuaXmlFactory;

import javax.xml.bind.annotation.XmlRegistry;

/**
 * {@link DeviceConfiguration} {@link KapuaXmlFactory} implementation.
 *
 * @see KapuaXmlFactory
 * @since 1.0.0
 */
@XmlRegistry
public class DeviceConfigurationXmlFactory {

    private static final KapuaLocator LOCATOR = KapuaLocator.getInstance();
    private static final DeviceConfigurationFactory DEVICE_CONFIGURATION_FACTORY = LOCATOR.getFactory(DeviceConfigurationFactory.class);

    /**
     * Instantiates a new {@link DeviceConfiguration}
     *
     * @return The newly instantiated {@link DeviceConfiguration}
     * @since 1.0.0
     */
    public DeviceConfiguration newConfiguration() {
        return DEVICE_CONFIGURATION_FACTORY.newConfigurationInstance();
    }

    /**
     * Instantiates a new {@link DeviceComponentConfiguration}.
     *
     * @return The newly instantiated {@link DeviceComponentConfiguration}
     * @since 1.0.0
     */
    public DeviceComponentConfiguration newComponentConfiguration() {
        return DEVICE_CONFIGURATION_FACTORY.newComponentConfigurationInstance(null);
    }
}
