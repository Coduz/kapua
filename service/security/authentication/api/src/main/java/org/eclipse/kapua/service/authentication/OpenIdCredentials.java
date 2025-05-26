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
package org.eclipse.kapua.service.authentication;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * OpenID {@link LoginCredentials} definition.
 *
 * @since 2.1.0
 */
@XmlRootElement(name = "openIdCredentials")
@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(factoryClass = AuthenticationXmlRegistry.class, factoryMethod = "newOpenIdCredentials")
public interface OpenIdCredentials extends LoginCredentials {

    /**
     * Gets the OpenID Connect <a href="https://auth0.com/blog/id-token-access-token-what-is-the-difference/#What-Is-an-Access-Token">accessToken</a>.
     *
     * @return The OpenID Connect accessToken.
     * @since 2.1.0
     */
    @XmlElement(name = "accessToken")
    String getAccessToken();

    /**
     * Set the OpenID Connect accessToken.
     *
     * @param accessToken The OpenID Connect accessToken.
     * @since 2.1.0
     */
    void setAccessToken(String accessToken);

    /**
     * Gets the OpenID Connect <a href="https://auth0.com/blog/id-token-access-token-what-is-the-difference/#What-Is-an-ID-Token">idToken</a>.
     *
     * @return The OpenID Connect idToken.
     * @since 2.1.0
     */
    @XmlElement(name = "idToken")
    String getIdToken();

    /**
     * Set the OpenID Connect idToken.
     *
     * @param idToken The OpenID Connect idToken.
     * @since 2.1.0
     */
    void setIdToken(String idToken);
}
