/*******************************************************************************
 * Copyright (c) 2017, 2021 Eurotech and/or its affiliates and others
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
package org.eclipse.kapua.service.device.management.asset;

import org.eclipse.kapua.locator.KapuaLocator;
import org.eclipse.kapua.model.xml.KapuaXmlFactory;

import javax.xml.bind.annotation.XmlRegistry;

/**
 * {@link DeviceAsset} {@link KapuaXmlFactory} implementation.
 *
 * @see KapuaXmlFactory
 * @since 1.0.0
 */
@XmlRegistry
public class DeviceAssetXmlFactory implements KapuaXmlFactory {

    private static final KapuaLocator LOCATOR = KapuaLocator.getInstance();
    private static final DeviceAssetFactory DEVICE_ASSET_FACTORY = LOCATOR.getFactory(DeviceAssetFactory.class);

    /**
     * Instantiate a new {@link DeviceAssets}.
     *
     * @return The newly instantiated {@link DeviceAssets}.
     * @since 1.0.0
     */
    public DeviceAssets newAssetListResult() {
        return DEVICE_ASSET_FACTORY.newAssetListResult();
    }

    /**
     * Instantiate a new {@link DeviceAsset}.
     *
     * @return The newly instantiated {@link DeviceAsset}.
     * @since 1.0.0
     */
    public DeviceAsset newDeviceAsset() {
        return DEVICE_ASSET_FACTORY.newDeviceAsset();
    }

    /**
     * Instantiate a new {@link DeviceAssetChannel}.
     *
     * @return The newly instantiated {@link DeviceAssetChannel}.
     * @since 1.0.0
     */
    public DeviceAssetChannel newDeviceAssetChannel() {
        return DEVICE_ASSET_FACTORY.newDeviceAssetChannel();
    }
}
