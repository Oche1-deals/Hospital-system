package com.oche1.hospital_management_system.controller;

import com.oche1.hospital_management_system.dto.PrescriptionDTO;
import com.oche1.hospital_management_system.model.Prescription;
import com.oche1.hospital_management_system.service.PrescriptionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PrescriptionController {
    @Autowired
    private PrescriptionService prescriptionService;

    // Create a new prescription
    @PostMapping("/prescription")
    public ResponseEntity<Prescription> createPrescription(@Valid @RequestBody PrescriptionDTO prescriptionDTO) {
        Prescription newPrescription = prescriptionService.createPrescription(prescriptionDTO);
        return ResponseEntity.ok(newPrescription);
    }
    // Get all prescriptions
    @GetMapping("/prescriptions")
    public ResponseEntity<List<Prescription>> getAllPrescriptions() {
        List<Prescription> prescriptions = prescriptionService.getAllPrescriptions();
        return ResponseEntity.ok(prescriptions);
    }

    // Get a prescription by ID
    @GetMapping("prescription/{id}")
    public ResponseEntity<Prescription> getPrescriptionById(@PathVariable Long id) {
        Prescription prescription = prescriptionService.getPrescriptionById(id);
        return ResponseEntity.ok(prescription);
    }
    // Update a prescription
    @PutMapping("prescription/{id}")
    public ResponseEntity<Prescription> updatePrescription(
            @PathVariable Long id,
            @Valid @RequestBody PrescriptionDTO prescriptionDTO) {
        Prescription updatedPrescription = prescriptionService.updatePrescription(id, prescriptionDTO);
        return ResponseEntity.ok(updatedPrescription);
    }

    // Delete a prescription
    @DeleteMapping("prescription/{id}")
    public ResponseEntity<Void> deletePrescription(@PathVariable Long id) {
        prescriptionService.deletePrescription(id);
        return ResponseEntity.noContent().build();
    }
}
