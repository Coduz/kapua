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
 *     Red Hat Inc
 *******************************************************************************/
package org.eclipse.kapua.service.datastore.internal.model;

import org.eclipse.kapua.model.id.KapuaId;
import org.eclipse.kapua.service.datastore.model.DatastoreMessageCreator;

/**
 * {@link DatastoreMessageCreator} implementation.
 *
 * @since 1.5.0
 */
public class DatastoreMessageCreatorImpl implements DatastoreMessageCreator {

    private KapuaId scopeId;

    /**
     * Constructor.
     *
     * @param scopeId The {@link DatastoreMessageCreator#getScopeId()}.
     * @since 1.5.0
     */
    public DatastoreMessageCreatorImpl(KapuaId scopeId) {
        this.scopeId = scopeId;
    }

    @Override
    public KapuaId getScopeId() {
        return scopeId;
    }

    @Override
    public void setScopeId(KapuaId scopeId) {
        this.scopeId = scopeId;
    }
}
