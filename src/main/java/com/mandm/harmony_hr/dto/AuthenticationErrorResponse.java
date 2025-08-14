package com.mandm.harmony_hr.dto;

import lombok.Data;

@Data
public class AuthenticationErrorResponse {
    private String error;
    private int status;

    public AuthenticationErrorResponse(String error, int status) {
        this.error = error;
        this.status = status;
    }
}
