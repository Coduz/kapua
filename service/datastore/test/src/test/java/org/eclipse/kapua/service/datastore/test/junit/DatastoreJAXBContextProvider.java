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
package org.eclipse.kapua.service.datastore.test.junit;

import org.eclipse.kapua.KapuaException;
import org.eclipse.kapua.commons.configuration.metatype.TscalarImpl;
import org.eclipse.kapua.commons.util.xml.JAXBContextProvider;
import org.eclipse.kapua.model.config.metatype.KapuaTad;
import org.eclipse.kapua.model.config.metatype.KapuaTdesignate;
import org.eclipse.kapua.model.config.metatype.KapuaTicon;
import org.eclipse.kapua.model.config.metatype.KapuaTmetadata;
import org.eclipse.kapua.model.config.metatype.KapuaTobject;
import org.eclipse.kapua.model.config.metatype.KapuaTocd;
import org.eclipse.kapua.model.config.metatype.KapuaToption;
import org.eclipse.kapua.model.config.metatype.MetatypeXmlFactory;
import org.eclipse.persistence.jaxb.JAXBContextFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

public class DatastoreJAXBContextProvider implements JAXBContextProvider {

    private static final Logger logger = LoggerFactory.getLogger(DatastoreJAXBContextProvider.class);

    private JAXBContext context;

    @Override
    public JAXBContext getJAXBContext() throws KapuaException {
        if (context == null) {
            Class<?>[] classes = new Class<?>[]{
                    KapuaTmetadata.class,
                    KapuaTocd.class,
                    KapuaTad.class,
                    KapuaTicon.class,
                    TscalarImpl.class,
                    KapuaToption.class,
                    KapuaTmetadata.class,
                    KapuaTdesignate.class,
                    KapuaTobject.class,
                    MetatypeXmlFactory.class
            };
            try {
                context = JAXBContextFactory.createContext(classes, null);
            } catch (JAXBException jaxbException) {
                throw KapuaException.internalError(jaxbException, "Error creating JAXBContext, tests will fail!");
            }
        }
        return context;
    }
}
