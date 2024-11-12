package org.globant.services;

import java.util.List;

import org.globant.domain.entities.MedicalRecord;
import org.globant.domain.entities.Patient;

/**
 * PatientServices
 */
public interface PatientServices {

    public List<Patient> getAllPatients();

    public Patient getPatientByDocument(String document);

    public Patient createPatient(Patient patient);

    public void updatePatient(Patient patient);

    public void deletePatient(String document);

    public boolean patientExistsByDocument(String document);

    public void addMedicalRecord(String document, MedicalRecord medicalRecord);

}
