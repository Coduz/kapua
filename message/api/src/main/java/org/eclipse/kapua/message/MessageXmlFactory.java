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

import org.eclipse.kapua.locator.KapuaLocator;
import org.eclipse.kapua.model.xml.KapuaXmlFactory;

/**
 * {@link Message} {@link KapuaXmlFactory} definition.
 *
 * @param <C> The {@link Channel} type.
 * @param <P> The {@link Payload} type.
 * @param <M> The {@link Message} type.
 * @see KapuaXmlFactory
 * @since 1.5.0
 */
public abstract class MessageXmlFactory<C extends Channel, P extends Payload, M extends Message<C, P>, F extends MessageFactory<C, P, M>> implements KapuaXmlFactory {

    final F messageFactory;

    /**
     * Constructor.
     *
     * @param messageFactoryClass The {@link MessageFactory} type.
     * @since 1.5.0
     */
    public MessageXmlFactory(Class<F> messageFactoryClass) {
        messageFactory = KapuaLocator.getInstance().getFactory(messageFactoryClass);
    }

    /**
     * Instantiates a new {@link Channel}.
     *
     * @return The newly instantiated {@link Channel}
     * @since 1.5.0
     */
    public C newChannel() {
        return messageFactory.newChannel();
    }

    /**
     * Instantiates a new {@link Payload}.
     *
     * @return The newly instantiated {@link Payload}
     * @since 1.5.0
     */
    public P newPayload() {
        return messageFactory.newPayload();
    }

    /**
     * Instantiates a new {@link Message}.
     *
     * @return The newly instantiated {@link Message}
     * @since 1.5.0
     */
    public M newMessage() {
        return messageFactory.newMessage();
    }

    /**
     * Gets the {@link MessageFactory} instance.
     *
     * @return The {@link MessageFactory} instance.
     * @since 1.5.0
     */
    public F getFactory() {
        return messageFactory;
    }
}
