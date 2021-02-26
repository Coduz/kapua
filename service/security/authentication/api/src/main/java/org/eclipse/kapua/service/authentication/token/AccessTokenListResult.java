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
package org.eclipse.kapua.service.authentication.token;

import org.eclipse.kapua.model.query.KapuaListResult;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * {@link AccessToken} {@link KapuaListResult} definition.
 *
 * @since 1.0.0
 */
@XmlRootElement(name = "accessTokenListResult")
@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(factoryClass = AccessTokenXmlFactory.class, factoryMethod = "newListResult")
public interface AccessTokenListResult extends KapuaListResult<AccessToken> {

}
