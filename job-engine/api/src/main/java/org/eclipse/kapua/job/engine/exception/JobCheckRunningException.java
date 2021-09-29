/*******************************************************************************
 * Copyright (c) 2018, 2021 Eurotech and/or its affiliates and others
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
package org.eclipse.kapua.job.engine.exception;

import org.eclipse.kapua.job.engine.JobEngineService;
import org.eclipse.kapua.model.id.KapuaId;
import org.eclipse.kapua.service.job.Job;

import javax.validation.constraints.NotNull;

/**
 * Exception to {@code throw} when {@link JobEngineService#isRunning(KapuaId, KapuaId)} fails.
 *
 * @since 1.0.0
 */
public class JobCheckRunningException extends JobScopedEngineException {

    private static final long serialVersionUID = -2502188601968533816L;

    /**
     * Constructor.
     *
     * @param cause   The original {@link Throwable}.
     * @param scopeId The {@link Job#getScopeId()}
     * @param jobId   The {@link Job#getId()}
     * @since 1.0.0
     */
    public JobCheckRunningException(@NotNull Throwable cause, @NotNull KapuaId scopeId, @NotNull KapuaId jobId) {
        super(JobEngineErrorCodes.JOB_CHECK_RUNNING, cause, scopeId, jobId);
    }
}
