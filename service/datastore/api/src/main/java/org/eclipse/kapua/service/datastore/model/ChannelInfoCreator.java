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
package org.eclipse.kapua.service.datastore.model;

import org.eclipse.kapua.service.datastore.model.xml.ChannelInfoXmlFactory;
import org.eclipse.kapua.service.storable.model.StorableCreator;
import org.eclipse.kapua.service.storable.model.id.StorableId;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.Date;

/**
 * Channel information schema creator definition
 *
 * @since 1.0.0
 */
@XmlRootElement(name = "channelInfoCreator")
@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(factoryClass = ChannelInfoXmlFactory.class, factoryMethod = "newCreator")
public interface ChannelInfoCreator extends StorableCreator<ChannelInfo> {

    /**
     * Get the client identifier
     *
     * @return
     * @since 1.0.0
     */
    String getClientId();

    /**
     * @param clientId
     * @since 1.3.0
     */
    void setClientId(String clientId);

    /**
     * Get the name
     *
     * @return
     * @since 1.0.0
     */
    String getName();

    /**
     * Set the channel name
     *
     * @param name
     * @since 1.0.0
     */
    void setName(String name);

    /**
     * Get the message identifier (of the first message published on this channel)
     *
     * @return
     * @since 1.0.0
     */
    StorableId getMessageId();

    /**
     * Set the message identifier (of the first message published on this channel)
     *
     * @param messageId
     * @since 1.0.0
     */
    void setMessageId(StorableId messageId);

    /**
     * Get the message timestamp (of the first message published on this channel)
     *
     * @return
     * @since 1.0.0
     */
    Date getMessageTimestamp();

    /**
     * Set the message timestamp (of the first message published on this channel)
     *
     * @param messageTimestamp
     * @since 1.0.0
     */
    void setMessageTimestamp(Date messageTimestamp);
}
