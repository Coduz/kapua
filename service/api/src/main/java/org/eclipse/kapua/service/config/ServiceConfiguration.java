/*******************************************************************************
 * Copyright (c) 2019, 2021 Eurotech and/or its affiliates and others
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
package org.eclipse.kapua.service.config;

import org.eclipse.kapua.KapuaSerializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

/**
 * {@link ServiceConfiguration} entity definition.
 *
 * @since 1.0.0
 */
@XmlRootElement(name = "configurations")
@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(factoryClass = ServiceConfigurationXmlFactory.class, factoryMethod = "newConfiguration")
public interface ServiceConfiguration extends KapuaSerializable {

    /**
     * Gets the {@link List} fof {@link ServiceComponentConfiguration}s.
     *
     * @return The {@link List} fof {@link ServiceComponentConfiguration}s.
     * @since 1.0.0
     */
    @XmlElement(name = "configuration")
    List<ServiceComponentConfiguration> getComponentConfigurations();
}
