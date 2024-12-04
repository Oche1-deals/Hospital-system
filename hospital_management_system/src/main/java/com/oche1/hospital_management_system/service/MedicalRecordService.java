package com.oche1.hospital_management_system.service;

import com.oche1.hospital_management_system.dto.MedicalRecordDTO;
import com.oche1.hospital_management_system.model.Doctor;
import com.oche1.hospital_management_system.model.MedicalRecord;
import com.oche1.hospital_management_system.model.Patient;
import com.oche1.hospital_management_system.repository.DoctorRepository;
import com.oche1.hospital_management_system.repository.MedicalRecordRepository;
import com.oche1.hospital_management_system.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicalRecordService {
    @Autowired
    private MedicalRecordRepository medicalRecordRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    // Create a new medical record
    public MedicalRecord createMedicalRecord(MedicalRecordDTO medicalRecordDTO) {
        Patient patient = patientRepository.findById(medicalRecordDTO.getPatientId())
                .orElseThrow(() -> new RuntimeException("Patient not found with id: " + medicalRecordDTO.getPatientId()));

        Doctor doctor = doctorRepository.findById(medicalRecordDTO.getDoctorId())
                .orElseThrow(() -> new RuntimeException("Doctor not found with id: " + medicalRecordDTO.getDoctorId()));

        MedicalRecord medicalRecord = new MedicalRecord();
        medicalRecord.setPatient(patient);
        medicalRecord.setDoctor(doctor);
        medicalRecord.setDiagnosis(medicalRecordDTO.getDiagnosis());
        medicalRecord.setTreatment(medicalRecordDTO.getTreatment());
        medicalRecord.setNotes(medicalRecordDTO.getNotes());

        return medicalRecordRepository.save(medicalRecord);
    }
    // Get all medical records
    public List<MedicalRecord> getAllMedicalRecords() {
        return medicalRecordRepository.findAll();
    }
    // Get medical record by ID
    public MedicalRecord getMedicalRecordById(Long id) {
        return medicalRecordRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Medical Record not found with id: " + id));
    }
    // Update medical record
    public MedicalRecord updateMedicalRecord(Long id, MedicalRecordDTO medicalRecordDTO) {
        MedicalRecord existingRecord = getMedicalRecordById(id);

        Patient patient = patientRepository.findById(medicalRecordDTO.getPatientId())
                .orElseThrow(() -> new RuntimeException("Patient not found with id: " + medicalRecordDTO.getPatientId()));

        Doctor doctor = doctorRepository.findById(medicalRecordDTO.getDoctorId())
                .orElseThrow(() -> new RuntimeException("Doctor not found with id: " + medicalRecordDTO.getDoctorId()));

        existingRecord.setPatient(patient);
        existingRecord.setDoctor(doctor);
        existingRecord.setDiagnosis(medicalRecordDTO.getDiagnosis());
        existingRecord.setTreatment(medicalRecordDTO.getTreatment());
        existingRecord.setNotes(medicalRecordDTO.getNotes());

        return medicalRecordRepository.save(existingRecord);
    }
    // Delete medical record
    public void deleteMedicalRecord(Long id) {
        medicalRecordRepository.deleteById(id);
    }
}
