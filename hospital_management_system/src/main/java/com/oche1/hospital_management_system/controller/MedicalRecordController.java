package com.oche1.hospital_management_system.controller;

import com.oche1.hospital_management_system.dto.MedicalRecordDTO;
import com.oche1.hospital_management_system.model.MedicalRecord;
import com.oche1.hospital_management_system.service.MedicalRecordService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MedicalRecordController {
    @Autowired
    private MedicalRecordService medicalRecordService;

    // Create a new medical record
    @PostMapping("/medical-record")
    public ResponseEntity<MedicalRecord> createMedicalRecord(@Valid @RequestBody MedicalRecordDTO medicalRecordDTO) {
        MedicalRecord newRecord = medicalRecordService.createMedicalRecord(medicalRecordDTO);
        return ResponseEntity.ok(newRecord);
    }
    // Get all medical records
    @GetMapping("/medical-record")
    public ResponseEntity<List<MedicalRecord>> getAllMedicalRecords() {
        List<MedicalRecord> records = medicalRecordService.getAllMedicalRecords();
        return ResponseEntity.ok(records);
    }

    // Get medical record by ID
    @GetMapping("medical-record/{id}")
    public ResponseEntity<MedicalRecord> getMedicalRecordById(@PathVariable Long id) {
        MedicalRecord record = medicalRecordService.getMedicalRecordById(id);
        return ResponseEntity.ok(record);
    }
    // Update medical record
    @PutMapping("medical-record/{id}")
    public ResponseEntity<MedicalRecord> updateMedicalRecord(
            @PathVariable Long id,
            @Valid @RequestBody MedicalRecordDTO medicalRecordDTO) {
        MedicalRecord updatedRecord = medicalRecordService.updateMedicalRecord(id, medicalRecordDTO);
        return ResponseEntity.ok(updatedRecord);
    }

    // Delete medical record
    @DeleteMapping("medical-record/{id}")
    public ResponseEntity<Void> deleteMedicalRecord(@PathVariable Long id) {
        medicalRecordService.deleteMedicalRecord(id);
        return ResponseEntity.noContent().build();
    }
}
