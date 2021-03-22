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
package org.eclipse.kapua.service.device.management.message.response;

import org.eclipse.kapua.service.device.management.message.KapuaAppProperties;

/**
 * {@link KapuaResponseMessage} {@link KapuaAppProperties} implementation.
 *
 * @since 1.0.0
 */
public class KapuaResponseProperties implements KapuaAppProperties {

    /**
     * Constructor.
     *
     * @since 1.5.0
     */
    private KapuaResponseProperties() {
    }

    /**
     * Exception message (if present)
     *
     * @since 1.0.0
     */
    public static final String RESP_PROPERTY_EXCEPTION_MESSAGE = "response.exception.message";

    /**
     * Exception stack (if present)
     *
     * @since 1.0.0
     */
    public static final String RESP_PROPERTY_EXCEPTION_STACK = "response.exception.stack";
}
