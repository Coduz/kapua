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
package org.eclipse.kapua.service.endpoint;

import org.eclipse.kapua.locator.KapuaLocator;
import org.eclipse.kapua.model.xml.KapuaXmlFactory;
import org.eclipse.kapua.model.xml.XmlEntityFactory;

import javax.xml.bind.annotation.XmlRegistry;

/**
 * {@link EndpointInfo} {@link KapuaXmlFactory} implementation.
 *
 * @see KapuaXmlFactory
 * @since 1.0.0
 */
@XmlRegistry
public class EndpointInfoXmlFactory extends XmlEntityFactory<EndpointInfo, EndpointInfoCreator, EndpointInfoQuery, EndpointInfoListResult, EndpointInfoFactory> implements KapuaXmlFactory {

    /**
     * Constructor.
     *
     * @since 1.5.0
     */
    public EndpointInfoXmlFactory() {
        super(KapuaLocator.getInstance().getFactory(EndpointInfoFactory.class));
    }

    /**
     * Instantiates a new {@link EndpointUsage}.
     *
     * @return The newly instantiated {@link EndpointUsage}.
     * @since 1.0.0
     */
    public EndpointUsage newEndpointUsage() {
        return getFactory().newEndpointUsage(null);
    }
}
