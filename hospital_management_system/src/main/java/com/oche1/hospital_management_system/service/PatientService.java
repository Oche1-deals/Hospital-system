package com.oche1.hospital_management_system.service;

import com.oche1.hospital_management_system.dto.PatientDTO;
import com.oche1.hospital_management_system.model.Patient;
import com.oche1.hospital_management_system.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {
    @Autowired
    private PatientRepository patientRepository;

    // Create a new patient
    public Patient createPatient(PatientDTO patientDTO) {
        Patient patient = convertDtoToEntity(patientDTO);
        return patientRepository.save(patient);
    }
    // Get all patients
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    // Get a specific patient by ID
    public Patient getPatientById(Long id) {
        return patientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient not found with id: " + id));
    }
    // Update patient details
    public Patient updatePatient(Long id, PatientDTO patientDTO) {
        Patient existingPatient = getPatientById(id);
        Patient updatedPatient = convertDtoToEntity(patientDTO);
        updatedPatient.setId(id); // Ensure the ID remains the same
        return patientRepository.save(updatedPatient);
    }

    // Delete a patient by ID
    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }
    // Helper method to convert PatientDTO to Patient entity
    private Patient convertDtoToEntity(PatientDTO patientDTO) {
        Patient patient = new Patient();
        patient.setFirstName(patientDTO.getFirstName());
        patient.setLastName(patientDTO.getLastName());
        patient.setDateOfBirth(patientDTO.getDateOfBirth());
        patient.setGender(patientDTO.getGender());
        patient.setEmail(patientDTO.getEmail());
        patient.setPhoneNumber(patientDTO.getPhoneNumber());
        patient.setAddress(patientDTO.getAddress());
        patient.setEmergencyContactName(patientDTO.getEmergencyContactName());
        patient.setEmergencyContactPhone(patientDTO.getEmergencyContactPhone());
        patient.setEmergencyRelation(patientDTO.getEmergencyRelation());
        patient.setBloodGroup(patientDTO.getBloodGroup());
        return patient;
    }
}
