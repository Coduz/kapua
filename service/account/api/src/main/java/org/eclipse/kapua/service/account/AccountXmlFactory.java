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
package org.eclipse.kapua.service.account;

import org.eclipse.kapua.locator.KapuaLocator;
import org.eclipse.kapua.model.xml.KapuaXmlFactory;
import org.eclipse.kapua.model.xml.XmlEntityFactory;

import javax.xml.bind.annotation.XmlRegistry;

/**
 * {@link Account} {@link KapuaXmlFactory} implementation.
 *
 * @see KapuaXmlFactory
 * @since 1.0.0
 */
@XmlRegistry
public class AccountXmlFactory extends XmlEntityFactory<Account, AccountCreator, AccountQuery, AccountListResult, AccountFactory> implements KapuaXmlFactory {

    /**
     * Constructor.
     *
     * @since 1.5.0
     */
    public AccountXmlFactory() {
        super(KapuaLocator.getInstance().getFactory(AccountFactory.class));
    }

    /**
     * Instantiates a new {@link Organization}.
     *
     * @return The newly instantiated {@link Organization}.
     * @since 1.5.0
     */
    public Organization newOrganization() {
        return getFactory().newOrganization();
    }
}
