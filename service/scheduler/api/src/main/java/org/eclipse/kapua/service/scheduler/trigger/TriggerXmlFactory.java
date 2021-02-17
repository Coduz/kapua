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
package org.eclipse.kapua.service.scheduler.trigger;

import org.eclipse.kapua.locator.KapuaLocator;
import org.eclipse.kapua.model.xml.KapuaXmlFactory;
import org.eclipse.kapua.model.xml.XmlEntityFactory;
import org.eclipse.kapua.service.scheduler.trigger.definition.TriggerProperty;

import javax.xml.bind.annotation.XmlRegistry;

/**
 * {@link Trigger} {@link KapuaXmlFactory} implementation.
 *
 * @see KapuaXmlFactory
 * @since 1.0.0
 */
@XmlRegistry
public class TriggerXmlFactory extends XmlEntityFactory<Trigger, TriggerCreator, TriggerQuery, TriggerListResult, TriggerFactory> implements KapuaXmlFactory {

    private static final KapuaLocator LOCATOR = KapuaLocator.getInstance();
    private static final TriggerFactory TRIGGER_FACTORY = LOCATOR.getFactory(TriggerFactory.class);

    /**
     * Constructor.
     *
     * @since 1.5.0
     */
    public TriggerXmlFactory() {
        super(KapuaLocator.getInstance().getFactory(TriggerFactory.class));
    }

    /**
     * Instantiates a new {@link TriggerProperty}.
     *
     * @return The newly instantiated {@link TriggerProperty}
     * @since 1.5.0
     */
    public TriggerProperty newTriggerProperty() {
        return TRIGGER_FACTORY.newTriggerProperty(null, null, null);
    }

}
