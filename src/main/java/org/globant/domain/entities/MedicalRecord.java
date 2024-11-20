package org.globant.domain.entities;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * MedicalHistoryItem
 */
// @Data
// public class MedicalRecord {
//
// @NotNull(message = "Information is required")
// @Size(min = 3, max = 512, message = "Information must be between 3 and 255
// characters")
// private String information;
//
// @NotNull(message = "Date is required")
// private LocalDateTime date;
// }

public record MedicalRecord(
        @NotNull(message = "Information is required") @Size(min = 3, max = 512, message = "Information must be between 3 and 255 characters") String information,
        @NotNull(message = "Date is required") LocalDateTime date) {
}
