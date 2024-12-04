package com.oche1.hospital_management_system.controller;

import com.oche1.hospital_management_system.dto.AppointmentDTO;
import com.oche1.hospital_management_system.model.Appointment;
import com.oche1.hospital_management_system.service.AppointmentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AppointmentController {
    @Autowired
    private AppointmentService appointmentService;

    // Create a new appointment
    @PostMapping("/appointment")
    public ResponseEntity<Appointment> createAppointment(@Valid @RequestBody AppointmentDTO appointmentDTO) {
        Appointment newAppointment = appointmentService.createAppointment(appointmentDTO);
        return ResponseEntity.ok(newAppointment);
    }

    // Get all appointments
    @GetMapping("/appointments")
    public ResponseEntity<List<Appointment>> getAllAppointments() {
        List<Appointment> appointments = appointmentService.getAllAppointments();
        return ResponseEntity.ok(appointments);
    }
    // Get appointment by ID
    @GetMapping("appointment/{id}")
    public ResponseEntity<Appointment> getAppointmentById(@PathVariable Long id) {
        Appointment appointment = appointmentService.getAppointmentById(id);
        return ResponseEntity.ok(appointment);
    }

    // Update an appointment
    @PutMapping("appointment/{id}")
    public ResponseEntity<Appointment> updateAppointment(
            @PathVariable Long id,
            @Valid @RequestBody AppointmentDTO appointmentDTO) {
        Appointment updatedAppointment = appointmentService.updateAppointment(id, appointmentDTO);
        return ResponseEntity.ok(updatedAppointment);
    }
    // Delete an appointment
    @DeleteMapping("appointment/{id}")
    public ResponseEntity<Void> deleteAppointment(@PathVariable Long id) {
        appointmentService.deleteAppointment(id);
        return ResponseEntity.noContent().build();
    }
}
