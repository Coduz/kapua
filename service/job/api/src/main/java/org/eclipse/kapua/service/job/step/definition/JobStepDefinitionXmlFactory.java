/*******************************************************************************
 * Copyright (c) 2017, 2021 Eurotech and/or its affiliates and others
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
package org.eclipse.kapua.service.job.step.definition;

import org.eclipse.kapua.locator.KapuaLocator;
import org.eclipse.kapua.model.xml.KapuaXmlFactory;
import org.eclipse.kapua.model.xml.XmlEntityFactory;

import javax.xml.bind.annotation.XmlRegistry;

/**
 * {@link JobStepDefinition} {@link KapuaXmlFactory} implementation.
 *
 * @see KapuaXmlFactory
 * @since 1.0.0
 */
@XmlRegistry
public class JobStepDefinitionXmlFactory extends XmlEntityFactory<JobStepDefinition, JobStepDefinitionCreator, JobStepDefinitionQuery, JobStepDefinitionListResult, JobStepDefinitionFactory> implements KapuaXmlFactory {


    /**
     * Constructor.
     *
     * @since 1.5.0
     */
    public JobStepDefinitionXmlFactory() {
        super(KapuaLocator.getInstance().getFactory(JobStepDefinitionFactory.class));
    }

    /**
     * Instantiates a new {@link JobStepProperty}.
     *
     * @return The newly instantiated {@link JobStepProperty}.
     * @since 1.0.0
     */
    public JobStepProperty newJobStepProperty() {
        return getFactory().newStepProperty(null, null, null);
    }
}
