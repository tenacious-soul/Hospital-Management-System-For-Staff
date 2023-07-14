package com.astrotalk.hospitalManagement.model.responseDTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import lombok.*;

import java.io.Serializable;
import java.sql.Date;

/**
 * The type Patient detail.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PatientDetail implements Serializable {

    @JsonProperty("patient_id")
    @SerializedName("patient_id")
    private Long patientId;

    @SerializedName("patient_name")
    @JsonProperty("patient_name")
    private String patientName;

    @SerializedName("mobile_number")
    @JsonProperty("mobile_number")
    private Long mobileNumber;

    @SerializedName("age")
    private Integer age;

    @SerializedName("room_number")
    @JsonProperty("room_number")
    private Integer roomNumber;

    @SerializedName("doctor_name")
    @JsonProperty("doctor_name")
    private String doctorName;

    @SerializedName("admission_date")
    @JsonProperty("admission_date")
    private Date admissionDate;

    @SerializedName("patient_status")
    @JsonProperty("patient_status")
    private Integer patientStatus;

    @SerializedName("gender")
    private String gender;
}
