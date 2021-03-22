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
package org.eclipse.kapua.service.device.management.commons.message;

import org.eclipse.kapua.message.internal.KapuaChannelImpl;
import org.eclipse.kapua.service.device.management.message.KapuaAppChannel;

/**
 * {@link KapuaAppChannel} implementation.
 *
 * @since 1.0.0
 */
public abstract class KapuaAppChannelImpl extends KapuaChannelImpl implements KapuaAppChannel {

    private static final long serialVersionUID = 3755325191379812125L;

    private String appName;
    private String appVersion;

    @Override
    public String getAppName() {
        return appName;
    }

    @Override
    public void setAppName(String appName) { // do I have to keep it as a KapuaAppProperties?
        this.appName = appName;
    }

    @Override
    public String getVersion() {
        return appVersion;
    }

    @Override
    public void setVersion(String appVersion) {
        this.appVersion = appVersion;
    }

}
