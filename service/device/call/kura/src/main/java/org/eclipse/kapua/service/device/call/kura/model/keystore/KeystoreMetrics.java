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
package org.eclipse.kapua.service.device.call.kura.model.keystore;

import org.eclipse.kapua.service.device.call.message.DeviceMetrics;
import org.eclipse.kapua.service.device.call.message.app.DeviceAppMetrics;

/**
 * Keystore {@link DeviceMetrics}.
 *
 * @since 1.5.0
 */
public class KeystoreMetrics implements DeviceAppMetrics {

    /**
     * Constructor.
     *
     * @since 1.5.0
     */
    private KeystoreMetrics() {
    }

    /**
     * Application identifier.
     *
     * @since 1.5.0
     */
    public static final String APP_ID = "KEYS";

    /**
     * Application version.
     *
     * @since 1.5.0
     */
    public static final String APP_VERSION = "V1";
}
