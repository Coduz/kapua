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
package org.eclipse.kapua.service.device.management.request.message.request;

import org.eclipse.kapua.message.MessageXmlFactory;
import org.eclipse.kapua.model.xml.KapuaXmlFactory;

import javax.xml.bind.annotation.XmlRegistry;

/**
 * {@link GenericRequestMessage} {@link KapuaXmlFactory} implementation.
 *
 * @see KapuaXmlFactory
 * @since 1.0.0
 */
@XmlRegistry
public class GenericRequestXmlFactory
        extends MessageXmlFactory<GenericRequestChannel, GenericRequestPayload, GenericRequestMessage, GenericRequestFactory>
        implements KapuaXmlFactory {

    /**
     * Constructor.
     *
     * @since 1.5.0
     */
    public GenericRequestXmlFactory() {
        super(GenericRequestFactory.class);
    }
}
