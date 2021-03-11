/*******************************************************************************
 * Copyright (c) 2017, 2021 Eurotech and/or its affiliates and others
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
package org.eclipse.kapua.service.device.management.commons.message.request;

import org.eclipse.kapua.locator.KapuaProvider;
import org.eclipse.kapua.message.internal.MessageFactoryImpl;
import org.eclipse.kapua.service.device.management.commons.KapuaAppPropertiesImpl;
import org.eclipse.kapua.service.device.management.message.KapuaAppProperties;
import org.eclipse.kapua.service.device.management.message.request.KapuaRequestChannel;
import org.eclipse.kapua.service.device.management.message.request.KapuaRequestMessageFactory;
import org.eclipse.kapua.service.device.management.message.request.KapuaRequestPayload;

/**
 * {@link KapuaRequestMessageFactory} implementation.
 *
 * @since 1.0.0
 */
@KapuaProvider
public class KapuaRequestMessageFactoryImpl<C extends KapuaRequestChannel, P extends KapuaRequestPayload, M extends KapuaRequestMessageImpl<C, P>, F extends KapuaRequestMessageFactory<C, P, M>>
        extends MessageFactoryImpl<C, P, M, F>
        implements KapuaRequestMessageFactory<C, P, M> {

    /**
     * Constructor.
     *
     * @param messageFactoryClass The {@link KapuaRequestMessageFactory} type.
     * @since 1.5.0
     */
    public KapuaRequestMessageFactoryImpl(Class<F> messageFactoryClass) {
        super(messageFactoryClass);
    }

    @Override
    public KapuaAppProperties newAppProperties(String value) {
        return new KapuaAppPropertiesImpl(value);
    }
}
