/*******************************************************************************
 * Copyright (c) 2020, 2021 Eurotech and/or its affiliates and others
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
package org.eclipse.kapua.integration.misc;

import org.eclipse.kapua.model.config.metatype.KapuaTad;
import org.eclipse.kapua.model.config.metatype.KapuaTdesignate;
import org.eclipse.kapua.model.config.metatype.KapuaTicon;
import org.eclipse.kapua.model.config.metatype.KapuaTmetadata;
import org.eclipse.kapua.model.config.metatype.KapuaTobject;
import org.eclipse.kapua.model.config.metatype.KapuaTocd;
import org.eclipse.kapua.model.config.metatype.KapuaToption;
import org.eclipse.kapua.model.config.metatype.MetatypeXmlFactory;
import org.eclipse.kapua.qa.markers.junit.JUnitTests;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

@Category(JUnitTests.class)
public class MetatypeXmlFactoryTest extends Assert {

    MetatypeXmlFactory metatypeXmlFactory;

    @Before
    public void createInstanceOfClass() {
        metatypeXmlFactory = new MetatypeXmlFactory();
    }

    @Test
    public void newKapuaTocdTest() {
        assertThat("Instance of KapuaTocd expected.", metatypeXmlFactory.newKapuaTocd(), IsInstanceOf.instanceOf(KapuaTocd.class));
    }

    @Test
    public void newKapuaTadTest() {
        assertThat("Instance of KapuaTad expected.", metatypeXmlFactory.newKapuaTad(), IsInstanceOf.instanceOf(KapuaTad.class));
    }

    @Test
    public void newKapuaTiconTest() {
        assertThat("Instance of KapuaTicon expected.", metatypeXmlFactory.newKapuaTicon(), IsInstanceOf.instanceOf(KapuaTicon.class));
    }

    @Test
    public void newKapuaToptionTest() {
        assertThat("Instance of KapuaToption expected.", metatypeXmlFactory.newKapuaToption(), IsInstanceOf.instanceOf(KapuaToption.class));
    }

    @Test
    public void newKapuaTmetadataTest() {
        assertThat("Instance of KapuaTmetadata expected.", metatypeXmlFactory.newKapuaTmetadata(), IsInstanceOf.instanceOf(KapuaTmetadata.class));
    }

    @Test
    public void newKapuaTdesignateTest() {
        assertThat("Instance of KapuaTdesignate expected.", metatypeXmlFactory.newKapuaTdesignate(), IsInstanceOf.instanceOf(KapuaTdesignate.class));
    }

    @Test
    public void newKapuaTobjectTest() {
        assertThat("Instance of KapuaTobject expected.", metatypeXmlFactory.newKapuaTobject(), IsInstanceOf.instanceOf(KapuaTobject.class));
    }
}
