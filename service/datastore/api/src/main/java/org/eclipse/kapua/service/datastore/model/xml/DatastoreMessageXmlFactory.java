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

import org.eclipse.kapua.model.xml.KapuaXmlFactory;
import org.eclipse.kapua.service.datastore.MessageStoreFactory;
import org.eclipse.kapua.service.datastore.model.DatastoreMessage;
import org.eclipse.kapua.service.datastore.model.MessageListResult;
import org.eclipse.kapua.service.datastore.model.query.MessageQuery;
import org.eclipse.kapua.service.storable.model.xml.XmlStorableFactory;

import javax.xml.bind.annotation.XmlRegistry;

/**
 * {@link DatastoreMessage} {@link KapuaXmlFactory} implementation.
 *
 * @see KapuaXmlFactory
 * @since 1.0.0
 */
@XmlRegistry
public class DatastoreMessageXmlFactory extends XmlStorableFactory<DatastoreMessage, MessageQuery, MessageListResult, MessageStoreFactory> implements KapuaXmlFactory {

    public DatastoreMessageXmlFactory() {
        super(MessageStoreFactory.class);
    }
}
