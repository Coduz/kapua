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
 *      Eurotech - initial API and implementation
 *******************************************************************************/
package org.eclipse.kapua.service.device.call.kura.model.inventory;

import org.eclipse.kapua.service.device.call.message.app.DeviceAppMetrics;

/**
 * {@link KuraInventoryItems} {@link DeviceAppMetrics} implementation.
 *
 * @since 1.5.0
 */
public class InventoryMetrics implements DeviceAppMetrics {

    private InventoryMetrics() {
    }

    /**
     * Application identifier.
     *
     * @since 1.5.0
     */
    public static final String APP_ID = "INVENTORY";

    /**
     * Application version.
     *
     * @since 1.5.0
     */
    public static final String APP_VERSION = "V1";
}
