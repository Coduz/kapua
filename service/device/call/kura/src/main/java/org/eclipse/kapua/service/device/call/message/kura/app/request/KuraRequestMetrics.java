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
package org.eclipse.kapua.service.device.call.message.kura.app.request;

import org.eclipse.kapua.service.device.call.kura.Kura;
import org.eclipse.kapua.service.device.call.message.app.request.DeviceRequestMetrics;

/**
 * {@link DeviceRequestMetrics} {@link Kura} implementation.
 *
 * @since 1.0.0
 */
public class KuraRequestMetrics implements DeviceRequestMetrics {

    private KuraRequestMetrics() {
    }

    /**
     * Request identifier.
     *
     * @since 1.0.0
     */
    public static final String REQUEST_ID = "request.id";

    /**
     * Requester client identifier.
     *
     * @since 1.0.0
     */
    public static final String REQUESTER_CLIENT_ID = "requester.client.id";
}
