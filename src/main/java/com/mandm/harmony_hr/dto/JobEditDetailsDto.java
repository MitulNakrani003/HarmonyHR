package com.mandm.harmony_hr.dto;

import java.util.Date;

import lombok.Data;

@Data
public class JobEditDetailsDto {
    private int jobId;
    private String jobTitle;
    private int compensation;
    private String jobDescription;
    private int hiringManagerId;
    private String jobAddress;
    private String city;
    private String state;
    private int minimumExperience;
    private int maximumExperience;
    private int departmentId;
}
