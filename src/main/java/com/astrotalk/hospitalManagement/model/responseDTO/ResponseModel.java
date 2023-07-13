package com.astrotalk.hospitalManagement.model.responseDTO;

import lombok.*;

import java.io.Serializable;

/**
 * The type Response model.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseModel implements Serializable {
    private String message;
}
