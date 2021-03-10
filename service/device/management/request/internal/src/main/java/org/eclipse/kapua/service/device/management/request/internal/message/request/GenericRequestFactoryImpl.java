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
 *******************************************************************************/
package org.eclipse.kapua.service.device.management.request.internal.message.request;

import org.eclipse.kapua.locator.KapuaProvider;
import org.eclipse.kapua.message.internal.MessageFactoryImpl;
import org.eclipse.kapua.service.device.management.request.message.request.GenericRequestChannel;
import org.eclipse.kapua.service.device.management.request.message.request.GenericRequestFactory;
import org.eclipse.kapua.service.device.management.request.message.request.GenericRequestMessage;
import org.eclipse.kapua.service.device.management.request.message.request.GenericRequestPayload;

/**
 * {@link GenericRequestFactory} implementation.
 *
 * @since 1.0.0
 */
@KapuaProvider
public class GenericRequestFactoryImpl
        extends MessageFactoryImpl<GenericRequestChannel, GenericRequestPayload, GenericRequestMessage, GenericRequestFactory>
        implements GenericRequestFactory {

    /**
     * Constructor.
     *
     * @since 1.5.0
     */
    public GenericRequestFactoryImpl() {
        super(GenericRequestFactory.class);
    }
}
