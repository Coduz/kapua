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
package org.eclipse.kapua.service.device.management.packages.model;

import org.eclipse.kapua.locator.KapuaLocator;
import org.eclipse.kapua.model.xml.KapuaXmlFactory;
import org.eclipse.kapua.service.device.management.packages.DevicePackageFactory;
import org.eclipse.kapua.service.device.management.packages.model.download.AdvancedPackageDownloadOptions;
import org.eclipse.kapua.service.device.management.packages.model.download.DevicePackageDownloadOperation;
import org.eclipse.kapua.service.device.management.packages.model.download.DevicePackageDownloadRequest;
import org.eclipse.kapua.service.device.management.packages.model.install.DevicePackageInstallOperation;
import org.eclipse.kapua.service.device.management.packages.model.uninstall.DevicePackageUninstallOperation;
import org.eclipse.kapua.service.device.management.packages.model.uninstall.DevicePackageUninstallRequest;

import javax.xml.bind.annotation.XmlRegistry;

/**
 * {@link DevicePackage}s {@link KapuaXmlFactory} implementation.
 *
 * @see KapuaXmlFactory
 * @since 1.0.0
 */
@XmlRegistry
public class DevicePackageXmlFactory implements KapuaXmlFactory {

    private static final KapuaLocator LOCATOR = KapuaLocator.getInstance();
    private static final DevicePackageFactory DEVICE_PACKAGE_FACTORY = LOCATOR.getFactory(DevicePackageFactory.class);

    /**
     * Instantiates a new {@link DevicePackage}.
     *
     * @return The newly instantiated {@link DevicePackage}.
     * @since 1.0.0
     */
    public DevicePackage newDevicePackage() {
        return DEVICE_PACKAGE_FACTORY.newDeviceDeploymentPackage();
    }

    /**
     * Instantiates a new {@link DevicePackages}.
     *
     * @return The newly instantiated {@link DevicePackages}.
     * @since 1.0.0
     */
    public DevicePackages newDevicePackages() {
        return DEVICE_PACKAGE_FACTORY.newDeviceDeploymentPackages();
    }

    /**
     * Instantiates a new {@link DevicePackageBundleInfo}.
     *
     * @return The newly instantiated {@link DevicePackageBundleInfo}.
     * @since 1.0.0
     */
    public DevicePackageBundleInfo newDevicePackageBundleInfo() {
        return DEVICE_PACKAGE_FACTORY.newDevicePackageBundleInfo();
    }

    /**
     * Instantiates a new {@link DevicePackageBundleInfos}
     *
     * @return The newly instantiated {@link DevicePackageBundleInfos}
     * @since 1.0.0
     */
    public DevicePackageBundleInfos newDevicePackageBundleInfos() {
        return DEVICE_PACKAGE_FACTORY.newDevicePackageBundleInfos();
    }

    /**
     * Instantiates a new {@link DevicePackageDownloadRequest}.
     *
     * @return The newly instantiated {@link DevicePackageDownloadRequest}
     * @since 1.0.0
     */
    public DevicePackageDownloadRequest newDevicePackageDownloadRequest() {
        return DEVICE_PACKAGE_FACTORY.newPackageDownloadRequest();
    }

    /**
     * Instantiates a new {@link AdvancedPackageDownloadOptions}
     *
     * @return The newly instantiated {@link AdvancedPackageDownloadOptions}
     * @since 1.1.0
     */
    public AdvancedPackageDownloadOptions newAdvancedPackageDownloadOptions() {
        return DEVICE_PACKAGE_FACTORY.newAdvancedPackageDownloadOptions();
    }

    /**
     * Instantiates a new {@link DevicePackageDownloadOperation}.
     *
     * @return The newly instantiated {@link DevicePackageDownloadOperation}.
     * @since 1.5.0
     */
    public DevicePackageDownloadOperation newDevicePackageDownloadOperation() {
        return DEVICE_PACKAGE_FACTORY.newPackageDownloadOperation();
    }

    /**
     * Instantiates a new {@link DevicePackageInstallOperation}.
     *
     * @return The newly instantiated {@link DevicePackageInstallOperation}.
     * @since 1.5.0
     */
    public DevicePackageInstallOperation newDevicePackageInstallOperation() {
        return DEVICE_PACKAGE_FACTORY.newPackageInstallOperation();
    }

    /**
     * Instantiates a new {@link DevicePackageUninstallRequest}
     *
     * @return The newly instantiated {@link DevicePackageUninstallRequest}
     * @since 1.0.0
     */
    public DevicePackageUninstallRequest newDevicePackageUninstallRequest() {
        return DEVICE_PACKAGE_FACTORY.newPackageUninstallRequest();
    }

    /**
     * Instantiates a new {@link DevicePackageUninstallOperation}.
     *
     * @return The newly instantiated {@link DevicePackageUninstallOperation}.
     * @since 1.5.0
     */
    public DevicePackageUninstallOperation newDevicePackageUninstallOperation() {
        return DEVICE_PACKAGE_FACTORY.newPackageUninstallOperation();
    }
}
