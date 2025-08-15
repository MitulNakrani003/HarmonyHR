package com.mandm.harmony_hr.dto;

import lombok.Data;

@Data
public class JwtResponse {
    private String token;
    private int userId;
    public JwtResponse(String token, int userId) {
        this.token = token;
        this.userId = userId;
    }
}
