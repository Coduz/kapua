/*******************************************************************************
 * Copyright (c) 2021 Eurotech and/or its affiliates and others
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
package org.eclipse.kapua.app.api.core.exception.mapper;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.eclipse.kapua.KapuaErrorCodes;
import org.eclipse.kapua.job.engine.exception.JobEngineException;
import org.eclipse.kapua.app.api.core.exception.model.JobEngineExceptionInfo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Provider
public class JobEngineExceptionMapper implements ExceptionMapper<JobEngineException> {

    private static final Logger LOG = LoggerFactory.getLogger(JobEngineExceptionMapper.class);

    @Override
    public Response toResponse(JobEngineException jobEngineException) {
        LOG.error("Job Engine Generic Exception", jobEngineException);
        return Response//
                       .status(Status.INTERNAL_SERVER_ERROR) //
                       .entity(new JobEngineExceptionInfo(Status.INTERNAL_SERVER_ERROR, KapuaErrorCodes.INTERNAL_ERROR, jobEngineException)) //
                       .build();
    }

}