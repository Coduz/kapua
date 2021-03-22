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

import com.google.common.base.Strings;
import org.eclipse.kapua.message.internal.KapuaPayloadImpl;
import org.eclipse.kapua.model.id.KapuaId;
import org.eclipse.kapua.service.device.management.message.request.KapuaRequestPayload;
import org.eclipse.kapua.service.device.management.packages.model.DevicePackage;
import org.eclipse.kapua.service.device.management.packages.model.FileType;
import org.eclipse.kapua.service.device.management.packages.model.download.AdvancedPackageDownloadOptions;
import org.eclipse.kapua.service.device.management.packages.model.download.DevicePackageDownloadRequest;
import org.eclipse.kapua.service.device.management.registry.operation.DeviceManagementOperation;

import java.net.URI;

/**
 * {@link DevicePackage} {@link KapuaRequestPayload} implementation.
 * <p>
 * This maps the properties for {@link DevicePackageDownloadRequest} into a {@link KapuaRequestPayload}
 *
 * @since 1.0.0
 */
public class PackageRequestPayload extends KapuaPayloadImpl implements KapuaRequestPayload {

    private static final long serialVersionUID = 3079489211962272959L;

    /**
     * Gets the {@link DeviceManagementOperation#getOperationId()}.
     *
     * @return The {@link DeviceManagementOperation#getOperationId()}.
     * @since 1.0.0
     */
    public KapuaId getOperationId() {
        return (KapuaId) getMetrics().get(PackageAppProperties.PACKAGE_OPERATION_ID);
    }

    /**
     * Set the operation identifier.
     *
     * @param operationId The operation identifier.
     * @since 1.0.0
     */
    public void setOperationId(KapuaId operationId) {
        if (operationId != null) {
            getMetrics().put(PackageAppProperties.PACKAGE_OPERATION_ID, operationId);
        }
    }

    /**
     * See {@link DevicePackageDownloadRequest#setReboot(Boolean)}
     *
     * @since 1.0.0
     */
    public Boolean isReboot() {
        return (Boolean) getMetrics().get(PackageAppProperties.PACKAGE_REBOOT);
    }

    /**
     * See {@link DevicePackageDownloadRequest#getReboot()}
     *
     * @since 1.0.0
     */
    public void setReboot(Boolean reboot) {
        if (reboot != null) {
            getMetrics().put(PackageAppProperties.PACKAGE_REBOOT, reboot);
        }
    }

    /**
     * See {@link DevicePackageDownloadRequest#getRebootDelay()} ()}
     *
     * @since 1.0.0
     */
    public Integer getRebootDelay() {
        return (Integer) getMetrics().get(PackageAppProperties.PACKAGE_REBOOT_DELAY);
    }

    /**
     * See {@link DevicePackageDownloadRequest#setRebootDelay(Integer)}
     *
     * @since 1.0.0
     */
    public void setRebootDelay(Integer rebootDelay) {
        if (rebootDelay != null) {
            getMetrics().put(PackageAppProperties.PACKAGE_REBOOT_DELAY, rebootDelay);
        }
    }

    //
    // Download
    //

    /**
     * See {@link DevicePackageDownloadRequest#getUri()}
     *
     * @since 1.0.0
     */
    public URI getPackageDownloadURI() {
        return (URI) getMetrics().get(PackageAppProperties.PACKAGE_DOWNLOAD_PACKAGE_URI);
    }

    /**
     * See {@link DevicePackageDownloadRequest#setUri(URI)}
     *
     * @since 1.0.0
     */
    public void setPackageDownloadURI(URI uri) {
        if (uri != null) {
            getMetrics().put(PackageAppProperties.PACKAGE_DOWNLOAD_PACKAGE_URI, uri);
        }
    }

    /**
     * See {@link DevicePackageDownloadRequest#getName()}
     *
     * @since 1.0.0
     */
    public String getPackageDownloadName() {
        return (String) getMetrics().get(PackageAppProperties.PACKAGE_DOWNLOAD_PACKAGE_NAME);
    }

