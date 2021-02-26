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
package org.eclipse.kapua.model.config.metatype;

import org.eclipse.kapua.locator.KapuaLocator;
import org.eclipse.kapua.model.xml.KapuaXmlFactory;

/**
 * Metatype {@link KapuaXmlFactory} implementation.
 *
 * @see KapuaXmlFactory
 * @since 1.0.0
 */
public class MetatypeXmlFactory implements KapuaXmlFactory {

    private final static KapuaLocator KAPUA_LOCATOR = KapuaLocator.getInstance();
    private final static KapuaMetatypeFactory KAPUA_METATYPE_FACTORY = KAPUA_LOCATOR.getFactory(KapuaMetatypeFactory.class);


    /**
     * Instantiates a new {@link KapuaTocd}.
     *
     * @return
     */
    public KapuaTocd newKapuaTocd() {
        return KAPUA_METATYPE_FACTORY.newKapuaTocd();
    }

    /**
     * Instantiates a new {@link KapuaTad}.
     *
     * @return
     */
    public KapuaTad newKapuaTad() {
        return KAPUA_METATYPE_FACTORY.newKapuaTad();
    }

    /**
     * Returns a {@link KapuaTicon} instance
     *
     * @return
     */
    public KapuaTicon newKapuaTicon() {
        return KAPUA_METATYPE_FACTORY.newKapuaTicon();
    }

    /**
     * Returns a {@link KapuaToption} instance
     *
     * @return
     */
    public KapuaToption newKapuaToption() {
        return KAPUA_METATYPE_FACTORY.newKapuaToption();
    }

    /**
     * Returns a {@link KapuaTmetadata} instance
     *
     * @return
     */
    public KapuaTmetadata newKapuaTmetadata() {
        return KAPUA_METATYPE_FACTORY.newKapuaTmetadata();
    }

    /**
     * Returns a {@link KapuaTdesignate} instance
     *
     * @return
     */
    public KapuaTdesignate newKapuaTdesignate() {
        return KAPUA_METATYPE_FACTORY.newKapuaTdesignate();
    }

    /**
     * Returns a {@link KapuaTobject} instance
     *
     * @return
     */
    public KapuaTobject newKapuaTobject() {
        return KAPUA_METATYPE_FACTORY.newKapuaTobject();
    }
}
