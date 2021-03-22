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
package org.eclipse.kapua.service.device.management.snapshot.internal;

import org.eclipse.kapua.service.device.management.message.KapuaAppProperties;
import org.eclipse.kapua.service.device.management.snapshot.DeviceSnapshot;

/**
 * {@link DeviceSnapshot} {@link KapuaAppProperties} implementation.
 *
 * @since 1.0.0
 */
public class DeviceSnapshotAppProperties implements KapuaAppProperties {

    /**
     * Constructor.
     *
     * @since 1.5.0
     */
    private DeviceSnapshotAppProperties() {
    }

    /**
     * Application name.
     *
     * @since 1.0.0
     */
    public static final String APP_NAME = "SNAPSHOT";

    /**
     * Application version.
     *
     * @since 1.0.0
     */
    public static final String APP_VERSION = "1.0.0";

}
