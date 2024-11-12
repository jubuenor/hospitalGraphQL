package org.globant.errors;

import io.smallrye.graphql.api.ErrorCode;

/**
 * DocumentAlreadyUsed
 */
@ErrorCode("DOCUMENT_ALREADY_EXUSTS")
public class DocumentAlreadyExistsException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public DocumentAlreadyExistsException(String document) {
        super("Document " + document + " already used");
    }

    public DocumentAlreadyExistsException(String document, Throwable cause) {
        super(document, cause);
    }

}
