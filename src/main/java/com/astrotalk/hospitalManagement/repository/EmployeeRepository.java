package com.astrotalk.hospitalManagement.repository;

import com.astrotalk.hospitalManagement.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Employee findByEmail(String email);

    Optional<Employee> findByEmailAndPassword(String email, String password);

}