    /**
     * See {@link DevicePackageDownloadRequest#setName(String)}
     *
     * @since 1.0.0
     */
    public void setPackageDownloadName(String packageName) {
        if (packageName != null) {
            getMetrics().put(PackageAppProperties.PACKAGE_DOWNLOAD_PACKAGE_NAME, packageName);
        }
    }

    /**
     * See {@link DevicePackageDownloadRequest#getVersion()}
     *
     * @since 1.0.0
     */
    public String getPackageDownloadVersion() {
        return (String) getMetrics().get(PackageAppProperties.PACKAGE_DOWNLOAD_PACKAGE_VERSION);
    }

    /**
     * See {@link DevicePackageDownloadRequest#setVersion(String)}
     *
     * @since 1.0.0
     */
    public void setPackageDownloadVersion(String packageVersion) {
        if (packageVersion != null) {
            getMetrics().put(PackageAppProperties.PACKAGE_DOWNLOAD_PACKAGE_VERSION, packageVersion);
        }
    }

    /**
     * See {@link DevicePackageDownloadRequest#getUsername()}
     *
     * @since 1.1.0
     */
    public String getPackageDownloadUsername() {
        return (String) getMetrics().get(PackageAppProperties.PACKAGE_DOWNLOAD_USERNAME);
    }

    /**
     * See {@link DevicePackageDownloadRequest#setUsername(String)}
     *
     * @since 1.1.0
     */
    public void setPackageDownloadUsername(String username) {
        if (username != null) {
            getMetrics().put(PackageAppProperties.PACKAGE_DOWNLOAD_USERNAME, username);
        }
    }

    /**
     * See {@link DevicePackageDownloadRequest#getPassword()}
     *
     * @since 1.1.0
     */
    public String getPackageDownloadPassword() {
        return (String) getMetrics().get(PackageAppProperties.PACKAGE_DOWNLOAD_PASSWORD);
    }

    /**
     * See {@link DevicePackageDownloadRequest#setPassword(String)}
     *
     * @since 1.1.0
     */
    public void setPackageDownloadPassword(String password) {
        if (password != null) {
            getMetrics().put(PackageAppProperties.PACKAGE_DOWNLOAD_PASSWORD, password);
        }
    }

    /**
     * See {@link DevicePackageDownloadRequest#getFileHash()}
     *
     * @since 1.1.0
     */
    public String getPackageDownloadFileHash() {
        return (String) getMetrics().get(PackageAppProperties.PACKAGE_DOWNLOAD_FILE_HASH);
    }

    /**
     * See {@link DevicePackageDownloadRequest#setFileHash(String)}
     *
     * @since 1.1.0
     */
    public void setPackageDownloadFileHash(String fileHash) {
        if (fileHash != null) {
            getMetrics().put(PackageAppProperties.PACKAGE_DOWNLOAD_FILE_HASH, fileHash);
        }
    }

    /**
     * See {@link DevicePackageDownloadRequest#getFileType()}
     *
     * @since 1.1.0
     */
    public FileType getPackageDownloadFileType() {
        String fileType = (String) getMetrics().get(PackageAppProperties.PACKAGE_DOWNLOAD_FILE_TYPE);

        return Strings.isNullOrEmpty(fileType) ? null : FileType.valueOf(fileType);
    }

    /**
     * See {@link DevicePackageDownloadRequest#setFileType(FileType)}
     *
     * @since 1.1.0
     */
    public void setPackageDownloadFileType(FileType fileType) {
        if (fileType != null) {
            getMetrics().put(PackageAppProperties.PACKAGE_DOWNLOAD_FILE_TYPE, fileType.name());
        }
    }


    /**
     * Get the is a download package and install flag
     *
     * @return
     * @since 1.0.0
     */
    public Boolean isPackageDownloadInstall() {
        return (Boolean) getMetrics().get(PackageAppProperties.PACKAGE_DOWNLOAD_PACKAGE_INSTALL);
    }

