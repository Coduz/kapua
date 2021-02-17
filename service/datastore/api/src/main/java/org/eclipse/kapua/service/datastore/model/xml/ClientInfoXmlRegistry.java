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
package org.eclipse.kapua.service.datastore.model.xml;

import org.eclipse.kapua.locator.KapuaLocator;
import org.eclipse.kapua.model.xml.KapuaXmlFactory;
import org.eclipse.kapua.service.datastore.ClientInfoFactory;
import org.eclipse.kapua.service.datastore.model.ClientInfo;
import org.eclipse.kapua.service.datastore.model.ClientInfoListResult;
import org.eclipse.kapua.service.datastore.model.query.ClientInfoQuery;

import javax.xml.bind.annotation.XmlRegistry;

/**
 * {@link ClientInfo} {@link KapuaXmlFactory} implementation.
 *
 * @see KapuaXmlFactory
 * @since 1.0.0
 */
@XmlRegistry
public class ClientInfoXmlRegistry implements KapuaXmlFactory {

    private static final KapuaLocator LOCATOR = KapuaLocator.getInstance();
    private static final ClientInfoFactory CLIENT_INFO_FACTORY = LOCATOR.getFactory(ClientInfoFactory.class);

    /**
     * Instantiates a new {@link ClientInfoListResult}.
     *
     * @return The newly instantiated {@link ClientInfoListResult}.
     * @since 1.0.0
     */
    public ClientInfoListResult newListResult() {
        return CLIENT_INFO_FACTORY.newListResult();
    }

    /**
     * Instantiates a new {@link ClientInfoQuery}.
     *
     * @return The newly instantiated {@link ClientInfoQuery}.
     * @since 1.0.0
     */
    public ClientInfoQuery newQuery() {
        return CLIENT_INFO_FACTORY.newQuery(null);
    }
}
