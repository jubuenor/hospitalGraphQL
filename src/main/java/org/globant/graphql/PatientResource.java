package org.globant.graphql;

import java.util.List;

import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Mutation;
import org.eclipse.microprofile.graphql.Query;
import org.globant.domain.entities.MedicalRecord;
import org.globant.domain.entities.Patient;
import org.globant.services.PatientServices;
import org.globant.utils.RegexUtils;

import io.vertx.core.cli.annotations.Description;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;

/**
 * PatientResource
 */
@GraphQLApi
public class PatientResource {

    @Inject
    PatientServices patientServices;

    @Query
    @Description("Get all patients")
    public List<Patient> getAllPatients() {
        return patientServices.getAllPatients();
    }

    @Query
    @Description("Get patient by document")
    public Patient getPatientByDocument(@Valid @Pattern(regexp = RegexUtils.DOCUMENT_REGEX) String document) {
        return patientServices.getPatientByDocument(document);
    }

    @Mutation
    @Description("Create a new patient")
    public Patient createPatient(Patient patient) {
        return patientServices.createPatient(patient);
    }

    @Mutation
    @Description("Update a patient by document")
    public void updatePatient(@Valid @Pattern(regexp = RegexUtils.DOCUMENT_REGEX) String document, Patient patient) {
        patientServices.updatePatient(patient);
    }

    @Mutation
    @Description("Delete a patient by document")
    public void deletePatient(@Valid @Pattern(regexp = RegexUtils.DOCUMENT_REGEX) String document) {
        patientServices.deletePatient(document);
    }

    @Query
    @Description("Patient exists by document")
    public boolean patientExists(@Valid @Pattern(regexp = RegexUtils.DOCUMENT_REGEX) String document) {
        return patientServices.patientExistsByDocument(document);
    }

    @Mutation
    @Description("Add a medical record to a patient")
    public void addMedicalRecord(@Valid @Pattern(regexp = RegexUtils.DOCUMENT_REGEX) String document,
            MedicalRecord medicalRecord) {
        patientServices.addMedicalRecord(document, medicalRecord);
    }

}
