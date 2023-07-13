package com.astrotalk.hospitalManagement.service;

import com.astrotalk.hospitalManagement.entity.Employee;
import com.astrotalk.hospitalManagement.model.requestDTO.RegisterEmployeeRequest;
import com.astrotalk.hospitalManagement.model.requestDTO.UserLoginRequest;
import com.astrotalk.hospitalManagement.model.responseDTO.ResponseModel;
import com.astrotalk.hospitalManagement.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public ResponseModel registerEmployee(RegisterEmployeeRequest employeeRequest) {
        if (employeeRepository.findByEmail(employeeRequest.getEmail()) != null) {
            return ResponseModel.builder().message("Account already registered").build();
        }

        Employee emp = Employee.builder().employeeName(employeeRequest.getEmployeeName())
                .email(employeeRequest.getEmail()).password(passwordEncoder.encode(employeeRequest.getPassword())).build();
        employeeRepository.save(emp);
        return ResponseModel.builder().message("Account registered successfully").build();
    }

    @Override
    public ResponseModel userLogin(UserLoginRequest userLoginRequest) {
        Employee employee = employeeRepository.findByEmail(userLoginRequest.getEmail());
        String responseMessage = "";
        if (employee == null) {
            responseMessage = "Email does not exists. SignUp First!";
        } else {
            String encodedPassword = employee.getPassword();
            String password = userLoginRequest.getPassword();
            if (passwordEncoder.matches(password, encodedPassword)) {
                Optional<Employee> emp = employeeRepository.findByEmailAndPassword(userLoginRequest.getEmail(), encodedPassword);
                if (emp.isPresent()) {
                    responseMessage = "Logged In successfully!";
                } else {
                    responseMessage = "LogIn failed, please try again later!";
                }
            } else {
                responseMessage = "Password does not match. Please enter correct password!";
            }
        }
        return ResponseModel.builder().message(responseMessage).build();
    }
}
