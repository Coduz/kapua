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
import org.eclipse.kapua.service.datastore.MetricInfoFactory;
import org.eclipse.kapua.service.datastore.model.MetricInfo;
import org.eclipse.kapua.service.datastore.model.MetricInfoListResult;
import org.eclipse.kapua.service.datastore.model.query.MetricInfoQuery;

import javax.xml.bind.annotation.XmlRegistry;

/**
 * {@link MetricInfo} {@link KapuaXmlFactory} implementation.
 *
 * @see KapuaXmlFactory
 * @since 1.0.0
 */
@XmlRegistry
public class MetricInfoXmlRegistry implements KapuaXmlFactory {

    private static final KapuaLocator LOCATOR = KapuaLocator.getInstance();
    private static final MetricInfoFactory METRIC_INFO_FACTORY = LOCATOR.getFactory(MetricInfoFactory.class);

    /**
     * Instantiates a new {@link MetricInfoListResult}.
     *
     * @return The newly instantiated {@link MetricInfoListResult}.
     * @since 1.0.0
     */
    public MetricInfoListResult newListResult() {
        return METRIC_INFO_FACTORY.newListResult();
    }

    /**
     * Instantiates a new {@link MetricInfoQuery}.
     *
     * @return The newly instantiated {@link MetricInfoQuery}.
     * @since 1.0.0
     */
    public MetricInfoQuery newQuery() {
        return METRIC_INFO_FACTORY.newQuery(null);
    }
}
