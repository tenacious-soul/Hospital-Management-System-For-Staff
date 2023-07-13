package com.astrotalk.hospitalManagement.model.responseDTO;

import com.astrotalk.hospitalManagement.entity.Patient;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PatientsList implements Serializable {

    @JsonProperty("patients_list")
    private List<Patient> patientList;
    private String message;
}
