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
 *     Red Hat Inc
 *******************************************************************************/
package org.eclipse.kapua.service.device.call.message.kura.app.notification;

import org.eclipse.kapua.service.device.call.kura.Kura;
import org.eclipse.kapua.service.device.call.message.app.notification.DeviceNotifyPayload;
import org.eclipse.kapua.service.device.call.message.kura.app.KuraAppPayload;

/**
 * {@link DeviceNotifyPayload} {@link Kura} implementation.
 *
 * @since 1.0.0
 */
public class KuraNotifyPayload extends KuraAppPayload implements DeviceNotifyPayload {

    @Override
    public Long getOperationId() {
        if (getMetrics().containsKey(KuraNotifyMetrics.JOB_ID)) {
            return (Long) getMetrics().get(KuraNotifyMetrics.JOB_ID);
        }

        if (getMetrics().containsKey(KuraNotifyMetrics.OPERATION_ID_ALTERNATIVE)) {
            return (Long) getMetrics().get(KuraNotifyMetrics.OPERATION_ID_ALTERNATIVE);
        }

        return null;
    }

    public String getResource() {

        if (getMetrics().containsKey(KuraNotifyMetrics.DP_DOWNLOAD_STATUS)) {
            return "download";
        }

        if (getMetrics().containsKey(KuraNotifyMetrics.DP_INSTALL_STATUS)) {
            return "install";
        }

        if (getMetrics().containsKey(KuraNotifyMetrics.DP_UNINSTALL_PROGRESS)) {
            return "uninstall";
        }

        return null;
    }

    @Override
    public String getStatus() {
        Object status = getMetrics().get(KuraNotifyMetrics.DP_DOWNLOAD_STATUS);

        if (status == null) {
            status = getMetrics().get(KuraNotifyMetrics.DP_INSTALL_STATUS);
        }

        if (status == null) {
            status = getMetrics().get(KuraNotifyMetrics.DP_UNINSTALL_STATUS);
        }

        if (status == null) {
            status = getMetrics().get(KuraNotifyMetrics.STATUS);
        }

        return (String) status;
    }

    @Override
    public Integer getProgress() {
        Object progress = getMetrics().get(KuraNotifyMetrics.DP_DOWNLOAD_PROGRESS);

        if (progress == null) {
            progress = getMetrics().get(KuraNotifyMetrics.DP_INSTALL_PROGRESS);
        }

        if (progress == null) {
            progress = getMetrics().get(KuraNotifyMetrics.DP_UNINSTALL_PROGRESS);
        }

        if (progress == null) {
            progress = getMetrics().get(KuraNotifyMetrics.PROGRESS);
        }

        return (Integer) progress;
    }

    @Override
    public String getMessage() {
        Object message = getMetrics().get(KuraNotifyMetrics.DP_NOTIFY_MESSAGE);

        if (message == null) {
            message = getMetrics().get(KuraNotifyMetrics.MESSAGE);
        }

        if (message == null) {
            message = getMetrics().get(KuraNotifyMetrics.DP_DOWNLOAD_MESSAGE);
        }

        if (message == null) {
            message = getMetrics().get(KuraNotifyMetrics.DP_DOWNLOAD_ERROR_MESSAGE);
        }

        if (message == null) {
            message = getMetrics().get(KuraNotifyMetrics.DP_INSTALL_MESSAGE);
        }

        if (message == null) {
            message = getMetrics().get(KuraNotifyMetrics.DP_INSTALL_ERROR_MESSAGE);
        }

        if (message == null) {
            message = getMetrics().get(KuraNotifyMetrics.DP_UNINSTALL_MESSAGE);
        }

        if (message == null) {
            message = getMetrics().get(KuraNotifyMetrics.DP_UNINSTALL_ERROR_MESSAGE);
        }

        return (String) message;
    }
}
