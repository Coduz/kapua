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
package org.eclipse.kapua.message;

import org.eclipse.kapua.model.KapuaObjectFactory;

/**
 * {@link Message} {@link KapuaObjectFactory} definition.
 *
 * @param <C> The {@link Channel} type.
 * @param <P> The {@link Payload} type.
 * @param <M> The {@link Message} type.
 * @see KapuaObjectFactory
 * @since 1.5.0
 */
public interface MessageFactory<C extends Channel, P extends Payload, M extends Message<?, ?>> extends KapuaObjectFactory {

    /**
     * Instantiates a new {@link Channel}.
     *
     * @return The newly instantiated {@link Channel}
     * @since 1.5.0
     */
    C newChannel();

    /**
     * Instantiates a new {@link Payload}.
     *
     * @return The newly instantiated {@link Payload}
     * @since 1.5.0
     */
    P newPayload();

    /**
     * Instantiates a new {@link Message}.
     *
     * @return The newly instantiated {@link Message}
     * @since 1.5.0
     */
    M newMessage();
}
