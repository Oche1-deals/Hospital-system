package com.oche1.hospital_management_system.service;

import com.oche1.hospital_management_system.dto.PrescriptionDTO;
import com.oche1.hospital_management_system.model.Doctor;
import com.oche1.hospital_management_system.model.Patient;
import com.oche1.hospital_management_system.model.Prescription;
import com.oche1.hospital_management_system.repository.DoctorRepository;
import com.oche1.hospital_management_system.repository.PatientRepository;
import com.oche1.hospital_management_system.repository.PrescriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrescriptionService {
    @Autowired
    private PrescriptionRepository prescriptionRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private PatientRepository patientRepository;
    // Create a new prescription
    public Prescription createPrescription(PrescriptionDTO prescriptionDTO) {
        Doctor doctor = doctorRepository.findById(prescriptionDTO.getDoctorId())
                .orElseThrow(() -> new RuntimeException("Doctor not found with id: " + prescriptionDTO.getDoctorId()));

        Patient patient = patientRepository.findById(prescriptionDTO.getPatientId())
                .orElseThrow(() -> new RuntimeException("Patient not found with id: " + prescriptionDTO.getPatientId()));

        Prescription prescription = new Prescription();
        prescription.setDoctor(doctor);
        prescription.setPatient(patient);
        prescription.setMedicationText(prescriptionDTO.getMedicationText());
        prescription.setDosage(prescriptionDTO.getDosage());
        prescription.setStatus(prescriptionDTO.getStatus());
        prescription.setIssuedDate(prescriptionDTO.getIssuedDate());
        prescription.setValidUntil(prescriptionDTO.getValidUntil());

        return prescriptionRepository.save(prescription);
    }
    // Get all prescriptions
    public List<Prescription> getAllPrescriptions() {
        return prescriptionRepository.findAll();
    }

    // Get a prescription by ID
    public Prescription getPrescriptionById(Long id) {
        return prescriptionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Prescription not found with id: " + id));
    }
    // Update a prescription
    public Prescription updatePrescription(Long id, PrescriptionDTO prescriptionDTO) {
        Prescription existingPrescription = getPrescriptionById(id);

        Doctor doctor = doctorRepository.findById(prescriptionDTO.getDoctorId())
                .orElseThrow(() -> new RuntimeException("Doctor not found with id: " + prescriptionDTO.getDoctorId()));

        Patient patient = patientRepository.findById(prescriptionDTO.getPatientId())
                .orElseThrow(() -> new RuntimeException("Patient not found with id: " + prescriptionDTO.getPatientId()));

        existingPrescription.setDoctor(doctor);
        existingPrescription.setPatient(patient);
        existingPrescription.setMedicationText(prescriptionDTO.getMedicationText());
        existingPrescription.setDosage(prescriptionDTO.getDosage());
        existingPrescription.setStatus(prescriptionDTO.getStatus());
        existingPrescription.setIssuedDate(prescriptionDTO.getIssuedDate());
        existingPrescription.setValidUntil(prescriptionDTO.getValidUntil());
        return prescriptionRepository.save(existingPrescription);
    }
    // Delete a prescription
    public void deletePrescription(Long id) {
        prescriptionRepository.deleteById(id);
    }
}
