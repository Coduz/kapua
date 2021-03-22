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
package org.eclipse.kapua.service.device.management.packages.message.internal;

import org.eclipse.kapua.service.device.management.message.KapuaAppProperties;
import org.eclipse.kapua.service.device.management.packages.DevicePackageManagementService;

/**
 * {@link KapuaAppProperties} definition for {@link DevicePackageManagementService}.
 *
 * @since 1.0.0
 */
public class PackageAppProperties implements KapuaAppProperties {

    /**
     * Constructor.
     *
     * @since 1.5.0
     */
    private PackageAppProperties() {
    }

    /**
     * Application name.
     *
     * @since 1.0.0
     */
    public static final String APP_NAME = "DEPLOY";

    /**
     * Application version.
     *
     * @since 1.0.0
     */
    public static final String APP_VERSION = "1.0.0";

    // Commons exec properties
    /**
     * Operation identifier
     */
    public static final String PACKAGE_OPERATION_ID = "package.operation.id";
    /**
     * Device reboot
     *
     * @since 1.0.0
     */
    public static final String PACKAGE_REBOOT = "package.reboot";
    /**
     * Reboot delay
     *
     * @since 1.0.0
     */
    public static final String PACKAGE_REBOOT_DELAY = "package.reboot.delay";

    // Request exec download
    /**
     * Package uri
     *
     * @since 1.0.0
     */
    public static final String PACKAGE_DOWNLOAD_PACKAGE_URI = "package.download.uri";
    /**
     * Package name
     *
     * @since 1.0.0
     */
    public static final String PACKAGE_DOWNLOAD_PACKAGE_NAME = "package.download.name";
    /**
     * Package version
     *
     * @since 1.0.0
     */
    public static final String PACKAGE_DOWNLOAD_PACKAGE_VERSION = "package.download.version";
    /**
     * URI username
     *
     * @since 1.1.0
     */
    public static final String PACKAGE_DOWNLOAD_USERNAME = "package.download.username";
    /**
     * URI password
     *
     * @since 1.1.0
     */
    public static final String PACKAGE_DOWNLOAD_PASSWORD = "package.download.password";
    /**
     * File hash
     *
     * @since 1.1.0
     */
    public static final String PACKAGE_DOWNLOAD_FILE_HASH = "package.download.file.hash";
    /**
     * File type
     *
     * @since 1.1.0
     */
    public static final String PACKAGE_DOWNLOAD_FILE_TYPE = "package.download.file.type";
    /**
     * Package install
     *
     * @since 1.0.0
     */
    public static final String PACKAGE_DOWNLOAD_PACKAGE_INSTALL = "package.download.install";

    /**
     * File download restart
     *
     * @since 1.1.0
     */
    public static final String PACKAGE_DOWNLOAD_RESTART = "package.download.restart";

    /**
     * File download block size
     *
     * @since 1.1.0
     */
    public static final String PACKAGE_DOWNLOAD_BLOCK_SIZE = "package.download.block.size";

    /**
     * File download block delay
     *
     * @since 1.1.0
     */
    public static final String PACKAGE_DOWNLOAD_BLOCK_DELAY = "package.download.block.delay";

    /**
     * File download block timeout
     *
     * @since 1.1.0
     */
    public static final String PACKAGE_DOWNLOAD_BLOCK_TIMEOUT = "package.download.block.timeout";

    /**
     * File download notify block size
     *
     * @since 1.1.0
     */
    public static final String PACKAGE_DOWNLOAD_NOTIFY_BLOCK_SIZE = "package.download.notify.block.size";

    /**
     * File download install verifier URI
     *
     * @since 1.1.0
     */
    public static final String PACKAGE_DOWNLOAD_INSTALL_VERIFIER_URI = "package.download.install.verifier.uri";

    // Response get download
    /**
     * Package download size
     *
     * @since 1.0.0
     */
    public static final String PACKAGE_DOWNLOAD_SIZE = "package.download.size";
    /**
     * Package download status
     *
     * @since 1.0.0
     */
    public static final String PACKAGE_DOWNLOAD_STATUS = "package.download.status";
    /**
     * Package download progress
     *
     * @since 1.0.0
     */
    public static final String PACKAGE_DOWNLOAD_PROGRESS = "package.download.progress";

    // Request exec install
    /**
     * Package install name
     *
     * @since 1.0.0
     */
    public static final String PACKAGE_INSTALL_PACKAGE_NAME = "package.install.name";
    /**
     * Package install version
     *
     * @since 1.0.0
     */
    public static final String PACKAGE_INSTALL_PACKAGE_VERSION = "package.install.version";

    // Request exec uninstall
    /**
     * Package uninstall name
     *
     * @since 1.0.0
     */
    public static final String PACKAGE_UNINSTALL_PACKAGE_NAME = "package.uninstall.name";
    /**
     * Package uninstall version
     *
     * @since 1.0.0
     */
    public static final String PACKAGE_UNINSTALL_PACKAGE_VERSION = "package.uninstall.version";
}
