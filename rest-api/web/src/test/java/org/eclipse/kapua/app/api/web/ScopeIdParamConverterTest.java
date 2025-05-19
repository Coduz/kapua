/*******************************************************************************
 * Copyright (c) 2021, 2022 Eurotech and/or its affiliates and others
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
package org.eclipse.kapua.app.api.web;

import org.eclipse.kapua.app.api.core.exception.SessionNotPopulatedException;
import org.eclipse.kapua.app.api.core.model.ScopeId;
import org.eclipse.kapua.commons.security.KapuaSecurityUtils;
import org.eclipse.kapua.commons.security.KapuaSession;
import org.eclipse.kapua.model.id.KapuaId;
import org.eclipse.kapua.qa.markers.junit.JUnitTests;
import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;

import java.math.BigInteger;
import java.util.Base64;

@Category(JUnitTests.class)
public class ScopeIdParamConverterTest {

    @Test(expected = NullPointerException.class)
    public void scopeIdNullTest() {
        new ScopeIdParamConverter().fromString(null);
    }

    @Test
    public void scopeIdEqualIdsTest() {
        final KapuaSession kapuaSession = Mockito.mock(KapuaSession.class);
        Mockito.when(kapuaSession.getScopeId()).thenReturn(KapuaId.ONE);

        KapuaSecurityUtils.setSession(kapuaSession);
        ScopeId scopeId = new ScopeIdParamConverter().fromString("_");

        Assert.assertEquals("Expected and actual values should be the same.", BigInteger.ONE, scopeId.getId());
    }

    @Test
    public void scopeIdDifferentIdsTest() {
        final ScopeId scopeId = new ScopeIdParamConverter().fromString("scopeID");

        Assert.assertEquals("Expected and actual values should be the same.", new BigInteger(Base64.getUrlDecoder().decode("scopeID")), scopeId.getId());
    }

    @Test(expected = SessionNotPopulatedException.class)
    public void scopeIdNullSessionTest() {
        KapuaSecurityUtils.clearSession();
        new ScopeIdParamConverter().fromString("_");
    }

    @Test
    public void setAndGetIdToStringTest() {
        final ScopeId scopeId = new ScopeIdParamConverter().fromString("AQ");

        Assert.assertEquals("Expected and actual values should be the same.", 1, scopeId.getId().intValue());
        Assert.assertEquals("Expected and actual values should be the same.", "1", scopeId.toString());
    }

    @Test(expected = NullPointerException.class)
    public void toStringNullIdTest() {
        new ScopeIdParamConverter().fromString(null);
    }


}