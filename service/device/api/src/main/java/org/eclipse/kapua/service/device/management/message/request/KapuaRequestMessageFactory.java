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
package org.eclipse.kapua.service.device.management.message.request;

import org.eclipse.kapua.message.MessageFactory;
import org.eclipse.kapua.service.device.management.message.KapuaAppProperties;

/**
 * {@link KapuaRequestMessage} {@link MessageFactory} definition.
 *
 * @since 1.0.0
 */
public interface KapuaRequestMessageFactory<C extends KapuaRequestChannel, P extends KapuaRequestPayload, M extends KapuaRequestMessage<C, P>>
        extends MessageFactory<C, P, M> {

    /**
     * Instantiates a new {@link KapuaAppProperties}.
     *
     * @return The newly instantiated {@link KapuaAppProperties}.
     * @since 1.0.0
     */
    KapuaAppProperties newAppProperties(String value);
}
