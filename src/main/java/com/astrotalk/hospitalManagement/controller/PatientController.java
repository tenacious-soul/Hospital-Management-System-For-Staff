package com.astrotalk.hospitalManagement.controller;

import com.astrotalk.hospitalManagement.model.requestDTO.AdmitPatientRequest;
import com.astrotalk.hospitalManagement.model.requestDTO.FetchAllPatientsRequest;
import com.astrotalk.hospitalManagement.model.responseDTO.PatientsList;
import com.astrotalk.hospitalManagement.model.responseDTO.ResponseModel;
import com.astrotalk.hospitalManagement.service.PatientService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.astrotalk.hospitalManagement.constants.EndpointConstants.*;

/**
 * The type Patient controller.
 */
@RestController
@RequestMapping(HOSPITAL_MANAGEMENT)
public class PatientController {

    /**
     * The Patient service.
     */
    @Autowired
    PatientService patientService;

    /**
     * Admit patient response model.
     *
     * @param admitPatientRequest the admit patient request
     * @return the response model
     */
    @PostMapping(ADMIT_PATIENT)
    ResponseModel admitPatient(@RequestBody AdmitPatientRequest admitPatientRequest) {
        return patientService.savePatient(admitPatientRequest);
    }

    /**
     * Gets patients list.
     *
     * @param fetchAllPatientsRequest the fetch all patients request
     * @return the patients list
     */
    @GetMapping(FETCH_ALL_PATIENTS)
    PatientsList getPatientsList(@Valid @RequestBody FetchAllPatientsRequest fetchAllPatientsRequest) {
        return patientService.getPatientsList(fetchAllPatientsRequest);
    }

    /**
     * Discharge patient response model.
     *
     * @param patientId the patient id
     * @return the response model
     */
    @PutMapping(DISCHARGE_PATIENT)
    ResponseModel dischargePatient(@Valid @RequestParam("patient_id") @NotNull(message = "patient_id cannot be empty") Long patientId) {
        return patientService.dischargePatient(patientId);
    }


}
