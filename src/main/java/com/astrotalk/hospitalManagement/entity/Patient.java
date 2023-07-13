package com.astrotalk.hospitalManagement.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

/**
 * The type Patient.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "patient_id")
    @JsonProperty("patient_id")
    @SerializedName("patient_id")
    private Long patientId;

    @Column(name = "patient_name")
    @SerializedName("patient_name")
    @JsonProperty("patient_name")
    private String patientName;

    @Column(name = "mobile_number")
    @SerializedName("mobile_number")
    @JsonProperty("mobile_number")
    private Long mobileNumber;

    @Column(name = "age")
    @SerializedName("age")
    private Integer age;

    @Column(name = "room_number")
    @SerializedName("room_number")
    @JsonProperty("room_number")
    private Integer roomNumber;

    @Column(name = "doctor_name")
    @SerializedName("doctor_name")
    @JsonProperty("doctor_name")
    private String doctorName;

    @Column(name = "admission_date")
    @SerializedName("admission_date")
    @JsonProperty("admission_date")
    private LocalDate admissionDate;

    @Column(name = "expenses")
    @SerializedName("expenses")
    private Integer expenses;

    @Column(name = "patient_status")
    @SerializedName("patient_status")
    @JsonProperty("patient_status")
    private Integer patientStatus;

    @Column(name = "gender")
    @SerializedName("gender")
    private String gender;

}
