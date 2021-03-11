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

import org.eclipse.kapua.message.internal.KapuaPayloadImpl;
import org.eclipse.kapua.service.device.management.commons.setting.DeviceManagementSetting;
import org.eclipse.kapua.service.device.management.commons.setting.DeviceManagementSettingKey;
import org.eclipse.kapua.service.device.management.message.KapuaAppPayload;

/**
 * {@link KapuaAppPayload} implementation.
 *
 * @since 1.5.0
 */
public class KapuaAppPayloadImpl extends KapuaPayloadImpl implements KapuaAppPayload {

    private static final String CHAR_ENCODING = DeviceManagementSetting.getInstance().getString(DeviceManagementSettingKey.CHAR_ENCODING);

    /**
     * Gets the character encoding configured for the Device Management.
     * <p>
     * The value is get from {@link DeviceManagementSettingKey#CHAR_ENCODING} setting.
     *
     * @return The character encoding configured for the Device Management.
     * @since 1.5.0
     */
    protected String getCharEncoding() {
        return CHAR_ENCODING;
    }
}
