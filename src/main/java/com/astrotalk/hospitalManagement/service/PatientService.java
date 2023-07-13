package com.astrotalk.hospitalManagement.service;

import com.astrotalk.hospitalManagement.model.requestDTO.AdmitPatientRequest;
import com.astrotalk.hospitalManagement.model.requestDTO.FetchAllPatientsRequest;
import com.astrotalk.hospitalManagement.model.responseDTO.PatientsList;
import com.astrotalk.hospitalManagement.model.responseDTO.ResponseModel;


/**
 * The interface Patient service.
 */
public interface PatientService {

    /**
     * Save patient response model.
     *
     * @param admitPatientRequest the admit patient request
     * @return the response model
     */
    ResponseModel savePatient(AdmitPatientRequest admitPatientRequest);

    /**
     * Gets patients list.
     *
     * @param fetchAllPatientsRequest the fetch all patients request
     * @return the patients list
     */
    PatientsList getPatientsList(FetchAllPatientsRequest fetchAllPatientsRequest);

    /**
     * Discharge patient response model.
     *
     * @param patientId the patient id
     * @return the response model
     */
    ResponseModel dischargePatient(Long patientId);

}
