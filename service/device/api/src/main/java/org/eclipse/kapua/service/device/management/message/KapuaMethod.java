/*******************************************************************************
 * Copyright (c) 2016, 2020 Eurotech and/or its affiliates and others
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Eurotech - initial API and implementation
 *******************************************************************************/
package org.eclipse.kapua.service.device.management.message;

/**
 * Kapua request/reply method definition.<br>
 * This object defines the request types that can be sent to a Device.
 *
 * @since 1.0.0
 */
public enum KapuaMethod {
    /**
     * Create request.
     *
     * @since 1.0.0
     */
    CREATE,

    /**
     * Delete request.
     *
     * @since 1.0.0
     */
    DELETE,

    /**
     * Same as {@link #DELETE} but with a name that matches Kura naming.
     *
     * @since 1.2.0
     */
    DEL,

    /**
     * Execute request.
     *
     * @since 1.0.0
     */
    EXECUTE,

    /**
     * Same as {@link #EXECUTE} but with a name that matches Kura naming.
     *
     * @since 1.2.0
     */
    EXEC,

    /**
     * Same as {@link #READ} but with a name that matches Kura naming.
     *
     * @since 1.2.0
     */
    GET,

    /**
     * Options request.
     *
     * @since 1.0.0
     */
    OPTIONS,

    /**
     * Same as {@link #CREATE} but with a name that matches Kura naming.
     *
     * @since 1.2.0
     */
    POST,

    /**
     * Same as {@link #WRITE} but with a name that matches Kura naming.
     *
     * @since 1.2.0
     */
    PUT,

    /**
     * Read request.
     *
     * @since 1.0.0
     */
    READ,

    /**
     * Submit request.
     *
     * @since 1.2.0
     */
    SUBMIT,


    /**
     * Write request.
     *
     * @since 1.0.0
     */
    WRITE;

    /**
     * Normalizes the value to match only one of the following {@link KapuaMethod}s
     * <ul>
     *     <li>{@link #CREATE}</li>
     *     <li>{@link #DELETE}</li>
     *     <li>{@link #EXECUTE}</li>
     *     <li>{@link #OPTIONS}</li>
     *     <li>{@link #READ}</li>
     *     <li>{@link #SUBMIT}</li>
     *     <li>{@link #WRITE}</li>
     * </ul>
     *
     * @return The normalized {@link KapuaMethod}
     * @since 1.2.0
     */
    public KapuaMethod normalizeAction() {
        switch (this) {
            case DEL:
                return KapuaMethod.DELETE;
            case EXEC:
                return KapuaMethod.EXECUTE;
            case GET:
                return KapuaMethod.READ;
            case POST:
                return KapuaMethod.CREATE;
            case PUT:
                return KapuaMethod.WRITE;
            default:
                return this;
        }
    }
}
