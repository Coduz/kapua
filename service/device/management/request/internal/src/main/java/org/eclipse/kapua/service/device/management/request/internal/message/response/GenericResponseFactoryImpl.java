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
package org.eclipse.kapua.service.device.management.request.internal.message.response;

import org.eclipse.kapua.locator.KapuaProvider;
import org.eclipse.kapua.message.internal.MessageFactoryImpl;
import org.eclipse.kapua.service.device.management.request.message.response.GenericResponseChannel;
import org.eclipse.kapua.service.device.management.request.message.response.GenericResponseFactory;
import org.eclipse.kapua.service.device.management.request.message.response.GenericResponseMessage;
import org.eclipse.kapua.service.device.management.request.message.response.GenericResponsePayload;

/**
 * {@link GenericResponseFactory} implementation.
 *
 * @since 1.0.0
 */
@KapuaProvider
public class GenericResponseFactoryImpl
        extends MessageFactoryImpl<GenericResponseChannel, GenericResponsePayload, GenericResponseMessage, GenericResponseFactory>
        implements GenericResponseFactory {

    /**
     * Constructor.
     *
     * @since 1.5.0
     */
    public GenericResponseFactoryImpl() {
        super(GenericResponseFactory.class);
    }
}
