/*******************************************************************************
 * Copyright (c) 2017, 2021 Eurotech and/or its affiliates and others
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
package org.eclipse.kapua.commons.service.event.store.api;

import org.eclipse.kapua.model.KapuaEntityCreator;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "eventStoreRecordCreator")
@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(factoryClass = EventStoreXmlFactory.class, factoryMethod = "newCreator")
public interface EventStoreRecordCreator extends KapuaEntityCreator<EventStoreRecord> {

}
