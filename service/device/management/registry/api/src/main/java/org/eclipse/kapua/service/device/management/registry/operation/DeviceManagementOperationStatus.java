/*******************************************************************************
 * Copyright (c) 2018, 2020 Eurotech and/or its affiliates and others
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Eurotech - initial API and implementation
 *******************************************************************************/
package org.eclipse.kapua.service.device.management.registry.operation;

import org.eclipse.kapua.service.device.management.message.notification.NotifyStatus;

/**
 * @since 1.2.0
 */
public enum DeviceManagementOperationStatus {

    /**
     * @since 1.0.0
     */
    RUNNING,

    /**
     * @since 1.2.0
     */
    COMPLETED,

    /**
     * @since 1.2.0
     */
    FAILED,

    /*
     * @since 1.2.0
     */
    STALE;

    public static DeviceManagementOperationStatus readFrom(NotifyStatus notifyStatus) {
        switch (notifyStatus) {
            case RUNNING:
                return DeviceManagementOperationStatus.RUNNING;
            case COMPLETED:
                return DeviceManagementOperationStatus.COMPLETED;
            case FAILED:
                return DeviceManagementOperationStatus.FAILED;
            case STALE:
                return DeviceManagementOperationStatus.STALE;
            default:
                return null;
        }
    }
}