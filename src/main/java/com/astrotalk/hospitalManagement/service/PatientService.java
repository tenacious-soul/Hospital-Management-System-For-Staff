package com.astrotalk.hospitalManagement.service;

import com.astrotalk.hospitalManagement.model.requestDTO.AdmitPatientRequest;
import com.astrotalk.hospitalManagement.model.requestDTO.FetchAllPatientsRequest;
import com.astrotalk.hospitalManagement.model.responseDTO.PatientsList;
import com.astrotalk.hospitalManagement.model.responseDTO.ResponseModel;


public interface PatientService {

    ResponseModel savePatient(AdmitPatientRequest admitPatientRequest);

    PatientsList getPatientsList(FetchAllPatientsRequest fetchAllPatientsRequest);

    ResponseModel dischargePatient(Long patientId);

}
