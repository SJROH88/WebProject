package org.gnp.intedoc.commons.validators;

import org.gnp.intedoc.commons.BadRequestException;

public interface RequiredValidator {
    default void requriedCheck(String str, String message) {
        if (str == null || str.isBlank()) {
            throw new BadRequestException(message);
        }
    }

    default void nullCheck(Object obj, String message) {
        if (obj == null) {
            throw new BadRequestException(message);
        }
    }
}