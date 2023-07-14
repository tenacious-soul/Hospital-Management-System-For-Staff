package com.astrotalk.hospitalManagement.repository;

import com.astrotalk.hospitalManagement.entity.Expenses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * The interface Expense repository.
 */
@Repository
public interface ExpenseRepository extends JpaRepository<Expenses, Long> {

    /**
     * Clear expenses integer.
     *
     * @param patientId the patient id
     * @return the integer
     */
    @Modifying
    @Query(value = "Update Expenses e SET e.recordStatus = 5 WHERE e.patient.patientId=:patientId")
    Integer clearExpenses(Long patientId);
}
