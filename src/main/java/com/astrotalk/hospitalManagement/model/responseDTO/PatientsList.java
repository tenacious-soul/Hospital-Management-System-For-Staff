package com.astrotalk.hospitalManagement.model.responseDTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serializable;
import java.util.List;

/**
 * The type Patients list.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PatientsList implements Serializable {

    @JsonProperty("patients_list")
    private List<PatientDetail> patientList;
    private String message;
}
