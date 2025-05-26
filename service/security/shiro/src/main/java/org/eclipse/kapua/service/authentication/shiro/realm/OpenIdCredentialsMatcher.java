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

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.eclipse.kapua.plugin.sso.openid.JwtProcessor;
import org.eclipse.kapua.service.authentication.credential.Credential;
import org.eclipse.kapua.service.authentication.shiro.OpenIdCredentialsImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.constraints.NotNull;

/**
 * {@link OpenIdCredentialsMatcher} credential matcher implementation
 *
 * @since 2.1.0
 */
public class OpenIdCredentialsMatcher implements CredentialsMatcher {

    private static final Logger logger = LoggerFactory.getLogger(OpenIdCredentialsMatcher.class);
    private JwtProcessor jwtProcessor;

    public OpenIdCredentialsMatcher(@NotNull final JwtProcessor jwtProcessor) {
        this.jwtProcessor = jwtProcessor;
    }

    @Override
    public boolean doCredentialsMatch(AuthenticationToken authenticationToken, AuthenticationInfo authenticationInfo) {

        final String idToken = ((OpenIdCredentialsImpl) authenticationToken).getIdToken();
        if (idToken == null) {
            // we don't have a OpenId idToken
            return false;
        }

        // Check for correct credentials type

        final Object credentialsValue = authenticationInfo.getCredentials();
        if (!(credentialsValue instanceof Credential)) {
            return false;
        }

        // Extract credentials
        final Credential credentials = (Credential) credentialsValue;

        // Match token with info
        if (!idToken.equals(credentials.getCredentialKey())) {
            return false;
        }

        try {
            // Validate the OpenId idToken
            return this.jwtProcessor.validate(idToken);
        } catch (Exception e) {
            logger.error("Error while validating OpenId credentials", e);
        }

        return false;
    }

}
