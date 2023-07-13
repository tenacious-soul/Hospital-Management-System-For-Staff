package com.astrotalk.hospitalManagement.controller;

import com.astrotalk.hospitalManagement.model.requestDTO.AdmitPatientRequest;
import com.astrotalk.hospitalManagement.model.requestDTO.FetchAllPatientsRequest;
import com.astrotalk.hospitalManagement.model.responseDTO.PatientsList;
import com.astrotalk.hospitalManagement.model.responseDTO.ResponseModel;
import com.astrotalk.hospitalManagement.service.PatientService;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.astrotalk.hospitalManagement.constants.EndpointConstants.*;

@RestController
@RequestMapping(HOSPITAL_MANAGEMENT)
public class PatientController {

    @Autowired
    PatientService patientService;

    @PostMapping(ADMIT_PATIENT)
    ResponseModel admitPatient(@RequestBody AdmitPatientRequest admitPatientRequest) {
        return patientService.savePatient(admitPatientRequest);
    }

    @GetMapping(FETCH_ALL_PATIENTS)
    PatientsList getPatientsList(@Valid @RequestBody FetchAllPatientsRequest fetchAllPatientsRequest) {
        return patientService.getPatientsList(fetchAllPatientsRequest);
    }

    @PutMapping(DISCHARGE_PATIENT)
    ResponseModel dischargePatient(@Valid @RequestBody @NotNull(message = "patient_id cannot be empty") @JsonProperty("patient_id") Long patientId) {
        return patientService.dischargePatient(patientId);
    }


}
