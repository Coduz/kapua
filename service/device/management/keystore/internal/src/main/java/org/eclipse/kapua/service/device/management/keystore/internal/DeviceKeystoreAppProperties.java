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
package org.eclipse.kapua.service.device.management.keystore.internal;

import org.eclipse.kapua.service.device.management.keystore.model.DeviceKeystore;
import org.eclipse.kapua.service.device.management.message.KapuaAppProperties;

/**
 * {@link DeviceKeystore} {@link KapuaAppProperties} implementation.
 *
 * @since 1.5.0
 */
public class DeviceKeystoreAppProperties implements KapuaAppProperties {

    /**
     * Constructor.
     *
     * @since 1.5.0
     */
    private DeviceKeystoreAppProperties() {
    }

    /**
     * Application name
     */
    public static final String APP_NAME = "KEYS";

    /**
     * Version
     */
    public static final String APP_VERSION = "1.0.0";
}
