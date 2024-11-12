package org.globant.errors;

import io.smallrye.graphql.api.ErrorCode;

/**
 * NotFoundException
 */
@ErrorCode("NOT_FOUND")
public class NotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public NotFoundException(String message) {
        super(message + " already exists");
    }

    public NotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

}
