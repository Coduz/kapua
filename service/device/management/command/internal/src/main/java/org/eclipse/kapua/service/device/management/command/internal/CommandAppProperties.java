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
 *******************************************************************************/
package org.eclipse.kapua.service.device.management.command.internal;

import org.eclipse.kapua.service.device.management.command.DeviceCommand;
import org.eclipse.kapua.service.device.management.message.KapuaAppProperties;

/**
 * {@link DeviceCommand} {@link KapuaAppProperties} implementation.
 *
 * @since 1.0.0
 */
public class CommandAppProperties implements KapuaAppProperties {

    /**
     * Constructor.
     *
     * @since 1.5.0
     */
    private CommandAppProperties() {
    }

    /**
     * Application name.
     *
     * @since 1.0.0
     */
    public static final String APP_NAME = "COMMAND";

    /**
     * Application version.
     *
     * @since 1.0.0
     */
    public static final String APP_VERSION = "1.0.0";

    // Request
    /**
     * Command.
     *
     * @since 1.0.0
     */
    public static final String CMD = "cmd.command";

    /**
     * Arguments.
     *
     * @since 1.0.0
     */
    public static final String ARG = "cmd.arguments";

    /**
     * Environment.
     *
     * @since 1.0.0
     */
    public static final String ENVP = "cmd.environment.pair";
    /**
     * Working directory.
     *
     * @since 1.0.0
     */
    public static final String DIR = "cmd.working.directory";
    /**
     * Standard input.
     *
     * @since 1.0.0
     */
    public static final String STDIN = "cmd.stdin";
    /**
     * Command timeout.
     *
     * @since 1.0.0
     */
    public static final String TOUT = "cmd.timeout";
    /**
     * Asynchronous running.
     *
     * @since 1.0.0
     */
    public static final String ASYNC = "cmd.run.async";
    /**
     * Password.
     *
     * @since 1.0.0
     */
    public static final String PASSWORD = "cmd.password";

    // Response
    /**
     * Standard error.
     *
     * @since 1.0.0
     */
    public static final String STDERR = "cmd.stderr";
    /**
     * Standard output.
     *
     * @since 1.0.0
     */
    public static final String STDOUT = "cmd.stdout";
    /**
     * Command exit code.
     *
     * @since 1.0.0
     */
    public static final String EXIT_CODE = "cmd.exit.code";
    /**
     * Command timed out flag.
     *
     * @since 1.0.0
     */
    public static final String TIMED_OUT = "cmd.timed.out";

}
