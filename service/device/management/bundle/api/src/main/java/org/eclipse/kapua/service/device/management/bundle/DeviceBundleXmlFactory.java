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
package org.eclipse.kapua.service.device.management.bundle;

import org.eclipse.kapua.locator.KapuaLocator;
import org.eclipse.kapua.model.xml.KapuaXmlFactory;

/**
 * {@link DeviceBundle} {@link KapuaXmlFactory} implementation.
 *
 * @see KapuaXmlFactory
 * @since 1.0.0
 */
public class DeviceBundleXmlFactory implements KapuaXmlFactory {

    private final KapuaLocator locator = KapuaLocator.getInstance();
    private final DeviceBundleFactory factory = locator.getFactory(DeviceBundleFactory.class);

    /**
     * Instantiates a new {@link DeviceBundles}.
     *
     * @return The newly instantiated {@link DeviceBundles}
     * @since 1.0.0
     */
    public DeviceBundles newBundleListResult() {
        return factory.newBundleListResult();
    }

    /**
     * Instantiates a new {@link DeviceBundle}.
     *
     * @return The newly instantiated {@link DeviceBundle}
     * @since 1.0.0
     */
    public DeviceBundle newDeviceBundle() {
        return factory.newDeviceBundle();
    }
}
