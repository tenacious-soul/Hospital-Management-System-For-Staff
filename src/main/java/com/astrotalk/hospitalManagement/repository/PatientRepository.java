package com.astrotalk.hospitalManagement.repository;

import com.astrotalk.hospitalManagement.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    @Query(value = "SELECT * FROM Patient p where (:patientId IS NULL OR p.patient_id=:patientId) AND (:patientName IS NULL OR p.patient_name LIKE %:patientName%) " +
            "AND p.patient_status = :patientStatus AND (:mobileNumber IS NULL OR p.mobile_number=:mobileNumber) AND (:roomNumber IS NULL OR p.room_number=:roomNumber) " +
            "AND (:date IS NULL OR p.admission_date>=:date)", nativeQuery = true)
    List<Patient> getAllPatients(Long patientId, String patientName, Integer patientStatus, Long mobileNumber, Integer roomNumber, LocalDate date);

    @Modifying
    @Query(value = "UPDATE Patient SET patientStatus=:patientStatus WHERE patientId = :patientId")
    Integer dischargePatient(Long patientId, Integer patientStatus);
}
