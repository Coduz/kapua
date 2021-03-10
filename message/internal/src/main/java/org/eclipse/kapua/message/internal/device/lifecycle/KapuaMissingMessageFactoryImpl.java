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
import org.eclipse.kapua.message.device.lifecycle.KapuaMissingChannel;
import org.eclipse.kapua.message.device.lifecycle.KapuaMissingMessage;
import org.eclipse.kapua.message.device.lifecycle.KapuaMissingMessageFactory;
import org.eclipse.kapua.message.device.lifecycle.KapuaMissingPayload;

/**
 * {@link KapuaMissingMessageFactory} implementation
 *
 * @since 1.0.0
 */
@KapuaProvider
public class KapuaMissingMessageFactoryImpl
        extends KapuaLifecycleMessageFactoryImpl<KapuaMissingChannel, KapuaMissingPayload, KapuaMissingMessage, KapuaMissingMessageFactory>
        implements KapuaMissingMessageFactory {

    /**
     * Constructor.
     *
     * @since 1.5.0
     */
    public KapuaMissingMessageFactoryImpl() {
        super(KapuaMissingMessageFactory.class);
    }
}
