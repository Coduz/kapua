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

import org.eclipse.kapua.model.KapuaNamedEntity;
import org.eclipse.kapua.model.xml.DateXmlAdapter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;
import java.util.List;

/**
 * {@link Account} {@link org.eclipse.kapua.model.KapuaEntity} definition.
 *
 * @since 1.0.0
 */
@XmlRootElement(name = "account")
@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(factoryClass = AccountXmlFactory.class, factoryMethod = "newEntity")
public interface Account extends KapuaNamedEntity {

    String TYPE = "account";

    @Override
    default String getType() {
        return TYPE;
    }

    /**
     * Gets the account's {@link Organization}
     *
     * @return the account's {@link Organization}
     * @since 1.0.0
     */
    @XmlElement(name = "organization")
    Organization getOrganization();

    /**
     * Sets the account's {@link Organization}
     *
     * @param organization the account's {@link Organization}
     * @since 1.0.0
     */
    void setOrganization(Organization organization);

    /**
     * Return the parent account path
     * <p>
     * The account path is a '/' separated list of the parents {@link Account} identifiers in reverse order (so it should be read from right to left).<br>
     * e.g. The parent account path 7/14/15 means that the current account has 15 as parent, then 15 has 14 as parent and 14 has 7 as parent.
     *
     * @return the parent account path
     * @since 1.0.0
     */
    @XmlElement(name = "parentAccountPath")
    String getParentAccountPath();

    /**
     * Set the parent account path
     * <p>
     * The account path is a '/' separated list of the parents {@link Account} identifiers in reverse order (so it should be read from right to left).<br>
     * e.g. The parent account path 7/14/15 means that the current account has 15 as parent, then 15 has 14 as parent and 14 has 7 as parent.
     *
     * @param parentAccountPath the parent account path
     * @since 1.0.0
     */
    void setParentAccountPath(String parentAccountPath);


    /**
     * Gets the expiration date
     *
     * @return the expiration date
     * @since 1.0.0
     */
    @XmlElement(name = "expirationDate")
    @XmlJavaTypeAdapter(DateXmlAdapter.class)
    Date getExpirationDate();

    /**
     * Sets the expiration date
     *
     * @param expirationDate the expiration date
     * @since 1.0.0
     */
    void setExpirationDate(Date expirationDate);

    /**
     * Gets the {@link List} of {@link Account} that are children of this {@link Account}
     *
     * @return the {@link List} of {@link Account} that are children of this {@link Account}
     * @since 1.0.0
     */
    List<Account> getChildAccounts();

}
