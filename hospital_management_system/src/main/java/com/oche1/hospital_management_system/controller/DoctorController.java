package com.oche1.hospital_management_system.controller;

import com.oche1.hospital_management_system.dto.DoctorDTO;
import com.oche1.hospital_management_system.model.Doctor;
import com.oche1.hospital_management_system.service.DoctorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    // Create a new doctor
    @PostMapping("/doctor")
    public ResponseEntity<Doctor> createDoctor(@Valid @RequestBody DoctorDTO doctorDTO) {
        Doctor newDoctor = doctorService.createDoctor(doctorDTO);
        return ResponseEntity.ok(newDoctor);
    }

    // Get all doctors
    @GetMapping("/doctors")
    public ResponseEntity<List<Doctor>> getAllDoctors() {
        List<Doctor> doctors = doctorService.getAllDoctors();
        return ResponseEntity.ok(doctors);
    }

    // Get doctor by ID
    @GetMapping("doctor/{id}")
    public ResponseEntity<Doctor> getDoctorById(@PathVariable Long id) {
        Doctor doctor = doctorService.getDoctorById(id);
        return ResponseEntity.ok(doctor);
    }
    // Update doctor details
    @PutMapping("doctor-put/{id}")
    public ResponseEntity<Doctor> updateDoctor(
            @PathVariable Long id,
            @Valid @RequestBody DoctorDTO doctorDTO) {
        Doctor updatedDoctor = doctorService.updateDoctor(id, doctorDTO);
        return ResponseEntity.ok(updatedDoctor);
    }

    // Delete doctor by ID
    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteDoctor(@PathVariable Long id) {
        doctorService.deleteDoctor(id);
        return ResponseEntity.noContent().build();
    }
}
