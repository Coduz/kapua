/*******************************************************************************
 * Copyright (c) 2016, 2025 Eurotech and/or its affiliates and others
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
package org.eclipse.kapua.app.api.core.model;

import org.eclipse.kapua.commons.security.KapuaSecurityUtils;
import org.eclipse.kapua.commons.security.KapuaSession;
import org.eclipse.kapua.model.id.KapuaId;

import javax.validation.constraints.NotNull;
import javax.ws.rs.PathParam;
import java.math.BigInteger;
import java.util.Base64;

/**
 * {@link KapuaId} implementation to be used on REST API to parse the {@link PathParam} named 'scopeId'.
 * <p>
 * If the {@link PathParam} is equals to "_" the scopeId used will be set to {@link KapuaSession#getScopeId()} of {@link KapuaSecurityUtils#getSession()},
 * which means that the scope of the current request will be the same of the current session scope.
 *
 * @since 1.0.0
 */
public class ScopeId implements KapuaId {

    private static final long serialVersionUID = 6893262093856905182L;

    private BigInteger id;

    /**
     * Constructor.
     *
     * @param id The {@link BigInteger} representation of the {@link ScopeId}
     * @since 1.0.0
     * @deprecated Since 2.1.0. Use the other constructors.
     */
    @Deprecated
    public ScopeId(BigInteger id) {
        this.id = id;
    }

    /**
     * Constructor.
     *
     * @param kapuaId The {@link KapuaId} to parse
     * @since 2.1.0
     */
    public ScopeId(@NotNull KapuaId kapuaId) {
        setId(kapuaId.getId());
    }

    /**
     * Constructor.
     *
     * @param compactScopeId The {@link KapuaId} in compact form.
     * @since 2.1.0
     */
    public ScopeId(String compactScopeId) {
        byte[] bytes = Base64.getUrlDecoder().decode(compactScopeId);
        setId(new BigInteger(bytes));
    }

    @Override
    public BigInteger getId() {
        return id;
    }

    private void setId(BigInteger id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return KapuaId.toString(this);
    }

    @Override
    public int hashCode() {
        return KapuaId.hashCode(this);
    }

    @Override
    public boolean equals(Object obj) {
        return KapuaId.areEquals(this, obj);
    }
}
