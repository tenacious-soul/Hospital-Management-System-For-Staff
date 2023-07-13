package com.astrotalk.hospitalManagement.service;

import com.astrotalk.hospitalManagement.model.requestDTO.RegisterEmployeeRequest;
import com.astrotalk.hospitalManagement.model.requestDTO.UserLoginRequest;
import com.astrotalk.hospitalManagement.model.responseDTO.ResponseModel;

public interface EmployeeService {

    ResponseModel registerEmployee(RegisterEmployeeRequest employeeRequest);

    ResponseModel userLogin(UserLoginRequest userLoginRequest);

}
