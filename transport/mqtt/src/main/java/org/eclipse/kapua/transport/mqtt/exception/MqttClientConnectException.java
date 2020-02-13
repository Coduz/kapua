/*******************************************************************************
 * Copyright (c) 2020 Eurotech and/or its affiliates and others
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Eurotech - initial API and implementation
 *******************************************************************************/
package org.eclipse.kapua.transport.mqtt.exception;

import org.eclipse.kapua.transport.TransportClientConnectOptions;
import org.eclipse.kapua.transport.mqtt.MqttClient;

import java.net.URI;

/**
 * {@link Exception} to {@code throw} when the {@link MqttClient} cannot connect to the given URI with the given {@link TransportClientConnectOptions}
 *
 * @since 1.2.0
 */
public class MqttClientConnectException extends MqttClientException {

    final String uri;
    final String username;

    /**
     * Constructor.
     *
     * @param uri      The {@link URI} of the server which the {@link MqttClient} was connecting to.
     * @param clientId The clientId of the {@link org.eclipse.kapua.transport.mqtt.MqttClient} that produced this {@link MqttClientConnectException}.
     * @param username The username used to authenticate into the server.
     * @since 1.2.0
     */
    public MqttClientConnectException(URI uri, String clientId, String username) {
        this(null, uri != null ? uri.toString() : null, clientId, username);
    }

    /**
     * Constructor.
     *
     * @param cause    The root {@link Throwable} that caused the error.
     * @param uri      The {@link URI} of the server which the {@link MqttClient} was connecting to.
     * @param clientId The clientId of the {@link org.eclipse.kapua.transport.mqtt.MqttClient} that produced this {@link MqttClientConnectException}.
     * @param username The username used to authenticate into the server.
     * @since 1.2.0
     */
    public MqttClientConnectException(Throwable cause, String uri, String clientId, String username) {
        super(MqttClientErrorCodes.CONNECT_ERROR, cause, uri, clientId, username);

        this.uri = uri;
        this.username = username;
    }

    /**
     * Gets the {@link URI} in {@link String} from of the server which the {@link MqttClient} was connecting to.
     *
     * @return The {@link URI} in {@link String} from of the server which the {@link MqttClient} was connecting to.
     * @since 1.2.0
     */
    public String getUri() {
        return uri;
    }

    /**
     * Gets the username used to authenticate into the server.
     *
     * @return The username used to authenticate into the server.
     * @since 1.2.0
     */
    public String getUsername() {
        return username;
    }
}
