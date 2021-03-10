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
package org.eclipse.kapua.service.device.management.request.message.response;

import org.eclipse.kapua.service.device.management.message.response.KapuaResponseMessage;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Generic {@link KapuaResponseMessage} definition.
 *
 * @since 1.0.0
 */
@XmlRootElement(name = "genericResponseMessage")
@XmlType(factoryClass = GenericResponseXmlFactory.class, factoryMethod = "newMessage")
public interface GenericResponseMessage extends KapuaResponseMessage<GenericResponseChannel, GenericResponsePayload> {

}
