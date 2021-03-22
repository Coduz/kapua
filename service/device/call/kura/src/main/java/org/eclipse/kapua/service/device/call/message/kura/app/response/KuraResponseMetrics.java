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
package org.eclipse.kapua.service.device.call.message.kura.app.response;

import org.eclipse.kapua.service.device.call.kura.Kura;
import org.eclipse.kapua.service.device.call.message.app.response.DeviceResponseMetrics;

/**
 * {@link DeviceResponseMetrics} {@link Kura} implementation.
 *
 * @since 1.0.0
 */
public class KuraResponseMetrics implements DeviceResponseMetrics {

    private KuraResponseMetrics() {
    }

    /**
     * Response exit code.
     *
     * @since 1.0.0
     */
    public static final String RESPONSE_CODE = "response.code";
    /**
     * Response exception message.
     *
     * @since 1.0.0
     */
    public static final String RESPONSE_EXCEPTION_MESSAGE = "response.exception.message";
    /**
     * Response exception stack trace.
     *
     * @since 1.0.0
     */
    public static final String RESPONSE_EXCEPTION_STACK = "response.exception.stack";
}