    /**
     * Set the is a download package and install flag
     *
     * @param packageDownloadInstall
     * @since 1.0.0
     */
    public void setPackageDownloadnstall(Boolean packageDownloadInstall) {
        if (packageDownloadInstall != null) {
            getMetrics().put(PackageAppProperties.PACKAGE_DOWNLOAD_PACKAGE_INSTALL, packageDownloadInstall);
        }
    }

    /**
     * Gets whether or not to restart the download from the beginning.
     *
     * @return {@code true} if the download must be restarted from the beginning, {@code false} otherwise.
     * @since 1.2.0
     */
    public Boolean getPackageDownloadRestart() {
        return (Boolean) getMetrics().get(PackageAppProperties.PACKAGE_DOWNLOAD_RESTART);
    }

    /**
     * Sets whether or not to restart the download from the beginning.
     *
     * @param restart {@code true} if the download must be restarted from the beginning, {@code false} otherwise.
     * @since 1.2.0
     */
    public void setPackageDownloadRestart(Boolean restart) {
        if (restart != null) {
            getMetrics().put(PackageAppProperties.PACKAGE_DOWNLOAD_RESTART, restart);
        }
    }

    /**
     * Get the download block size
     *
     * @return
     * @since 1.1.0
     */
    public Integer getPackageDownloadBlockSize() {
        return (Integer) getMetrics().get(PackageAppProperties.PACKAGE_DOWNLOAD_BLOCK_SIZE);
    }

    /**
     * Set the download block size
     *
     * @param blockSize
     * @since 1.1.0
     */
    public void setPackageDownloadBlockSize(Integer blockSize) {
        if (blockSize != null) {
            getMetrics().put(PackageAppProperties.PACKAGE_DOWNLOAD_BLOCK_SIZE, blockSize);
        }
    }

    /**
     * See {@link AdvancedPackageDownloadOptions#getBlockDelay()}
     *
     * @since 1.1.0
     */
    public Integer getPackageDownloadBlockDelay() {
        return (Integer) getMetrics().get(PackageAppProperties.PACKAGE_DOWNLOAD_BLOCK_DELAY);
    }

    /**
     * See {@link AdvancedPackageDownloadOptions#getBlockDelay()}
     *
     * @since 1.1.0
     */
    public void setPackageDownloadBlockDelay(Integer blockDelay) {
        if (blockDelay != null) {
            getMetrics().put(PackageAppProperties.PACKAGE_DOWNLOAD_BLOCK_DELAY, blockDelay);
        }
    }

    /**
     * See {@link AdvancedPackageDownloadOptions#getBlockTimeout()}
     *
     * @since 1.1.0
     */
    public Integer getPackageDownloadBlockTimeout() {
        return (Integer) getMetrics().get(PackageAppProperties.PACKAGE_DOWNLOAD_BLOCK_TIMEOUT);
    }

    /**
     * See {@link AdvancedPackageDownloadOptions#setBlockTimeout(Integer)}}
     *
     * @since 1.1.0
     */
    public void setPackageDownloadBlockTimeout(Integer blockTimeout) {
        if (blockTimeout != null) {
            getMetrics().put(PackageAppProperties.PACKAGE_DOWNLOAD_BLOCK_TIMEOUT, blockTimeout);
        }
    }

    /**
     * See {@link AdvancedPackageDownloadOptions#getBlockSize()}
     *
     * @since 1.1.0
     */
    public Integer getPackageDownloadNotifyBlockSize() {
        return (Integer) getMetrics().get(PackageAppProperties.PACKAGE_DOWNLOAD_NOTIFY_BLOCK_SIZE);
    }

    /**
     * See {@link AdvancedPackageDownloadOptions#setNotifyBlockSize(Integer)}
     *
     * @since 1.1.0
     */
    public void setPackageDownloadNotifyBlockSize(Integer notifyBlockSize) {
        if (notifyBlockSize != null) {
            getMetrics().put(PackageAppProperties.PACKAGE_DOWNLOAD_NOTIFY_BLOCK_SIZE, notifyBlockSize);
        }
    }

