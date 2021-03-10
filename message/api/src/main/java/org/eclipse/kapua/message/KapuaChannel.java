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
 *     Red Hat Inc
 *******************************************************************************/
package org.eclipse.kapua.message;

import java.util.List;

/**
 * {@link KapuaChannel} definition.
 *
 * @since 1.0.0
 */
public interface KapuaChannel extends Channel {

    /**
     * Get the channel destination semantic part
     *
     * @return
     * @since 1.0.0
     */
    List<String> getSemanticParts();

    /**
     * Set the channel destination semantic part
     *
     * @param semanticParts
     * @since 1.0.0
     */
    void setSemanticParts(List<String> semanticParts);

    /**
     * @return
     * @since 1.0.0
     */
    default String toPathString() {
        return String.join("/", getSemanticParts());
    }
}
