package com.oche1.hospital_management_system.controller;

import com.oche1.hospital_management_system.dto.PatientDTO;
import com.oche1.hospital_management_system.model.Patient;
import com.oche1.hospital_management_system.service.PatientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PatientController {
    @Autowired
    private PatientService patientService;

    // Create a new patient
    @PostMapping("/patient")
    public ResponseEntity<Patient> createPatient(@Valid @RequestBody PatientDTO patientDTO) {
        Patient newPatient = patientService.createPatient(patientDTO);
        return new ResponseEntity<>(newPatient, HttpStatus.CREATED);
    }

    // Get all patients
    @GetMapping("/patients")
    public List<Patient> getAllPatients() {
        return patientService.getAllPatients();
    }
    // Get a specific patient by ID
    @GetMapping("patient/{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable Long id) {
        Patient patient = patientService.getPatientById(id);
        return ResponseEntity.ok(patient);
    }

    // Update a patient by ID
    @PutMapping("patient-put/{id}")
    public ResponseEntity<Patient> updatePatient(@PathVariable Long id, @Valid @RequestBody PatientDTO patientDTO) {
        Patient updatedPatient = patientService.updatePatient(id, patientDTO);
        return ResponseEntity.ok(updatedPatient);
    }
    // Delete a patient by ID
    @DeleteMapping("patient/{id}")
    public ResponseEntity<Void> deletePatient(@PathVariable Long id) {
        patientService.deletePatient(id);
        return ResponseEntity.noContent().build();
    }

}
