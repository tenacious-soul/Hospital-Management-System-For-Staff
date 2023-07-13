package com.astrotalk.hospitalManagement.model.requestDTO;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserLoginRequest implements Serializable {

    @NotBlank(message = "Please enter email address.")
    private String email;

    @NotBlank(message = "Please enter your password.")
    private String password;

}
