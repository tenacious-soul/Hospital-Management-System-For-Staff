package com.astrotalk.hospitalManagement.model.requestDTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FetchAllPatientsRequest implements Serializable {

    @JsonProperty("patient_id")
    private Long patientId;

    @JsonProperty("patient_name")
    private String patientName;

    @JsonProperty("mobile_number")
    private Long mobileNumber;

    @JsonProperty("room_number")
    private Integer roomNumber;

    @JsonProperty("patient_status")
    @Min(0) @Max(1)
    private Integer patientStatus;

    @JsonProperty("admission_date")
    private String admissionDate;

}
