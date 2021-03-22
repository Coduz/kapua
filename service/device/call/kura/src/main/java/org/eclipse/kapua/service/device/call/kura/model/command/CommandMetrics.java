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
 *      Eurotech - initial API and implementation
 *******************************************************************************/
package org.eclipse.kapua.service.device.call.kura.model.command;

import org.eclipse.kapua.service.device.call.message.app.DeviceAppMetrics;

/**
 * Command {@link DeviceAppMetrics} implementation.
 *
 * @since 1.0.0
 */
public class CommandMetrics implements DeviceAppMetrics {

    private CommandMetrics() {
    }

    /**
     * Application identifier.
     *
     * @since 1.0.0
     */
    public static final String APP_ID = "CMD";

    /**
     * Application version.
     *
     * @since 1.0.0
     */
    public static final String APP_VERSION = "V1";

    // Request

    /**
     * Command metric name.
     *
     * @since 1.0.0
     */
    public static final String METRIC_CMD = "command.command";

    /**
     * Arguments metric name.
     *
     * @since 1.0.0
     */
    public static final String METRIC_ARG = "command.argument";

    /**
     * Environment metric name.
     *
     * @since 1.0.0
     */
    public static final String METRIC_ENV_PAIR = "command.environment.pair";

    /**
     * Working directory metric name.
     *
     * @since 1.0.0
     */
    public static final String METRIC_WORKING_DIR = "command.working.directory";

    /**
     * Standard input metric name.
     *
     * @since 1.0.0
     */
    public static final String METRIC_STDIN = "command.stdin";

    /**
     * Command timeout metric name.
     *
     * @since 1.0.0
     */
    public static final String METRIC_TIMEOUT = "command.timeout";

    /**
     * Asynchronous running metric name.
     *
     * @since 1.0.0
     */
    public static final String METRIC_RUN_ASYNC = "command.run.async";

    /**
     * Password metric name.
     *
     * @since 1.0.0
     */
    public static final String METRIC_PASSWORD = "command.password";

    // Response
    /**
     * Standard error metric name.
     *
     * @since 1.0.0
     */
    public static final String METRIC_STDERR = "command.stderr";

    /**
     * Standard output metric name.
     *
     * @since 1.0.0
     */
    public static final String METRIC_STDOUT = "command.stdout";

    /**
     * Command exit code metric name.
     *
     * @since 1.0.0
     */
    public static final String METRIC_EXIT_CODE = "command.exit.code";

    /**
     * Command timed out flag metric name.
     *
     * @since 1.0.0
     */
    public static final String METRIC_TIMEDOUT = "command.timedout";
}
