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
package org.eclipse.kapua.service.device.management.commons.message.request;

import org.eclipse.kapua.service.device.management.commons.message.KapuaAppPayloadImpl;
import org.eclipse.kapua.service.device.management.message.request.KapuaRequestPayload;

/**
 * {@link KapuaRequestPayload} implementation.
 *
 * @since 1.0.0
 */
public abstract class KapuaRequestPayloadImpl extends KapuaAppPayloadImpl implements KapuaRequestPayload {

    private static final long serialVersionUID = -7231317572182056724L;
}
