package org.globant.domain.entities;


import java.time.LocalDateTime;
import java.util.List;

import org.bson.types.ObjectId;

import io.quarkus.mongodb.panache.common.MongoEntity;
import lombok.Data;

/**
 * Patient
 */

@Data
@MongoEntity(collection = "patients")
public class Patient {
    private ObjectId id; 

    private String document;
    
    private String document_type;

    private String first_name;

    private String last_name;

    private ContactInformation contact_info;

    private List<MedicalRecord> medical_history;

    private LocalDateTime created_at;

    private LocalDateTime updated_at;
}
