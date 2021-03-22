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
package org.eclipse.kapua.service.device.call.message.kura.app.notification;

import org.eclipse.kapua.service.device.call.kura.Kura;
import org.eclipse.kapua.service.device.call.message.app.notification.DeviceNotifyMetrics;

/**
 * {@link DeviceNotifyMetrics} {@link Kura} implementation.
 *
 * @since 1.0.0
 */
public class KuraNotifyMetrics implements DeviceNotifyMetrics {

    private KuraNotifyMetrics() {
    }

    /**
     * @since 1.0.0
     */
    public static final String JOB_ID = "job.id";

    /**
     * @since 1.2.0
     */
    public static final String OPERATION_ID_ALTERNATIVE = "operation.id";

    /**
     * @since 1.2.0
     */
    public static final String STATUS = "status";

    /**
     * @since 1.0.0
     */
    public static final String DP_DOWNLOAD_STATUS = "dp.download.status";

    /**
     * @since 1.0.0
     */
    public static final String DP_INSTALL_STATUS = "dp.install.status";

    /**
     * @since 1.0.0
     */
    public static final String DP_UNINSTALL_STATUS = "dp.uninstall.status";

    /**
     * @since 1.2.0
     */
    public static final String PROGRESS = "progress";

    /**
     * @since 1.0.0
     */
    public static final String DP_DOWNLOAD_PROGRESS = "dp.download.progress";

    /**
     * @since 1.0.0
     */
    public static final String DP_INSTALL_PROGRESS = "dp.install.progress";

    /**
     * @since 1.0.0
     */
    public static final String DP_UNINSTALL_PROGRESS = "dp.uninstall.progress";

    /**
     * @since 1.2.0
     */
    public static final String MESSAGE = "message";

    /**
     * @since 1.2.0
     */
    public static final String DP_NOTIFY_MESSAGE = "dp.notify.message";

    /**
     * @since 1.2.0
     */
    public static final String DP_DOWNLOAD_MESSAGE = "dp.download.message";

    /**
     * @since 1.2.0
     */
    public static final String DP_DOWNLOAD_ERROR_MESSAGE = "dp.download.error.message";

    /**
     * @since 1.2.0
     */
    public static final String DP_INSTALL_MESSAGE = "dp.install.message";

    /**
     * @since 1.2.0
     */
    public static final String DP_INSTALL_ERROR_MESSAGE = "dp.install.error.message";

    /**
     * @since 1.2.0
     */
    public static final String DP_UNINSTALL_MESSAGE = "dp.uninstall.message";

    /**
     * @since 1.2.0
     */
    public static final String DP_UNINSTALL_ERROR_MESSAGE = "dp.uninstall.error.message";
}
