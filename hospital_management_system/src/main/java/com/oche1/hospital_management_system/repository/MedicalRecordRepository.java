package com.oche1.hospital_management_system.repository;

import com.oche1.hospital_management_system.model.MedicalRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicalRecordRepository extends JpaRepository<MedicalRecord, Long> {
}
