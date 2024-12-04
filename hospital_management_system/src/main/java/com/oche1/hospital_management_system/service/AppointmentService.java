package com.oche1.hospital_management_system.service;

import com.oche1.hospital_management_system.dto.AppointmentDTO;
import com.oche1.hospital_management_system.model.Appointment;
import com.oche1.hospital_management_system.model.Doctor;
import com.oche1.hospital_management_system.model.Patient;
import com.oche1.hospital_management_system.repository.AppointmentRepository;
import com.oche1.hospital_management_system.repository.DoctorRepository;
import com.oche1.hospital_management_system.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {
    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private DoctorRepository doctorRepository;
    // Create a new appointment
    public Appointment createAppointment(AppointmentDTO appointmentDTO) {
        Patient patient = patientRepository.findById(appointmentDTO.getPatientId())
                .orElseThrow(() -> new RuntimeException("Patient not found with id: " + appointmentDTO.getPatientId()));

        Doctor doctor = doctorRepository.findById(appointmentDTO.getDoctorId())
                .orElseThrow(() -> new RuntimeException("Doctor not found with id: " + appointmentDTO.getDoctorId()));

        Appointment appointment = new Appointment();
        appointment.setPatient(patient);
        appointment.setDoctor(doctor);
        appointment.setDate(appointmentDTO.getDate());
        appointment.setTime(appointmentDTO.getTime());
        appointment.setReason(appointmentDTO.getReason());
        appointment.setStatus(appointmentDTO.getStatus());

        return appointmentRepository.save(appointment);
    }
    // Get all appointments
    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    // Get appointment by ID
    public Appointment getAppointmentById(Long id) {
        return appointmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Appointment not found with id: " + id));
    }
    // Update an appointment
    public Appointment updateAppointment(Long id, AppointmentDTO appointmentDTO) {
        Appointment existingAppointment = getAppointmentById(id);

        Patient patient = patientRepository.findById(appointmentDTO.getPatientId())
                .orElseThrow(() -> new RuntimeException("Patient not found with id: " + appointmentDTO.getPatientId()));

        Doctor doctor = doctorRepository.findById(appointmentDTO.getDoctorId())
                .orElseThrow(() -> new RuntimeException("Doctor not found with id: " + appointmentDTO.getDoctorId()));

        existingAppointment.setPatient(patient);
        existingAppointment.setDoctor(doctor);
        existingAppointment.setDate(appointmentDTO.getDate());
        existingAppointment.setTime(appointmentDTO.getTime());
        existingAppointment.setReason(appointmentDTO.getReason());
        existingAppointment.setStatus(appointmentDTO.getStatus());

        return appointmentRepository.save(existingAppointment);
    }
    // Delete an appointment
    public void deleteAppointment(Long id) {
        appointmentRepository.deleteById(id);
    }
}
