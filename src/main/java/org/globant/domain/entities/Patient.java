package org.globant.domain.entities;

import java.time.LocalDateTime;
import java.util.List;

import org.bson.types.ObjectId;
import org.globant.utils.RegexUtils;

import io.quarkus.mongodb.panache.common.MongoEntity;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * Patient
 */

@Data
@MongoEntity(collection = "patients")
public class Patient {

    private ObjectId id;

    @Pattern(regexp = RegexUtils.DOCUMENT_REGEX, message = "Document must be a number with 8 to 10 digits")
    @NotNull(message = "Document is required")
    private String document;

    @NotNull(message = "DocumentType is required")
    private DocumentType documentType;

    @NotNull(message = "First Name is required")
    @Size(min = 3, max = 50, message = "First Name must be between 3 and 50characters")
    private String first_name;

    @NotNull(message = "Last Name is required")
    @Size(min = 3, max = 50, message = "Last Name must be between 3 and 50characters")
    private String last_name;

    private ContactInformation contact_info;

    private List<MedicalRecord> medical_history;

    private LocalDateTime created_at;

    private LocalDateTime updated_at;
}

// @MongoEntity(collection = "patients")
// public record Patient(
// ObjectId id,
// @Pattern(regexp = RegexUtils.DOCUMENT_REGEX, message = "Document must be a
// number with 8 to 10 digits") @NotNull(message = "Document is required")
// String document,
// @NotNull(message = "DocumentType is required") DocumentType documentType,
// @NotNull(message = "First Name is required") @Size(min = 3, max = 50, message
// = "First Name must be between 3 and 50 characters") String first_name,
// @NotNull(message = "Last Name is required") @Size(min = 3, max = 50, message
// = "Last Name must be between 3 and 50 characters") String last_name,
// ContactInformation contact_info,
// List<MedicalRecord> medical_history,
// LocalDateTime created_at,
// LocalDateTime updated_at) {
//
// Patient() {
// this(null, null, null, null, null, null, null, LocalDateTime.now(),
// LocalDateTime.now());
// }
// }
