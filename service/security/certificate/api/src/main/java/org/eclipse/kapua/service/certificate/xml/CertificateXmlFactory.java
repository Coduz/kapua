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
package org.eclipse.kapua.service.certificate.xml;

import org.eclipse.kapua.locator.KapuaLocator;
import org.eclipse.kapua.model.xml.KapuaXmlFactory;
import org.eclipse.kapua.model.xml.XmlEntityFactory;
import org.eclipse.kapua.service.certificate.Certificate;
import org.eclipse.kapua.service.certificate.CertificateCreator;
import org.eclipse.kapua.service.certificate.CertificateFactory;
import org.eclipse.kapua.service.certificate.CertificateGenerator;
import org.eclipse.kapua.service.certificate.CertificateListResult;
import org.eclipse.kapua.service.certificate.CertificateQuery;
import org.eclipse.kapua.service.certificate.CertificateUsage;

import javax.xml.bind.annotation.XmlRegistry;

/**
 * {@link Certificate} {@link KapuaXmlFactory} implementation.
 *
 * @see KapuaXmlFactory
 * @since 1.0.0
 */
@XmlRegistry
public class CertificateXmlFactory extends XmlEntityFactory<Certificate, CertificateCreator, CertificateQuery, CertificateListResult, CertificateFactory> implements KapuaXmlFactory {

    /**
     * Constructor.
     *
     * @since 1.5.0
     */
    public CertificateXmlFactory() {
        super(KapuaLocator.getInstance().getFactory(CertificateFactory.class));
    }

    /**
     * Instantiates a new {@link CertificateGenerator}.
     *
     * @return The nwely instantiated {@link CertificateGenerator}.
     * @since 1.0.0
     */
    public CertificateGenerator newCertificateGenerator() {
        return getFactory().newCertificateGenerator();
    }

    /**
     * Instantiates a new {@link CertificateUsage}.
     *
     * @return The nwely instantiated {@link CertificateUsage}.
     * @since 1.0.0
     */
    public CertificateUsage newCertificateUsage() {
        return getFactory().newCertificateUsage(null);
    }
}
