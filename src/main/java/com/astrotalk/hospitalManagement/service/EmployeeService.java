package com.astrotalk.hospitalManagement.service;

import com.astrotalk.hospitalManagement.model.requestDTO.RegisterEmployeeRequest;
import com.astrotalk.hospitalManagement.model.requestDTO.UserLoginRequest;
import com.astrotalk.hospitalManagement.model.responseDTO.ResponseModel;

/**
 * The interface Employee service.
 */
public interface EmployeeService {

    /**
     * Register employee response model.
     *
     * @param employeeRequest the employee request
     * @return the response model
     */
    ResponseModel registerEmployee(RegisterEmployeeRequest employeeRequest);

    /**
     * User login response model.
     *
     * @param userLoginRequest the user login request
     * @return the response model
     */
    ResponseModel userLogin(UserLoginRequest userLoginRequest);

}
