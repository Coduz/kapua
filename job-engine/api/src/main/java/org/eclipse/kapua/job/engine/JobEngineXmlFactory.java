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
package org.eclipse.kapua.job.engine;

import org.eclipse.kapua.locator.KapuaLocator;
import org.eclipse.kapua.model.xml.KapuaXmlFactory;

/**
 * {@link JobEngineService} {@link KapuaXmlFactory} implementation.
 *
 * @since 1.5.0
 */
public class JobEngineXmlFactory implements KapuaXmlFactory {

    private static final JobEngineFactory JOB_ENGINE_FACTORY = KapuaLocator.getInstance().getFactory(JobEngineFactory.class);

    /**
     * Instantiates a new {@link JobStartOptions}.
     *
     * @return The newly instantiated {@link JobStartOptions}
     * @since 1.5.0
     */
    public JobStartOptions newJobStartOptions() {
        return JOB_ENGINE_FACTORY.newJobStartOptions();
    }
}
