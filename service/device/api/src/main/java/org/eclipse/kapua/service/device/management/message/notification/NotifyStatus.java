/*******************************************************************************
 * Copyright (c) 2018, 2021 Eurotech and/or its affiliates and others
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
package org.eclipse.kapua.service.device.management.message.notification;

/**
 * @since 1.1.0
 */
public enum NotifyStatus {

    /**
     * @since 1.1.0
     */
    RUNNING,

    /**
     * @since 1.1.0
     */
    COMPLETED,

    /**
     * @since 1.1.0
     */
    FAILED,

    /**
     * @since 1.1.0
     * @deprecated Since 1.3.0. The {@link KapuaNotifyPayload} will never send this value.
     */
    @Deprecated
    STALE
}
