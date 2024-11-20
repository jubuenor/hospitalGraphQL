package org.globant.utils;

import lombok.experimental.UtilityClass;

/**
 * RegexUtils
 */
@UtilityClass
public class RegexUtils {

    public final String PHONE_REGEX = "\\d{8,10}$";
    public final String DOCUMENT_REGEX = "\\d{8,10}";

}
