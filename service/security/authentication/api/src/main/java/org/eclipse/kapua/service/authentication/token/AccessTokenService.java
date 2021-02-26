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

import org.eclipse.kapua.KapuaException;
import org.eclipse.kapua.model.id.KapuaId;
import org.eclipse.kapua.service.KapuaEntityService;
import org.eclipse.kapua.service.KapuaUpdatableEntityService;
import org.eclipse.kapua.service.authentication.AuthenticationService;
import org.eclipse.kapua.service.user.User;

/**
 * {@link AccessToken} {@link KapuaEntityService} defintion.
 *
 * @since 1.0.0
 */
public interface AccessTokenService extends KapuaEntityService<AccessToken, AccessTokenCreator>, KapuaUpdatableEntityService<AccessToken> {

    /**
     * Find all access token associated with the given userId.
     *
     * @param scopeId The scope {@link KapuaId} in which to search.
     * @param userId  The {@link User#getId()} to search.
     * @return The {@link AccessTokenListResult} that matches the given parameters.
     * @throws KapuaException
     * @since 1.0.0
     */
    AccessTokenListResult findByUserId(KapuaId scopeId, KapuaId userId) throws KapuaException;

    /**
     * Find the access token by the given tokenId.
     *
     * @param tokenId The {@link AccessToken#getTokenId()} to search.
     * @return The matching {@link AccessToken} or {@code null} if not found.
     * @throws KapuaException
     * @since 1.0.0
     */
    AccessToken findByTokenId(String tokenId) throws KapuaException;

    /**
     * Invalidated the {@link AccessToken} by its id. After calling this method the token will be no longer valid and a new
     * {@link AuthenticationService#login(org.eclipse.kapua.service.authentication.LoginCredentials)} invocation is required in order to get a new valid {@link AccessToken}.
     *
     * @param scopeId The {@link KapuaId} scopeId of the {@link AccessToken} to delete.
     * @param id      The {@link KapuaId} of the {@link AccessToken} to delete.
     * @since 1.0.0
     */
    void invalidate(KapuaId scopeId, KapuaId id) throws KapuaException;
}
