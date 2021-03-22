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
package org.eclipse.kapua.service.device.call.kura.model.deploy;

import org.eclipse.kapua.service.device.call.message.app.DeviceAppMetrics;

/**
 * {@link KuraDeploymentPackage} {@link DeviceAppMetrics} implementation.
 * <p>
 * For documentation follow Kura MQTT namespace: https://eclipse.github.io/kura/ref/mqtt-namespace.html#deploy-v2
 *
 * @since 1.0.0
 */
public class PackageMetrics implements DeviceAppMetrics {

    private PackageMetrics() {
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

    //
    // Common metrics
    /**
     * Operation identifier metric name.
     *
     * @since 1.0.0
     */
    public static final String METRIC_DOWNLOAD_JOB_ID = "job.id";

    /**
     * Device reboot metric name.
     *
     * @since 1.0.0
     */
    public static final String METRIC_DOWNLOAD_DP_REBOOT = "dp.reboot";

    /**
     * Reboot delay metric name.
     *
     * @since 1.0.0
     */
    public static final String METRIC_DOWNLOAD_DP_REBOOT_DELAY = "dp.reboot.delay";

    //
    // Download Exec

    /**
     * Download package uri metric name.
     *
     * @since 1.0.0
     */
    public static final String METRIC_DOWNLOAD_DP_URI = "dp.uri";

    /**
     * Download package name metric name.
     *
     * @since 1.0.0
     */
    public static final String METRIC_DOWNLOAD_DP_NAME = "dp.name";

    /**
     * Download package version metric name.
     *
     * @since 1.0.0
     */
    public static final String METRIC_DOWNLOAD_DP_VERSION = "dp.version";

    /**
     * Download package HTTP basic auth usename metric name.
     *
     * @since 1.1.0
     */
    public static final String METRIC_DOWNLOAD_DP_DOWNLOAD_USERNAME = "dp.download.username";

    /**
     * Download package HTTP basic auth password metric name.
     *
     * @since 1.1.0
     */
    public static final String METRIC_DOWNLOAD_DP_DOWNLOAD_PASSWORD = "dp.download.password";

    /**
     * Dowload package file hash metric name.
     *
     * @since 1.1.0
     */
    public static final String METRIC_DOWNLOAD_DP_DOWNLOAD_HASH = "dp.download.hash";

    /**
     * Download package protocol metric name.
     *
     * @since 1.0.0
     */
    public static final String METRIC_DOWNLOAD_DP_DOWNLOAD_PROTOCOL = "dp.download.protocol";

    /**
     * Download package install metric name.
     *
     * @since 1.0.0
     */
    public static final String METRIC_DOWNLOAD_DP_INSTALL = "dp.install";

    /**
     * Download package install .sh metric name.
     *
     * @since 1.1.0
     */
    public static final String METRIC_DOWNLOAD_DP_INSTALL_SYSTEM_UPDATE = "dp.install.system.update";

    /**
     * Download package installer verifier metric name.
     *
     * @since 1.1.0
     */
    public static final String METRIC_DOWNLOAD_DP_INSTALL_VERIFIER_URI = "dp.install.verifier.uri";

    /**
     * Download package download force metric name.
     *
     * @since 1.2.0
     */
    public static final String METRIC_DOWNLOAD_DP_DOWNLOAD_FORCE = "dp.download.force";

    /**
     * Download package download block size metric name.
     *
     * @since 1.1.0
     */
    public static final String METRIC_DOWNLOAD_DP_DOWNLOAD_BLOCK_SIZE = "dp.download.block.size";

    /**
     * Download package download block delay metric name.
     *
     * @since 1.1.0
     */
    public static final String METRIC_DOWNLOAD_DP_DOWNLOAD_BLOCK_DELAY = "dp.download.block.delay";

    /**
     * Download package download block timeout metric name.
     *
     * @since 1.1.0
     */
    public static final String METRIC_DOWNLOAD_DP_DOWNLOAD_TIMEOUT = "dp.download.timeout";

    /**
     * Download package notify block size metric name.
     *
     * @since 1.1.0
     */
    public static final String METRIC_DOWNLOAD_DP_DOWNLOAD_NOTIFY_BLOCK_SIZE = "dp.download.notify.block.size";

    //
    // Download Get

    /**
     * Download get download size metric name.
     *
     * @since 1.0.0
     */
    public static final String METRIC_DOWNLOAD_DP_DOWNLOAD_SIZE = "dp.download.size";

    /**
     * Download get download status metric name.
     *
     * @since 1.0.0
     */
    public static final String METRIC_DOWNLOAD_DP_DOWNLOAD_STATUS = "dp.download.status";

    /**
     * Download get download progress metric name.
     *
     * @since 1.0.0
     */
    public static final String METRIC_DOWNLOAD_DP_DOWNLOAD_PROGRESS = "dp.download.progress";

    //
    // Install Exec

    /**
     * Install package name metric name.
     *
     * @since 1.0.0
     */
    public static final String METRIC_INSTALL_DP_NAME = METRIC_DOWNLOAD_DP_NAME;

    /**
     * Install package version metric name.
     *
     * @since 1.0.0
     */
    public static final String METRIC_INSTALL_DP_VERSION = METRIC_DOWNLOAD_DP_VERSION;

    /**
     * Install package system update metric name.
     *
     * @since 1.0.0
     */
    public static final String METRIC_INSTALL_DP_INSTALL_SYS_UPDATE = "dp.install.system.update";

    //
    // Request exec uninstall

    /**
     * Uninstall package name metric name.
     *
     * @since 1.0.0
     */
    public static final String METRIC_UNINSTALL_DP_NAME = METRIC_DOWNLOAD_DP_NAME;

    /**
     * Uninstall package version metric name.
     *
     * @since 1.0.0
     */
    public static final String METRIC_UNINSTALL_DP_VERSION = METRIC_DOWNLOAD_DP_VERSION;
}
