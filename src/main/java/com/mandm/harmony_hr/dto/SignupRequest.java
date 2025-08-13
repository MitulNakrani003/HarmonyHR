package com.mandm.harmony_hr.dto;

import lombok.Data;

@Data
public class SignupRequest {
    private String username;
    private String password;
    private int belongsTo;
    private String accessRights;
}
