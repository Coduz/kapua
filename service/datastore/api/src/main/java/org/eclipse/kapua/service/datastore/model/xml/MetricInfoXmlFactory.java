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
import org.eclipse.kapua.service.datastore.MetricInfoFactory;
import org.eclipse.kapua.service.datastore.model.MetricInfo;
import org.eclipse.kapua.service.datastore.model.MetricInfoCreator;
import org.eclipse.kapua.service.datastore.model.MetricInfoListResult;
import org.eclipse.kapua.service.datastore.model.query.MetricInfoQuery;
import org.eclipse.kapua.service.storable.model.xml.XmlStorableFactory;

import javax.xml.bind.annotation.XmlRegistry;

/**
 * {@link MetricInfo} {@link KapuaXmlFactory} implementation.
 *
 * @see KapuaXmlFactory
 * @since 1.0.0
 */
@XmlRegistry
public class MetricInfoXmlFactory extends XmlStorableFactory<MetricInfo, MetricInfoCreator<?>, MetricInfoQuery, MetricInfoListResult, MetricInfoFactory> implements KapuaXmlFactory {

    /**
     * Constructor.
     *
     * @since 1.5.0
     */
    public MetricInfoXmlFactory() {
        super(MetricInfoFactory.class);
    }
}
