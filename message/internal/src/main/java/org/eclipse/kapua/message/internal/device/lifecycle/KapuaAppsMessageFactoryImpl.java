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
 *     Red Hat Inc
 *******************************************************************************/
package org.eclipse.kapua.message.internal.device.lifecycle;

import org.eclipse.kapua.locator.KapuaProvider;
import org.eclipse.kapua.message.device.lifecycle.KapuaAppsChannel;
import org.eclipse.kapua.message.device.lifecycle.KapuaAppsMessage;
import org.eclipse.kapua.message.device.lifecycle.KapuaAppsMessageFactory;
import org.eclipse.kapua.message.device.lifecycle.KapuaAppsPayload;

/**
 * {@link KapuaAppsMessageFactory} implementation
 *
 * @since 1.0.0
 */
@KapuaProvider
public class KapuaAppsMessageFactoryImpl
        extends KapuaLifecycleMessageFactoryImpl<KapuaAppsChannel, KapuaAppsPayload, KapuaAppsMessage, KapuaAppsMessageFactory>
        implements KapuaAppsMessageFactory {

    /**
     * Constructor.
     *
     * @since 1.5.0
     */
    public KapuaAppsMessageFactoryImpl() {
        super(KapuaAppsMessageFactory.class);
    }
}
