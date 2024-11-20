package org.globant.services.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.globant.domain.entities.MedicalRecord;
import org.globant.domain.entities.Patient;
import org.globant.errors.DocumentAlreadyExistsException;
import org.globant.errors.NotFoundException;
import org.globant.repositories.PatientRepository;
import org.globant.services.PatientServices;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
//import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

/**
 * PatientServicesImpl
 */

@Slf4j
@ApplicationScoped
public class PatientServicesImpl implements PatientServices {

    PatientRepository patientRepository;

    @Inject
    public PatientServicesImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public List<Patient> getAllPatients() {
        log.info("Fetching all patients");
        return patientRepository.listAll();
    }

    @Override
    public Patient getPatientByDocument(String document) {
        Optional<Patient> patientOptional = patientRepository.getPatientByDocument(document);
        if (patientOptional.isEmpty()) {
            throw new NotFoundException(document);
        }
        log.info("Fetching patient with document: %s", document);
        return patientOptional.get();
    }

    @Override
    // @Transactional
    public Patient createPatient(Patient patient) {
        if (patientExistsByDocument(patient.getDocument())) {
            throw new DocumentAlreadyExistsException(patient.getDocument());
        }
        patient.setCreated_at(LocalDateTime.now());
        patient.setUpdated_at(LocalDateTime.now());
        patientRepository.persist(patient);
        log.info("Patient created with document: %s", patient.getDocument());
        return patient;
    }

    @Override
    // @Transactional
    public void updatePatient(Patient patient) {
        String document = patient.getDocument();
        if (!patientExistsByDocument(document)) {
            throw new NotFoundException(document);
        }
        patientRepository.update(patient);
        log.info("Patient updated with document: %s", document);
    }

    @Override
    // @Transactional
    public void deletePatient(String document) {
        if (!patientExistsByDocument(document)) {
            throw new NotFoundException(document);
        }
        patientRepository.deletePatientByDocument(document);
        log.info("Patient deleted with document: %s", document);
    }

    @Override
    public boolean patientExistsByDocument(String document) {
        return patientRepository.existsPatientByDocument(document);
    }

    @Override
    // @Transactional
    public void addMedicalRecord(String document, MedicalRecord medicalRecord) {
        Patient patient = getPatientByDocument(document);
        // medicalRecord.setDate(LocalDateTime.now());
        List<MedicalRecord> medicalRecords = patient.getMedical_history();
        medicalRecords.add(medicalRecord);
        patient.setMedical_history(medicalRecords);
        patient.setUpdated_at(LocalDateTime.now());
        patientRepository.update(patient);
        log.info("Medical record added to patient with document: %s", document);
    }
}
