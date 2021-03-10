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
package org.eclipse.kapua.message;

/**
 * {@link KapuaMessage} {@link MessageFactory} definition.
 *
 * @since 1.0.0
 */
public interface KapuaMessageFactory<C extends KapuaChannel, P extends KapuaPayload, M extends KapuaMessage<C, P>> extends MessageFactory<C, P, M> {

    /**
     * Instantiates a new {@link KapuaPosition}
     *
     * @return The newly instantiated {@link KapuaPosition}
     * @since 1.0.0
     */
    KapuaPosition newPosition();
}
