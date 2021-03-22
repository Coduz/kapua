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
package org.eclipse.kapua.translator.kura.kapua;

import org.eclipse.kapua.locator.KapuaLocator;
import org.eclipse.kapua.service.device.call.message.kura.app.response.KuraResponseChannel;
import org.eclipse.kapua.service.device.call.message.kura.app.response.KuraResponsePayload;
import org.eclipse.kapua.service.device.management.request.message.response.GenericResponseChannel;
import org.eclipse.kapua.service.device.management.request.message.response.GenericResponseFactory;
import org.eclipse.kapua.service.device.management.request.message.response.GenericResponseMessage;
import org.eclipse.kapua.service.device.management.request.message.response.GenericResponsePayload;
import org.eclipse.kapua.translator.exception.InvalidChannelException;
import org.eclipse.kapua.translator.exception.InvalidPayloadException;
import org.eclipse.kapua.translator.exception.TranslatorErrorCodes;
import org.eclipse.kapua.translator.exception.TranslatorException;

/**
 * {@link org.eclipse.kapua.translator.Translator} implementation from {@link org.eclipse.kapua.service.device.call.message.kura.app.response.KuraResponseMessage} to {@link GenericResponseMessage}
 *
 * @since 1.0.0
 */
public class TranslatorAppResponseKuraKapua extends AbstractSimpleTranslatorResponseKuraKapua<GenericResponseChannel, GenericResponsePayload, GenericResponseMessage> {

    private static final KapuaLocator LOCATOR = KapuaLocator.getInstance();

    /**
     * Constructor.
     *
     * @since 1.5.0
     */
    public TranslatorAppResponseKuraKapua() {
        super(GenericResponseMessage.class, GenericResponsePayload.class, GenericResponseFactory.class);
    }

    @Override
    protected GenericResponseChannel translateChannel(KuraResponseChannel kuraResponseChannel) throws InvalidChannelException {
        try {
            GenericResponseFactory genericRequestFactory = LOCATOR.getFactory(GenericResponseFactory.class);

            if (!getControlMessageClassifier().equals(kuraResponseChannel.getMessageClassification())) {
                throw new TranslatorException(TranslatorErrorCodes.INVALID_CHANNEL_CLASSIFIER, null, kuraResponseChannel.getMessageClassification());
            }

            GenericResponseChannel genericResponseChannel = genericRequestFactory.newChannel();
            String[] appIdTokens = kuraResponseChannel.getAppId().split("-");

            if (appIdTokens.length < 1) {
                throw new TranslatorException(TranslatorErrorCodes.INVALID_CHANNEL_APP_NAME, null, (Object) appIdTokens);
            }

            genericResponseChannel.setAppName(appIdTokens[0]);
            if (appIdTokens.length > 1) {
                genericResponseChannel.setVersion(appIdTokens[1]);
            }

            return genericResponseChannel;
        } catch (Exception e) {
            throw new InvalidChannelException(e, kuraResponseChannel);
        }
    }

    @Override
    protected GenericResponsePayload translatePayload(KuraResponsePayload kuraResponsePayload) throws InvalidPayloadException {
        GenericResponsePayload genericResponsePayload = super.translatePayload(kuraResponsePayload);

        try {
            genericResponsePayload.setBody(kuraResponsePayload.getBody());
            genericResponsePayload.setMetrics(kuraResponsePayload.getMetrics());

            return genericResponsePayload;
        } catch (Exception e) {
            throw new InvalidPayloadException(e, kuraResponsePayload);
        }
    }
}
