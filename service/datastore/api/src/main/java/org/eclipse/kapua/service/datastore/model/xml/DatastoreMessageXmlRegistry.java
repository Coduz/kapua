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
import org.eclipse.kapua.service.datastore.MessageStoreFactory;
import org.eclipse.kapua.service.datastore.model.DatastoreMessage;
import org.eclipse.kapua.service.datastore.model.MessageListResult;
import org.eclipse.kapua.service.datastore.model.query.MessageQuery;

import javax.xml.bind.annotation.XmlRegistry;

/**
 * {@link DatastoreMessage} {@link KapuaXmlFactory} implementation.
 *
 * @see KapuaXmlFactory
 * @since 1.0.0
 */
@XmlRegistry
public class DatastoreMessageXmlRegistry implements KapuaXmlFactory {

    private static final KapuaLocator LOCATOR = KapuaLocator.getInstance();
    private static final MessageStoreFactory MESSAGE_STORE_FACTORY = LOCATOR.getFactory(MessageStoreFactory.class);

    /**
     * Instantiates a new {@link MessageListResult}.
     *
     * @return The newly instantiated {@link MessageListResult}
     * @since 1.0.0
     */
    public MessageListResult newListResult() {
        return MESSAGE_STORE_FACTORY.newListResult();
    }

    /**
     * Instantiates a new {@link MessageQuery}.
     *
     * @return The newly instantiated {@link MessageQuery}
     * @since 1.0.0
     */
    public MessageQuery newQuery() {
        return MESSAGE_STORE_FACTORY.newQuery(null);
    }
}
