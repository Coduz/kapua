/*******************************************************************************
 * Copyright (c) 2011, 2016 Eurotech and/or its affiliates and others
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Eurotech - initial API and implementation
 *******************************************************************************/
package org.eclipse.kapua.service.device.management.message.response;

/**
 * Request/reply message response code.
 *
 * @since 1.0.0
 */
public enum KapuaResponseCode {
    /**
     * Accepted
     *
     * @since 1.0.0
     */
    ACCEPTED,

    /**
     * Bad request
     *
     * @since 1.0.0
     */
    BAD_REQUEST,

    /**
     * Internal error
     *
     * @since 1.0.0
     */
    INTERNAL_ERROR,

    /**
     * Resource not found
     *
     * @since 1.0.0
     */
    NOT_FOUND,

    /**
     * The request has been sent
     *
     * @since 1.2.0
     */
    SENT;

    /**
     * Checks if {@code this} {@link KapuaResponseCode} is equals to {@link KapuaResponseCode#ACCEPTED}.
     *
     * @return {@code true} if {@code this} {@link KapuaResponseCode} is equals to {@link KapuaResponseCode#ACCEPTED}.
     * @since 1.0.0
     */
    public boolean isAccepted() {
        return ACCEPTED.equals(this);
    }

    /**
     * Checks if {@code this} {@link KapuaResponseCode} is equals to {@link KapuaResponseCode#BAD_REQUEST}.
     *
     * @return {@code true} if {@code this} {@link KapuaResponseCode} is equals to {@link KapuaResponseCode#BAD_REQUEST}.
     * @since 1.0.0
     */
    public boolean isBadRequest() {
        return BAD_REQUEST.equals(this);
    }

    /**
     * Checks if {@code this} {@link KapuaResponseCode} is equals to {@link KapuaResponseCode#INTERNAL_ERROR}.
     *
     * @return {@code true} if {@code this} {@link KapuaResponseCode} is equals to {@link KapuaResponseCode#INTERNAL_ERROR}.
     * @since 1.0.0
     */
    public boolean isInternalError() {
        return INTERNAL_ERROR.equals(this);
    }

    /**
     * Checks if {@code this} {@link KapuaResponseCode} is equals to {@link KapuaResponseCode#NOT_FOUND}.
     *
     * @return {@code true} if {@code this} {@link KapuaResponseCode} is equals to {@link KapuaResponseCode#NOT_FOUND}.
     * @since 1.0.0
     */
    public boolean isNotFound() {
        return NOT_FOUND.equals(this);
    }

    /**
     * Checks if {@code this} {@link KapuaResponseCode} is equals to {@link KapuaResponseCode#SENT}.
     *
     * @return {@code true} if {@code this} {@link KapuaResponseCode} is equals to {@link KapuaResponseCode#SENT}.
     * @since 1.2.0
     */
    public boolean isSent() {
        return SENT.equals(this);
    }
}
