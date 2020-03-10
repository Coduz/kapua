/*******************************************************************************
 * Copyright (c) 2017, 2020 Eurotech and/or its affiliates and others
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Eurotech - initial API and implementation
 *******************************************************************************/
package org.eclipse.kapua.service.certificate.internal;

import org.eclipse.kapua.service.certificate.KeyUsage;
import org.eclipse.kapua.service.certificate.KeyUsageSetting;

import java.util.Objects;

public class KeyUsageSettingImpl implements KeyUsageSetting {

    private KeyUsage keyUsage;
    private boolean allowed;
    private Boolean kapuaAllowed;

    protected KeyUsageSettingImpl() {
    }

    public KeyUsageSettingImpl(KeyUsageSetting keyUsageSetting) {
        setKeyUsage(keyUsageSetting.getKeyUsage());
        setAllowed(keyUsageSetting.getAllowed());
        setKapuaAllowed(keyUsageSetting.getKapuaAllowed());
    }

    @Override
    public KeyUsage getKeyUsage() {
        return keyUsage;
    }

    @Override
    public void setKeyUsage(KeyUsage keyUsage) {
        this.keyUsage = keyUsage;
    }

    @Override
    public boolean getAllowed() {
        return allowed;
    }

    @Override
    public void setAllowed(boolean allowed) {
        this.allowed = allowed;
    }

    @Override
    public Boolean getKapuaAllowed() {
        return kapuaAllowed;
    }

    @Override
    public void setKapuaAllowed(Boolean kapuaAllowed) {
        this.kapuaAllowed = kapuaAllowed;
    }

    public static KeyUsageSettingImpl parse(KeyUsageSetting keyUsageSetting) {
        if (keyUsageSetting != null) {
            return keyUsageSetting instanceof KeyUsageSettingImpl ? (KeyUsageSettingImpl) keyUsageSetting : new KeyUsageSettingImpl(keyUsageSetting);
        }
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        KeyUsageSettingImpl that = (KeyUsageSettingImpl) o;
        return keyUsage == that.keyUsage;
    }

    @Override
    public int hashCode() {
        return Objects.hash(keyUsage);
    }
}
