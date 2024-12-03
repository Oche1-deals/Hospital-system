package com.oche1.hospital_management_system.repository;

import com.oche1.hospital_management_system.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {

}
