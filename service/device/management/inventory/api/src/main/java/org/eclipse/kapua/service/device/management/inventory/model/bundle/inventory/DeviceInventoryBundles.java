/*******************************************************************************
 * Copyright (c) 2021 Eurotech and/or its affiliates and others
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
package org.eclipse.kapua.service.device.management.inventory.model.bundle.inventory;

import org.eclipse.kapua.KapuaSerializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

/**
 * {@link DeviceInventoryBundles} definition.
 *
 * @since 1.5.0
 */
@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlRootElement(name = "deviceInventoryBundles")
@XmlType(factoryClass = DeviceInventoryBundlesXmlFactory.class, factoryMethod = "newDeviceInventoryBundles")
public interface DeviceInventoryBundles extends KapuaSerializable {

    /**
     * Gets the {@link List} of {@link DeviceInventoryBundle}s
     *
     * @return The {@link List} of {@link DeviceInventoryBundle}s
     * @since 1.5.0
     */
    @XmlElement(name = "inventoryBundles")
    List<DeviceInventoryBundle> getInventoryBundles();

    /**
     * Adds a {@link DeviceInventoryBundle} to the {@link List}
     *
     * @param inventoryBundle The {@link DeviceInventoryBundle} to add.
     * @since 1.5.0
     */
    void addInventoryBundle(DeviceInventoryBundle inventoryBundle);

    /**
     * Sets the {@link List} of {@link DeviceInventoryBundle}s
     *
     * @param inventoryBundles The {@link List} of {@link DeviceInventoryBundle}s
     * @since 1.5.0
     */
    void setInventoryBundles(List<DeviceInventoryBundle> inventoryBundles);
}
