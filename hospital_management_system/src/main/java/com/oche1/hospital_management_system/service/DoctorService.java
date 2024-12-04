package com.oche1.hospital_management_system.service;

import com.oche1.hospital_management_system.dto.DoctorDTO;
import com.oche1.hospital_management_system.model.Doctor;
import com.oche1.hospital_management_system.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {
    @Autowired
    private DoctorRepository doctorRepository;

    // Create a new doctor
    public Doctor createDoctor(DoctorDTO doctorDTO) {
        Doctor doctor = convertDtoToEntity(doctorDTO);
        return doctorRepository.save(doctor);
    }

    // Get all doctors
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    // Get doctor by ID
    public Doctor getDoctorById(Long id) {
        return doctorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Doctor not found with id: " + id));
    }

    // Update doctor details
    public Doctor updateDoctor(Long id, DoctorDTO doctorDTO) {
        Doctor existingDoctor = getDoctorById(id);
        Doctor updatedDoctor = convertDtoToEntity(doctorDTO);
        updatedDoctor.setId(existingDoctor.getId()); // Preserve ID
        return doctorRepository.save(updatedDoctor);
    }
    // Delete doctor by ID
    public void deleteDoctor(Long id) {
        doctorRepository.deleteById(id);
    }
    // Helper method to convert DoctorDTO to Doctor entity
    private Doctor convertDtoToEntity(DoctorDTO doctorDTO) {
        Doctor doctor = new Doctor();
        doctor.setFirstName(doctorDTO.getFirstName());
        doctor.setLastName(doctorDTO.getLastName());
        doctor.setGender(doctorDTO.getGender());
        doctor.setDateOfBirth(doctorDTO.getDateOfBirth());
        doctor.setPhoneNumber(doctorDTO.getPhoneNumber());
        doctor.setEmail(doctorDTO.getEmail());
        doctor.setAddress(doctorDTO.getAddress());
        doctor.setLicenseNumber(doctorDTO.getLicenseNumber());
        doctor.setSpecialization(doctorDTO.getSpecialization());
        doctor.setAvailability(doctorDTO.getAvailability());
        return doctor;
    }
}
