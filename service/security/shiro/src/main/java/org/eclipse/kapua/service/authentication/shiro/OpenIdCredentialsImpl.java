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
package org.eclipse.kapua.service.authentication.shiro;

import org.eclipse.kapua.service.authentication.OpenIdCredentials;
import org.eclipse.kapua.service.authentication.shiro.realm.KapuaAuthenticationToken;

import javax.validation.constraints.NotNull;
import java.util.Optional;

/**
 * {@link OpenIdCredentials} implementation.
 * <p>
 * This implements also {@link KapuaAuthenticationToken} to allow usage in Apache Shiro.
 *
 * @since 2.1.0
 */
public class OpenIdCredentialsImpl implements OpenIdCredentials, KapuaAuthenticationToken {

    private String accessToken;
    private String idToken;

    /**
     * Constructor.
     *
     * @param accessToken The credential access token
     * @param idToken     The credential id token.
     * @since 2.1.0
     */
    public OpenIdCredentialsImpl(String accessToken, String idToken) {
        setAccessToken(accessToken);
        setIdToken(idToken);
    }

    /**
     * Clone constructor.
     *
     * @param openIdCredentials The {@link OpenIdCredentials} to clone
     * @since 2.1.0
     */
    public OpenIdCredentialsImpl(@NotNull OpenIdCredentials openIdCredentials) {
        setAccessToken(openIdCredentials.getAccessToken());
        setIdToken(openIdCredentials.getIdToken());
    }

    @Override
    public String getAccessToken() {
        return accessToken;
    }

    @Override
    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    @Override
    public String getIdToken() {
        return idToken;
    }

    @Override
    public void setIdToken(String idToken) {
        this.idToken = idToken;
    }

    @Override
    public Object getPrincipal() {
        return getAccessToken();
    }

    @Override
    public Object getCredentials() {
        return getAccessToken();
    }

    @Override
    public Optional<String> getOpenIdToken() {
        return Optional.of(getIdToken());
    }
}
