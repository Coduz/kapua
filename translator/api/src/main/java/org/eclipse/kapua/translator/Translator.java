/*******************************************************************************
 * Copyright (c) 2016, 2020 Eurotech and/or its affiliates and others
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Eurotech - initial API and implementation
 *     Red Hat Inc
 *******************************************************************************/
package org.eclipse.kapua.translator;

import org.eclipse.kapua.message.Message;
import org.eclipse.kapua.translator.cache.TranslatorCache;
import org.eclipse.kapua.translator.exception.TranslateException;
import org.eclipse.kapua.translator.exception.TranslatorNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.constraints.NotNull;
import java.util.ServiceLoader;

/**
 * {@link javassist.Translator} defintions.
 * <p>
 * Translators are used to allow heterogeneous systems to exchange messages through layered messages domain.
 * Kapua  has 3 different layer:
 *
 * <ul>
 * <li>Kapua layeer</li>
 * <li>Application layer (i.e. Kura)</li>
 * <li>Transport layer (ie jms, mqtt, ...)</li>
 * </ul>
 *
 * @param <FROM_M> {@link Message} type from which {@link #translate(Message)}.
 * @param <TO_M>   {@link Message} type to which {@link #translate(Message)}.
 * @since 1.0.0
 */
public abstract class Translator<FROM_M extends Message, TO_M extends Message> {

    private static final Logger LOG = LoggerFactory.getLogger(Translator.class);

    private static final ServiceLoader<Translator> AVAILABLE_TRANSLATORS = ServiceLoader.load(Translator.class);

    /**
     * Return a {@link Translator} for the given {@link Message}s types.
     * <br>
     * This method will lookup instances of {@link Translator} through {@link java.util.ServiceLoader}
     *
     * @param fromMessageClass {@link Message} type from which {@link #translate(Message)}.
     * @param toMessageClass   {@link Message} type to which {@link #translate(Message)}.
     * @return The matching {@link Translator} for the given {@link Message}s types.
     * @throws TranslatorNotFoundException if no {@link Translator} if found for the given {@link Message} types.
     * @since 1.0.0
     */
    public static <FROM_M extends Message, TO_M extends Message, T extends Translator<FROM_M, TO_M>> T getTranslatorFor(@NotNull Class<? extends FROM_M> fromMessageClass, @NotNull Class<? extends TO_M> toMessageClass) {

        T cachedTranslator = TranslatorCache.getCachedTranslator(fromMessageClass, toMessageClass);

        if (cachedTranslator != null) {
            return cachedTranslator;
        }

        synchronized (AVAILABLE_TRANSLATORS) {
            for (Translator<FROM_M, TO_M> translator : AVAILABLE_TRANSLATORS) {
                if ((fromMessageClass.isAssignableFrom(translator.getClassFrom())) &&
                        toMessageClass.isAssignableFrom(translator.getClassTo())) {
                    TranslatorCache.cacheTranslator(fromMessageClass, toMessageClass, translator);

                    return (T) translator;
                }
            }
        }

        throw new TranslatorNotFoundException(fromMessageClass, toMessageClass);
    }

    /**
     * Translates {@link Message} from the domain FROM_M to the domain TO_M
     *
     * @param message The {@link Message} to translate.
     * @return the translated {@link Message}.
     * @throws TranslateException When translating a {@link Message} cannot be performed properly, perhaps due to a processing error.
     * @since 1.0.0
     */
    public abstract TO_M translate(FROM_M message) throws TranslateException;

    /**
     * Returns the FROM_M {@link Message} type.
     *
     * @return The FROM_M {@link Message} type.
     * @since 1.0.0
     */
    public abstract Class<FROM_M> getClassFrom();

    /**
     * Returns the TO_M {@link Message} type.
     *
     * @return The TO_M {@link Message} type.
     * @since 1.0.0
     */
    public abstract Class<TO_M> getClassTo();
}
