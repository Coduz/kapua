/*******************************************************************************
 * Copyright (c) 2017, 2022 Eurotech and/or its affiliates and others
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
package org.eclipse.kapua.model.id;

import java.math.BigInteger;

public final class KapuaIdImpl implements KapuaId {

    private static final long serialVersionUID = 8660393054811025101L;
    private final BigInteger id;

    /**
     * Constructor.
     *
     * @param id The {@link BigInteger} representation of the {@link KapuaId}.
     * @since 1.0.0
     * @deprecated Since 2.1.0. Use the other constructors.
     */
    @Deprecated
    public KapuaIdImpl(BigInteger id) {
        if (null == id) {
            throw new IllegalArgumentException();
        }

        this.id = id;
    }

    /**
     * Constructor.
     *
     * @param numericKapuaId The {@link KapuaId} in numeric form.
     * @since 2.1.0
     */
    public KapuaIdImpl(long numericKapuaId) {
        this.id = BigInteger.valueOf(numericKapuaId);
    }

    @Override
    public BigInteger getId() {
        return id;
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
