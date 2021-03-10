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

import org.eclipse.kapua.service.device.management.commons.message.request.KapuaRequestChannelImpl;
import org.eclipse.kapua.service.device.management.message.request.KapuaRequestChannel;
import org.eclipse.kapua.service.device.management.packages.model.DevicePackage;

import java.util.Collections;
import java.util.List;

/**
 * {@link DevicePackage} {@link KapuaRequestChannel} implementation.
 *
 * @since 1.0.0
 */
public class PackageRequestChannel extends KapuaRequestChannelImpl implements KapuaRequestChannel {

    private static final long serialVersionUID = -2326105340676100128L;

    private PackageResource packageResource;

    /**
     * Gets the package resource.
     *
     * @return The package resource.
     * @since 1.0.0
     */
    public PackageResource getPackageResource() {
        return packageResource;
    }

    /**
     * Sets the package resource.
     *
     * @param packageResource The package resource.
     * @since 1.0.0
     */
    public void setPackageResource(PackageResource packageResource) {
        this.packageResource = packageResource;
    }

    @Override
    public List<String> getSemanticParts() {
        return Collections.singletonList(packageResource.name());
    }
}
