package com.astrotalk.hospitalManagement.controller;

import com.astrotalk.hospitalManagement.model.requestDTO.RegisterEmployeeRequest;
import com.astrotalk.hospitalManagement.model.requestDTO.UserLoginRequest;
import com.astrotalk.hospitalManagement.model.responseDTO.ResponseModel;
import com.astrotalk.hospitalManagement.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.astrotalk.hospitalManagement.constants.EndpointConstants.*;

/**
 * The type Employee controller.
 */
@RestController
@RequestMapping(AUTH)
public class EmployeeController {

    /**
     * The Employee service.
     */
    @Autowired
    EmployeeService employeeService;

    /**
     * Register user response model.
     *
     * @param employeeDetails the employee details
     * @return the response model
     */
    @PostMapping(REGISTER)
    ResponseModel registerUser(@Valid @RequestBody RegisterEmployeeRequest employeeDetails) {
        return employeeService.registerEmployee(employeeDetails);
    }

    /**
     * User login response model.
     *
     * @param userLoginRequest the user login request
     * @return the response model
     */
    @PostMapping(LOGIN)
    ResponseModel userLogin(@Valid @RequestBody UserLoginRequest userLoginRequest) {
        return employeeService.userLogin(userLoginRequest);
    }

}
