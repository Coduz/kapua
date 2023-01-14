/*******************************************************************************
 * Copyright (c) 2016, 2022 Eurotech and/or its affiliates and others
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Red Hat
 *******************************************************************************/
package org.eclipse.kapua.commons.jpa;

/**
 * Jdbc url connection resolver service definition
 *
 * @since 1.0
 */
public interface JdbcConnectionUrlResolver {

    /**
     * Return the jdbc connection url
     *
     * @return test
     */
    String connectionUrl();

}
