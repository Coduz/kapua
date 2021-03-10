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
import org.eclipse.kapua.message.device.lifecycle.KapuaBirthChannel;
import org.eclipse.kapua.message.device.lifecycle.KapuaBirthMessage;
import org.eclipse.kapua.message.device.lifecycle.KapuaBirthMessageFactory;
import org.eclipse.kapua.message.device.lifecycle.KapuaBirthPayload;

/**
 * {@link KapuaBirthMessageFactory} implementation
 *
 * @since 1.0.0
 */
@KapuaProvider
public class KapuaBirthMessageFactoryImpl
        extends KapuaLifecycleMessageFactoryImpl<KapuaBirthChannel, KapuaBirthPayload, KapuaBirthMessage, KapuaBirthMessageFactory>
        implements KapuaBirthMessageFactory {

    /**
     * Constructor.
     *
     * @since 1.5.0
     */
    public KapuaBirthMessageFactoryImpl() {
        super(KapuaBirthMessageFactory.class);
    }
}
