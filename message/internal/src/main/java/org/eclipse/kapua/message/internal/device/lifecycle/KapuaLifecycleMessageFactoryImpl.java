/*******************************************************************************
 * Copyright (c) 2019, 2021 Eurotech and/or its affiliates and others
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
package org.eclipse.kapua.message.internal.device.lifecycle;

import org.eclipse.kapua.locator.KapuaProvider;
import org.eclipse.kapua.message.KapuaMessageFactory;
import org.eclipse.kapua.message.device.lifecycle.KapuaLifecycleChannel;
import org.eclipse.kapua.message.device.lifecycle.KapuaLifecycleMessage;
import org.eclipse.kapua.message.device.lifecycle.KapuaLifecycleMessageFactory;
import org.eclipse.kapua.message.device.lifecycle.KapuaLifecyclePayload;
import org.eclipse.kapua.message.internal.MessageFactoryImpl;

/**
 * {@link KapuaMessageFactory} implementation.
 *
 * @since 1.1.0
 */
@KapuaProvider
public abstract class KapuaLifecycleMessageFactoryImpl<C extends KapuaLifecycleChannel, P extends KapuaLifecyclePayload, M extends KapuaLifecycleMessage<C, P>, F extends KapuaLifecycleMessageFactory<C, P, M>>
        extends MessageFactoryImpl<C, P, M, F> implements KapuaLifecycleMessageFactory<C, P, M> {

    /**
     * Constructor.
     *
     * @param messageFactoryClass The {@link KapuaLifecycleMessageFactory} type.
     * @since 1.5.0
     */
    public KapuaLifecycleMessageFactoryImpl(Class<F> messageFactoryClass) {
        super(messageFactoryClass);
    }
}
