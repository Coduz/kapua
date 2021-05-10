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
package org.eclipse.kapua.message.internal;

import org.eclipse.kapua.locator.KapuaLocator;
import org.eclipse.kapua.message.Channel;
import org.eclipse.kapua.message.Message;
import org.eclipse.kapua.message.MessageFactory;
import org.eclipse.kapua.message.Payload;

/**
 * Base {@link MessageFactory} implementation.
 *
 * @param <C> The {@link Channel} type.
 * @param <P> The {@link Payload} type.
 * @param <M> The {@link Message} type.
 * @param <F> The {@link MessageFactory} type.
 * @since 1.5.0
 */
public abstract class MessageFactoryImpl<C extends Channel, P extends Payload, M extends Message<C, P>, F extends MessageFactory<C, P, M>>
        implements MessageFactory<C, P, M> {

    private final Class<F> messageFactoryClass;
    private F messageFactory;

    /**
     * Constructor.
     *
     * @param messageFactoryClass The {@link MessageFactory} type.
     * @since 1.5.0
     */
    public MessageFactoryImpl(Class<F> messageFactoryClass) {
        this.messageFactoryClass = messageFactoryClass;
    }

    @Override
    public C newChannel() {
        return getMessageFactory().newChannel();
    }

    @Override
    public P newPayload() {
        return getMessageFactory().newPayload();
    }

    @Override
    public M newMessage() {
        return getMessageFactory().newMessage();
    }

    /**
     * Gets the implementing instance of {@link #messageFactoryClass}.
     *
     * @return The implementing instance of {@link #messageFactoryClass}.
     * @since 1.5.0
     */
    private synchronized F getMessageFactory() {
        if (messageFactory == null) {
            initMessageFactory();
        }

        return messageFactory;
    }

    /**
     * Initializes the @{@link MessageFactory}.
     *
     * @since 1.5.0
     */
    private synchronized void initMessageFactory() {
        if (messageFactory == null) {
            messageFactory = KapuaLocator.getInstance().getFactory(messageFactoryClass);
        }
    }
}