    /**
     * See {@link AdvancedPackageDownloadOptions#getInstallVerifierURI()}
     *
     * @since 1.1.0
     */
    public String getPackageDownloadInstallVerifierURI() {
        return (String) getMetrics().get(PackageAppProperties.PACKAGE_DOWNLOAD_INSTALL_VERIFIER_URI);
    }

    /**
     * See {@link AdvancedPackageDownloadOptions#setInstallVerifierURI(String)}
     *
     * @since 1.1.0
     */
    public void setPackageDownloadInstallVerifierURI(String installVerifierURI) {
        if (installVerifierURI != null) {
            getMetrics().put(PackageAppProperties.PACKAGE_DOWNLOAD_INSTALL_VERIFIER_URI, installVerifierURI);
        }
    }


    //
    // Install
    //

    /**
     * Get the package install name
     *
     * @return
     * @since 1.0.0
     */
    public String getPackageInstallName() {
        return (String) getMetrics().get(PackageAppProperties.PACKAGE_INSTALL_PACKAGE_NAME);
    }

    /**
     * Set the package install name
     *
     * @param packageName
     * @since 1.0.0
     */
    public void setPackageInstallName(String packageName) {
        if (packageName != null) {
            getMetrics().put(PackageAppProperties.PACKAGE_INSTALL_PACKAGE_NAME, packageName);
        }
    }

    /**
     * Get the package install version
     *
     * @return
     * @since 1.0.0
     */
    public String getPackageInstallVersion() {
        return (String) getMetrics().get(PackageAppProperties.PACKAGE_INSTALL_PACKAGE_VERSION);
    }

    /**
     * Set the package install version
     *
     * @param packageVersion
     * @since 1.0.0
     */
    public void setPackageInstallVersion(String packageVersion) {
        if (packageVersion != null) {
            getMetrics().put(PackageAppProperties.PACKAGE_INSTALL_PACKAGE_VERSION, packageVersion);
        }
    }

    //
    // Uninstall
    //

    /**
     * Get the package uninstall name
     *
     * @return
     * @since 1.0.0
     */
    public String getPackageUninstallName() {
        return (String) getMetrics().get(PackageAppProperties.PACKAGE_UNINSTALL_PACKAGE_NAME);
    }

    /**
     * Set the package uninstall name
     *
     * @param packageName
     * @since 1.0.0
     */
    public void setPackageUninstallName(String packageName) {
        if (packageName != null) {
            getMetrics().put(PackageAppProperties.PACKAGE_UNINSTALL_PACKAGE_NAME, packageName);
        }
    }

    /**
     * Get the package uninstall version
     *
     * @return
     * @since 1.0.0
     */
    public String getPackageUninstallVersion() {
        return (String) getMetrics().get(PackageAppProperties.PACKAGE_UNINSTALL_PACKAGE_VERSION);
    }

    /**
     * Set the package uninstall version
     *
     * @param packageVersion
     * @since 1.0.0
     */
    public void setPackageUninstallVersion(String packageVersion) {
        if (packageVersion != null) {
            getMetrics().put(PackageAppProperties.PACKAGE_UNINSTALL_PACKAGE_VERSION, packageVersion);
        }
    }

    //
    // Utility methods
    //

    /**
     * Get the is a download request flag
     *
     * @return
     * @since 1.0.0
     */
    public boolean isDownloadRequest() {
        return getPackageDownloadName() != null;
    }

    /**
     * Get the is an install request flag
     *
     * @return
     * @since 1.0.0
     */
    public boolean isInstallRequest() {
        return getPackageInstallName() != null;
    }

    /**
     * Get the is an uninstall request flag
     *
     * @return
     * @since 1.0.0
     */
    public boolean isUninstallRequest() {
        return getPackageUninstallName() != null;
    }
}
