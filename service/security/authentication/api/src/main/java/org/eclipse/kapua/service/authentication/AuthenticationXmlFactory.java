/*******************************************************************************
 * Copyright (c) 2016, 2021 Eurotech and/or its affiliates and others
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
package org.eclipse.kapua.service.authentication;

import org.eclipse.kapua.locator.KapuaLocator;
import org.eclipse.kapua.model.xml.KapuaXmlFactory;

/**
 * {@link AuthenticationCredentials} {@link KapuaXmlFactory} implementation.
 *
 * @since 1.0.0
 */
public class AuthenticationXmlFactory implements KapuaXmlFactory {

    private static final KapuaLocator LOCATOR = KapuaLocator.getInstance();
    private static final CredentialsFactory CREDENTIALS_FACTORY = LOCATOR.getFactory(CredentialsFactory.class);

    /**
     * Instatiates a new {@link UsernamePasswordCredentials}.
     *
     * @return The newly instantiated {@link UsernamePasswordCredentials}.
     * @since 1.0.0
     */
    public UsernamePasswordCredentials newUsernamePasswordCredentials() {
        return CREDENTIALS_FACTORY.newUsernamePasswordCredentials();
    }

    /**
     * Instatiates a new {@link ApiKeyCredentials}.
     *
     * @return The newly instantiated {@link ApiKeyCredentials}.
     * @since 1.0.0
     */
    public ApiKeyCredentials newApiKeyCredentials() {
        return CREDENTIALS_FACTORY.newApiKeyCredentials(null);
    }

    /**
     * Instatiates a new {@link JwtCredentials}.
     *
     * @return The newly instantiated {@link JwtCredentials}.
     * @since 1.0.0
     */
    public JwtCredentials newJwtCredentials() {
        return CREDENTIALS_FACTORY.newJwtCredentials(null, null);
    }

    /**
     * Instatiates a new {@link AccessTokenCredentials}.
     *
     * @return The newly instantiated {@link AccessTokenCredentials}.
     * @since 1.0.0
     */
    public AccessTokenCredentials newAccessTokenCredentials() {
        return CREDENTIALS_FACTORY.newAccessTokenCredentials(null);
    }

    /**
     * Instatiates a new {@link RefreshTokenCredentials}.
     *
     * @return The newly instantiated {@link RefreshTokenCredentials}.
     * @since 1.0.0
     */
    public RefreshTokenCredentials newRefreshTokenCredentials() {
        return CREDENTIALS_FACTORY.newRefreshTokenCredentials(null, null);
    }
}
