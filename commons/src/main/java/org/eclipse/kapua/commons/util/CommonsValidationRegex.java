/*******************************************************************************
 * Copyright (c) 2018, 2022 Eurotech and/or its affiliates and others
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
package org.eclipse.kapua.commons.util;

import java.util.regex.Pattern;

public enum CommonsValidationRegex implements ValidationRegex {

    /**
     * Alphanumeric chars and dash. Min 3 chars.
     * <p>
     * ^[a-zA-Z0-9\-]{3,}$
     *
     * @since 1.0.0
     */
    SIMPLE_NAME_REGEXP("^[a-zA-Z0-9\\-]{3,}$"),

    /**
     * Alphanumeric chars, underscore and dash. Min 3 chars.
     * <p>
     * ^[a-zA-Z0-9\_\-]{3,}$
     * @since 1.0.0
     */
    NAME_REGEXP("^[a-zA-Z0-9\\_\\-]{3,}$"),

    /**
     * Alphanumeric chars, whitespace, underscore and dash. Min 3 chars.
     * <p>
     * ^[a-zA-Z0-9\ \_\-]{3,}$
     *
     * @deprecated Since 2.1.0. Please make use of {@link #EXTENDED_NAME_REGEXP}
     */
    @Deprecated
    NAME_SPACE_REGEXP("^[a-zA-Z0-9\\ \\_\\-\\.]{3,}$"),

    /**
     * Alphanumeric chars, whitespace, underscore, dash and column. Min 3 chars.
     * <p>
     * ^[a-zA-Z0-9\ \_\-\:]{3,}$
     *
     * @deprecated Since 2.1.0. Please make use of {@link #EXTENDED_NAME_REGEXP}
     * @since 2.0.0
     */
    @Deprecated
    NAME_SPACE_COLON_REGEXP("^[a-zA-Z0-9\\ \\_\\-\\:]{3,}$"),

    /**
     * Alphanumeric chars, whitespace, underscore, dash, dot and column. Min 3 chars.
     * <p>
     * ^[a-zA-Z0-9\ \_\-\.\:]{3,}$
     * @since 2.1.0
     */
    EXTENDED_NAME_REGEXP("^[a-zA-Z0-9\\ \\_\\-\\.\\:]{3,}$"),

    /**
     * ^.*(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&amp;+=!\~\|]).*$
     */
    PASSWORD_REGEXP("^.*(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!\\\"\\#$%&'()*+,\\-./:;<=>?@\\[\\]\\\\^_`{|}~]).*$"),

    /**
     * ^(\w+)([-+.][\w]+)*@(\w[-\w]*\.){1,5}([A-Za-z]){2,63}$
     */
    EMAIL_REGEXP("^(\\w+)([-+.][\\w]+)*@(\\w[-\\w]*\\.){1,5}([A-Za-z]){2,63}$"),

    /**
     * (^(http://)|(https://)|())([01]?\d\d?|2[0-4]\d|25[0-5])\.([01]?\d\d?|2[0-4]\d|25[0-5])\.([01]?\d\d?|2[0-4]\d|25[0-5])\.([01]?\d\d?|2[0-4]\d|25[0-5])($)
     */
    IP_ADDRESS_REGEXP("(^(http://)|(https://)|())([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])($)"),

    /**
     * The standard (IEEE 802) format for printing MAC-48 addresses in human-friendly
     * <p>
     * ^([0-9A-F]{2}[:-]){5}([0-9A-F]{2})$
     */
    MAC_ADDRESS_REGEXP("^([0-9A-F]{2}[:-]){5}([0-9A-F]{2})$"),

    /**
     * (^(http://)|(https://))(((127\\.0\\.0\\.1))|
     * ((10\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])))|
     * ((172\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])))|
     * ((192\\.168\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])))$)
     */
    LOCAL_IP_ADDRESS_REGEXP("(^(http://)|(https://))(((127\\.0\\.0\\.1))|"
            + "((10\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])))|"
            + "((172\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])))|"
            + "((192\\.168\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])))$)"),

    /**
     * ^[a-zA-Z][a-zA-Z0-9\-\.\+]{0,}$
     */
    URI_SCHEME("^[a-zA-Z][a-zA-Z0-9\\-\\.\\+]{0,}$"),

    /**
     * ^((?![0-9\.]+$)(([a-zA-Z0-9]|[a-zA-Z0-9][a-zA-Z0-9\-]*[a-zA-Z0-9])\.)*([A-Za-z0-9]|[A-Za-z0-9][A-Za-z0-9\-]*[A-Za-z0-9])|(([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])\.){3}([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5]))$
     */
    URI_DNS("^((?![0-9\\.]+$)(([a-zA-Z0-9]|[a-zA-Z0-9][a-zA-Z0-9\\-]*[a-zA-Z0-9])\\.)*([A-Za-z0-9]|[A-Za-z0-9][A-Za-z0-9\\-]*[A-Za-z0-9])|(([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])\\.){3}([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5]))$");

    private Pattern pattern;

    CommonsValidationRegex(String regex) {
        this.pattern = Pattern.compile(regex);
    }

    @Override
    public Pattern getPattern() {
        return pattern;
    }
}
