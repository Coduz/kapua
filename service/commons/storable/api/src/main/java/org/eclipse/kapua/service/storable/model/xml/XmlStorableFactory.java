/*******************************************************************************
 * Copyright (c) 2021 Eurotech and/or its affiliates and others
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
package org.eclipse.kapua.service.storable.model.xml;

import org.eclipse.kapua.locator.KapuaLocator;
import org.eclipse.kapua.model.xml.KapuaXmlFactory;
import org.eclipse.kapua.service.storable.StorableFactory;
import org.eclipse.kapua.service.storable.model.Storable;
import org.eclipse.kapua.service.storable.model.StorableListResult;
import org.eclipse.kapua.service.storable.model.query.StorableQuery;

/**
 * Base {@link KapuaXmlFactory} for  {@link Storable}s implementation.
 *
 * @since 1.5.0
 */
public abstract class XmlStorableFactory<S extends Storable, Q extends StorableQuery, L extends StorableListResult<S>, F extends StorableFactory<S, L, Q>> implements KapuaXmlFactory {

    final F storableFactory;

    /**
     * Constructor.
     *
     * @param factoryClass The {@link StorableFactory} {@code class} to use to instantiate {@link Storable}s.
     * @since 1.5.0
     */
    public XmlStorableFactory(Class<F> factoryClass) {
        this.storableFactory = KapuaLocator.getInstance().getFactory(factoryClass);
    }

    /**
     * Instantiates a new {@link Storable}.
     *
     * @return The newly instantiated {@link Storable}.
     * @since 1.5.0
     */
    public S newEntity() {
        return storableFactory.newStorable();
    }

    /**
     * Instantiates a new {@link StorableListResult}.
     *
     * @return The newly instantiated {@link StorableListResult}.
     * @since 1.5.0
     */
    public L newListResult() {
        return storableFactory.newListResult();
    }

    /**
     * Instantiates a new {@link StorableQuery}.
     *
     * @return The newly instantiated {@link StorableQuery}.
     * @since 1.5.0
     */
    public Q newQuery() {
        return storableFactory.newQuery(null);
    }
}
