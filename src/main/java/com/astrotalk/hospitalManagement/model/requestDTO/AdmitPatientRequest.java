package com.astrotalk.hospitalManagement.model.requestDTO;

import com.astrotalk.hospitalManagement.entity.Expenses;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.io.Serializable;
import java.util.List;

import static com.astrotalk.hospitalManagement.constants.Constants.PATIENT_ADMITTED;

/**
 * The type Admit patient request.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AdmitPatientRequest implements Serializable {

    @JsonProperty("patient_name")
    @NotBlank(message = "Please enter patient's name")
    private String patientName;

    @JsonProperty("mobile_number")
    @NotNull(message = "Please enter mobile number")
    private Long mobileNumber;

    @JsonProperty("age")
    @NotNull(message = "Please enter age")
    private Integer age;

    @JsonProperty("room_number")
    @NotNull(message = "Please enter room number")
    private Integer roomNumber;

    @JsonProperty("doctor_name")
    private String doctorName;

    @JsonProperty("admission_date")
    @NotBlank
    @Pattern(regexp = "\\d{1,2}\\/\\d{1,2}\\/\\d{2,4}")
    private String admissionDate;

    @JsonProperty("expenses")
    private List<Expenses> expenses;

    @JsonProperty("patient_status")
    @Builder.Default
    private Integer patientStatus = PATIENT_ADMITTED;

    @NotBlank(message = "Please enter gender")
    @Pattern(regexp = "Male|Female|Other", message = "Please enter either 'Male' or 'Female' or 'Other' as gender")
    private String gender;

}
