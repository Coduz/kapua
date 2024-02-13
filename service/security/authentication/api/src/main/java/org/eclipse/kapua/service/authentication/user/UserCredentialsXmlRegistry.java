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
 *     Eurotech - initial API and implementation
 *******************************************************************************/
package org.eclipse.kapua.service.authentication.user;

import org.eclipse.kapua.locator.KapuaLocator;

import javax.xml.bind.annotation.XmlRegistry;

@XmlRegistry
public class UserCredentialsXmlRegistry {

    private final UserCredentialsFactory userCredentialsFactory = KapuaLocator.getInstance().getFactory(UserCredentialsFactory.class);


    /**
     * Creates a new credential instance
     *
     * @return
     */
    public PasswordChangeRequest newPasswordChangeRequest() {
        return userCredentialsFactory.newPasswordChangeRequest();
    }


    /**
     * Creates a new reset password request
     *
     * @return
     */
    public PasswordResetRequest newPasswordResetRequest() {
        return userCredentialsFactory.newPasswordResetRequest();
    }

}
