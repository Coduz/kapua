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
 *      Eurotech - initial API and implementation
 *******************************************************************************/
package org.eclipse.kapua.service.device.call.kura.model.bundle;

import org.eclipse.kapua.service.device.call.message.app.DeviceAppMetrics;

/**
 * {@link KuraBundle} {@link DeviceAppMetrics} implementation.
 *
 * @since 1.0.0
 */
public class BundleMetrics implements DeviceAppMetrics {

    private BundleMetrics() {
    }

    /**
     * Application identifier.
     *
     * @since 1.0.0
     */
    public static final String APP_ID = "DEPLOY";

    /**
     * Application version.
     *
     * @since 1.0.0
     */
    public static final String APP_VERSION = "V2";
}
