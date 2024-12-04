package com.oche1.hospital_management_system.repository;

import com.oche1.hospital_management_system.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}
