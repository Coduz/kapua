/*******************************************************************************
 * Copyright (c) 2025, 2025 Eurotech and/or its affiliates and others
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
package org.eclipse.kapua.service.authentication.shiro.realm;

import com.google.common.base.Strings;
import org.eclipse.kapua.service.authentication.AuthenticationCredentials;
import org.eclipse.kapua.service.authentication.OpenIdCredentials;
import org.eclipse.kapua.service.authentication.exception.KapuaAuthenticationErrorCodes;
import org.eclipse.kapua.service.authentication.exception.KapuaAuthenticationException;
import org.eclipse.kapua.service.authentication.shiro.OpenIdCredentialsImpl;

/**
 * {@link OpenIdCredentials} {@link CredentialsConverter} implementation.
 *
 * @since 2.1.0
 */
public class OpenIdCredentialsConverter implements CredentialsConverter {

    @Override
    public boolean canProcess(AuthenticationCredentials authenticationCredentials) {
        return authenticationCredentials instanceof OpenIdCredentials;
    }

    @Override
    public KapuaAuthenticationToken convertToShiro(AuthenticationCredentials authenticationCredentials) throws KapuaAuthenticationException {

        OpenIdCredentialsImpl openIdCredentials = authenticationCredentials instanceof OpenIdCredentialsImpl ?
                (OpenIdCredentialsImpl) authenticationCredentials :
                new OpenIdCredentialsImpl((OpenIdCredentials) authenticationCredentials);

        if (Strings.isNullOrEmpty(openIdCredentials.getIdToken())) {
            throw new KapuaAuthenticationException(KapuaAuthenticationErrorCodes.INVALID_LOGIN_CREDENTIALS);
        }

        return openIdCredentials;
    }
}
