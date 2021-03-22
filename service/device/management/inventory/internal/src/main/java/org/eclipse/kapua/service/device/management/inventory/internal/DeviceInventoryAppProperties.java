/*******************************************************************************
 * Copyright (c) 2021 Eurotech and/or its affiliates and others
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
package org.eclipse.kapua.service.device.management.inventory.internal;

import org.eclipse.kapua.service.device.management.inventory.model.inventory.DeviceInventory;
import org.eclipse.kapua.service.device.management.message.KapuaAppProperties;

/**
 * {@link DeviceInventory} {@link KapuaAppProperties} implementation.
 *
 * @since 1.5.0
 */
public class DeviceInventoryAppProperties implements KapuaAppProperties {

    /**
     * Constructor.
     *
     * @since 1.5.0
     */
    private DeviceInventoryAppProperties() {
    }

    /**
     * Application name
     *
     * @since 1.5.0
     */
    public static final String APP_NAME = "INVENTORY";

    /**
     * Application version.
     *
     * @since 1.5.0
     */
    public static final String APP_VERSION = "1.0.0";
}
