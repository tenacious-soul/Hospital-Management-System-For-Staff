package com.astrotalk.hospitalManagement.repository;

import com.astrotalk.hospitalManagement.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * The interface Employee repository.
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    /**
     * Find by email employee.
     *
     * @param email the email
     * @return the employee
     */
    Employee findByEmail(String email);

    /**
     * Find by email and password optional.
     *
     * @param email    the email
     * @param password the password
     * @return the optional
     */
    Optional<Employee> findByEmailAndPassword(String email, String password);

}
