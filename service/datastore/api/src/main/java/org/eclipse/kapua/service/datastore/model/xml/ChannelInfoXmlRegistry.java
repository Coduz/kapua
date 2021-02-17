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
import org.eclipse.kapua.service.datastore.ChannelInfoFactory;
import org.eclipse.kapua.service.datastore.model.ChannelInfo;
import org.eclipse.kapua.service.datastore.model.ChannelInfoListResult;
import org.eclipse.kapua.service.datastore.model.query.ChannelInfoQuery;

import javax.xml.bind.annotation.XmlRegistry;

/**
 * {@link ChannelInfo} {@link KapuaXmlFactory} implementation.
 *
 * @see KapuaXmlFactory
 * @since 1.0.0
 */
@XmlRegistry
public class ChannelInfoXmlRegistry implements KapuaXmlFactory {

    private static final KapuaLocator LOCATOR = KapuaLocator.getInstance();
    private static final ChannelInfoFactory CHANNEL_INFO_FACTORY = LOCATOR.getFactory(ChannelInfoFactory.class);

    /**
     * Instantiates a new {@link ChannelInfoListResult}.
     *
     * @return The newly instantiated {@link ChannelInfoListResult}.
     * @since 1.0.0
     */
    public ChannelInfoListResult newListResult() {
        return CHANNEL_INFO_FACTORY.newListResult();
    }

    /**
     * Instantiates a new {@link ChannelInfoQuery}.
     *
     * @return The newly instantiated {@link ChannelInfoQuery}.
     * @since 1.0.0
     */
    public ChannelInfoQuery newQuery() {
        return CHANNEL_INFO_FACTORY.newQuery(null);
    }
}
