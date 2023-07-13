package com.astrotalk.hospitalManagement.model.requestDTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RegisterEmployeeRequest implements Serializable {

    @JsonProperty("employee_name")
    @NotBlank(message = "Please enter employee name")
    private String employeeName;

    @NotBlank(message = "Please enter email address.")
    private String email;

    @NotBlank(message = "Please enter your password.")
    private String password;
}
