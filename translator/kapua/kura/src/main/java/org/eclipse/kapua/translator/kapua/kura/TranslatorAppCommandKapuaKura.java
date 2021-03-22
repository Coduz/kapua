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
package org.eclipse.kapua.translator.kapua.kura;

import org.eclipse.kapua.service.device.call.kura.model.command.CommandMetrics;
import org.eclipse.kapua.service.device.call.message.kura.app.request.KuraRequestChannel;
import org.eclipse.kapua.service.device.call.message.kura.app.request.KuraRequestMessage;
import org.eclipse.kapua.service.device.call.message.kura.app.request.KuraRequestPayload;
import org.eclipse.kapua.service.device.management.command.internal.CommandAppProperties;
import org.eclipse.kapua.service.device.management.command.message.internal.CommandRequestChannel;
import org.eclipse.kapua.service.device.management.command.message.internal.CommandRequestMessage;
import org.eclipse.kapua.service.device.management.command.message.internal.CommandRequestPayload;
import org.eclipse.kapua.translator.exception.InvalidChannelException;
import org.eclipse.kapua.translator.exception.InvalidPayloadException;

import java.util.HashMap;
import java.util.Map;

/**
 * {@link org.eclipse.kapua.translator.Translator} implementation from {@link CommandRequestMessage} to {@link KuraRequestMessage}
 *
 * @since 1.0
 */
public class TranslatorAppCommandKapuaKura extends AbstractTranslatorKapuaKura<CommandRequestChannel, CommandRequestPayload, CommandRequestMessage> {

    private static final Map<String, String> PROPERTIES_DICTIONARY = new HashMap<>();

    static {
        PROPERTIES_DICTIONARY.put(CommandAppProperties.CMD, CommandMetrics.METRIC_CMD);
        PROPERTIES_DICTIONARY.put(CommandAppProperties.ARG, CommandMetrics.METRIC_ARG);
        PROPERTIES_DICTIONARY.put(CommandAppProperties.ENVP, CommandMetrics.METRIC_ENV_PAIR);
        PROPERTIES_DICTIONARY.put(CommandAppProperties.DIR, CommandMetrics.METRIC_WORKING_DIR);
        PROPERTIES_DICTIONARY.put(CommandAppProperties.STDIN, CommandMetrics.METRIC_STDIN);
        PROPERTIES_DICTIONARY.put(CommandAppProperties.TOUT, CommandMetrics.METRIC_TIMEOUT);
        PROPERTIES_DICTIONARY.put(CommandAppProperties.ASYNC, CommandMetrics.METRIC_RUN_ASYNC);
        PROPERTIES_DICTIONARY.put(CommandAppProperties.PASSWORD, CommandMetrics.METRIC_PASSWORD);
    }

    @Override
    protected KuraRequestChannel translateChannel(CommandRequestChannel kapuaChannel) throws InvalidChannelException {
        try {
            KuraRequestChannel kuraRequestChannel = TranslatorKapuaKuraUtils.buildBaseRequestChannel(CommandMetrics.APP_ID, CommandMetrics.APP_VERSION, kapuaChannel.getMethod());
            kuraRequestChannel.setResources(new String[]{"command"});

            //
            // Return Kura Channel
            return kuraRequestChannel;
        } catch (Exception e) {
            throw new InvalidChannelException(e, kapuaChannel);
        }
    }

    @Override
    protected KuraRequestPayload translatePayload(CommandRequestPayload kapuaPayload) throws InvalidPayloadException {
        try {
            KuraRequestPayload kuraRequestPayload = new KuraRequestPayload();

            // Payload translation
            Map<String, Object> metrics = kuraRequestPayload.getMetrics();
            metrics.put(PROPERTIES_DICTIONARY.get(CommandAppProperties.CMD), kapuaPayload.getCommand());
            metrics.put(PROPERTIES_DICTIONARY.get(CommandAppProperties.ENVP), kapuaPayload.getEnvironmentPairs());
            metrics.put(PROPERTIES_DICTIONARY.get(CommandAppProperties.DIR), kapuaPayload.getWorkingDir());
            metrics.put(PROPERTIES_DICTIONARY.get(CommandAppProperties.STDIN), kapuaPayload.getStdin());
            metrics.put(PROPERTIES_DICTIONARY.get(CommandAppProperties.TOUT), kapuaPayload.getTimeout());
            metrics.put(PROPERTIES_DICTIONARY.get(CommandAppProperties.ASYNC), kapuaPayload.isRunAsync());
            metrics.put(PROPERTIES_DICTIONARY.get(CommandAppProperties.PASSWORD), kapuaPayload.getPassword());

            // argument translation
            int i = 0;
            String[] arguments = kapuaPayload.getArguments();
            for (String argument : arguments) {
                metrics.put(PROPERTIES_DICTIONARY.get(CommandAppProperties.ARG) + i++, argument);
            }

            // Body translation
            kuraRequestPayload.setBody(kapuaPayload.getBody());

            // Return Kura Payload
            return kuraRequestPayload;
        } catch (Exception e) {
            throw new InvalidPayloadException(e, kapuaPayload);
        }
    }

    @Override
    public Class<CommandRequestMessage> getClassFrom() {
        return CommandRequestMessage.class;
    }

    @Override
    public Class<KuraRequestMessage> getClassTo() {
        return KuraRequestMessage.class;
    }

}
