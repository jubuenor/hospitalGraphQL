package org.globant.domain.entities;

import java.time.LocalDateTime;

import lombok.Data;

/**
 * MedicalHistoryItem
 */
@Data
public class MedicalRecord {
    private String information;

    private LocalDateTime date;
}
