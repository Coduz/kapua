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
package org.eclipse.kapua.service.device.management.commons.message;

import org.eclipse.kapua.message.internal.KapuaMessageImpl;
import org.eclipse.kapua.service.device.management.message.KapuaAppChannel;
import org.eclipse.kapua.service.device.management.message.KapuaAppMessage;
import org.eclipse.kapua.service.device.management.message.KapuaAppPayload;

/**
 * {@link KapuaAppMessage} implementation.
 *
 * @param <C> The {@link KapuaAppChannel} type.
 * @param <P> The {@link KapuaAppPayload} type.
 * @since 1.5.0
 */
public class KapuaAppMessageImpl<C extends KapuaAppChannel, P extends KapuaAppPayload> extends KapuaMessageImpl<C, P> implements KapuaAppMessage<C, P> {
}
