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
package org.eclipse.kapua.message.internal;

import org.eclipse.kapua.message.KapuaChannel;
import org.eclipse.kapua.message.KapuaMessage;
import org.eclipse.kapua.message.KapuaMessageFactory;
import org.eclipse.kapua.message.KapuaPayload;
import org.eclipse.kapua.message.KapuaPosition;

/**
 * {@link KapuaMessageFactory} implementation.
 *
 * @since 1.0.0
 */
public abstract class KapuaMessageFactoryImpl<C extends KapuaChannel, P extends KapuaPayload, M extends KapuaMessage<C, P>, F extends KapuaMessageFactory<C, P, M>>
        extends MessageFactoryImpl<C, P, M, F>
        implements KapuaMessageFactory<C, P, M> {

    /**
     * Constructor.
     *
     * @param messageFactoryClass The {@link KapuaMessageFactory} type.
     * @since 1.5.0
     */
    public KapuaMessageFactoryImpl(Class<F> messageFactoryClass) {
        super(messageFactoryClass);
    }

    @Override
    public KapuaPosition newPosition() {
        return new KapuaPositionImpl();
    }
}
