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
package org.eclipse.kapua.model.xml;

import org.eclipse.kapua.model.KapuaEntity;
import org.eclipse.kapua.model.KapuaEntityCreator;
import org.eclipse.kapua.model.KapuaEntityFactory;
import org.eclipse.kapua.model.query.KapuaListResult;
import org.eclipse.kapua.model.query.KapuaQuery;

import javax.validation.constraints.NotNull;

/**
 * Base {@link KapuaXmlFactory} for {@link KapuaEntity}es implementation.
 *
 * @param <E> The {@link KapuaEntity} for which this {@link XmlEntityFactory} is for.
 * @param <C> The {@link KapuaEntityCreator} for which this {@link XmlEntityFactory} is for.
 * @param <Q> The {@link KapuaQuery} for which this {@link XmlEntityFactory} is for.
 * @param <L> The {@link KapuaListResult} for which this {@link XmlEntityFactory} is for.
 * @param <F> The {@link KapuaEntityFactory} for which this {@link XmlEntityFactory} is for.
 * @since 1.5.0
 */
public abstract class XmlEntityFactory<E extends KapuaEntity, C extends KapuaEntityCreator<E>, Q extends KapuaQuery, L extends KapuaListResult<E>, F extends KapuaEntityFactory<E, C, Q, L>> implements KapuaXmlFactory {

    private final F kapuaEntityFactory;

    /**
     * Constructor.
     *
     * @param kapuaEntityFactory The {@link KapuaEntityFactory} to use to instantiate objects.
     * @since 1.5.0
     */
    protected XmlEntityFactory(@NotNull F kapuaEntityFactory) {
        this.kapuaEntityFactory = kapuaEntityFactory;
    }

    /**
     * Instantiates a new {@link KapuaEntity}.
     *
     * @return The newly instantiated {@link KapuaEntity}
     * @since 1.5.0
     */
    public E newEntity() {
        return kapuaEntityFactory.newEntity(null);
    }

    /**
     * Instantiates a new {@link KapuaEntityCreator}.
     *
     * @return The newly instantiated {@link KapuaEntityCreator}
     * @since 1.5.0
     */
    public C newCreator() {
        return kapuaEntityFactory.newCreator(null);
    }

    /**
     * Instantiates a new {@link KapuaQuery}.
     *
     * @return The newly instantiated {@link KapuaQuery}
     * @since 1.5.0
     */
    public Q newQuery() {
        return kapuaEntityFactory.newQuery(null);
    }

    /**
     * Instantiates a new {@link KapuaListResult}.
     *
     * @return The newly instantiated {@link KapuaListResult}
     * @since 1.5.0
     */
    public L newListResult() {
        return kapuaEntityFactory.newListResult();
    }

    /**
     * Gets the {@link KapuaEntityFactory} instance.
     *
     * @return The {@link KapuaEntityFactory} instance.
     * @since 1.5.0
     */
    public F getFactory() {
        return kapuaEntityFactory;
    }
}
