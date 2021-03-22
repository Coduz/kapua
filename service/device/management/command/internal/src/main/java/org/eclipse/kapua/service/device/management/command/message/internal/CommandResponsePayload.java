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
package org.eclipse.kapua.service.device.management.command.message.internal;

import org.eclipse.kapua.service.device.management.command.DeviceCommand;
import org.eclipse.kapua.service.device.management.command.internal.CommandAppProperties;
import org.eclipse.kapua.service.device.management.commons.message.response.KapuaResponsePayloadImpl;
import org.eclipse.kapua.service.device.management.message.response.KapuaResponsePayload;

/**
 * {@link DeviceCommand} {@link KapuaResponsePayload} implementation.
 *
 * @since 1.0.0
 */
public class CommandResponsePayload extends KapuaResponsePayloadImpl implements KapuaResponsePayload {

    private static final long serialVersionUID = -7611654604657980851L;

    /**
     * Gets the command standard error.
     *
     * @return The command standard error.
     * @since 1.0.0
     */
    public String getStderr() {
        return (String) getMetrics().get(CommandAppProperties.STDERR);
    }

    /**
     * Sets the command standard error.
     *
     * @param stderr The command standard error.
     * @since 1.0.0
     */
    public void setStderr(String stderr) {
        getMetrics().put(CommandAppProperties.STDERR, stderr);
    }

    /**
     * Gets the command standard output.
     *
     * @return The command standard output.
     * @since 1.0.0
     */
    public String getStdout() {
        return (String) getMetrics().get(CommandAppProperties.STDOUT);
    }

    /**
     * Sets the command standard output.
     *
     * @param stdout The command standard output.
     */
    public void setStdout(String stdout) {
        getMetrics().put(CommandAppProperties.STDOUT, stdout);
    }

    /**
     * Get the command exit code
     *
     * @return
     * @since 1.0.0
     */
    public Integer getExitCode() {
        return (Integer) getMetrics().get(CommandAppProperties.EXIT_CODE);
    }

    /**
     * Get the command exit code
     *
     * @param exitCode
     * @since 1.0.0
     */
    public void setExitCode(Integer exitCode) {
        getMetrics().put(CommandAppProperties.EXIT_CODE, exitCode);
    }

    /**
     * Get the command execution timed out flag
     *
     * @return
     * @since 1.0.0
     */
    public Boolean hasTimedOut() {
        return (Boolean) getMetrics().get(CommandAppProperties.TIMED_OUT);
    }

    /**
     * Set the command execution timed out flag
     *
     * @param timedOut
     * @since 1.0.0
     */
    public void setTimedOut(boolean timedOut) {
        getMetrics().put(CommandAppProperties.TIMED_OUT, timedOut);
    }

}
