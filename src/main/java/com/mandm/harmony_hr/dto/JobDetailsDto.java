package com.mandm.harmony_hr.dto;

import java.util.Date;

import lombok.Data;

@Data
public class JobDetailsDto {
    private int jobId;
    private String jobTitle;
    private Date postedOn;
    private int compensation;
    private String jobDescription;
    private String PostedByName;
    private String PostedByEmail;
    private String HiringManagerName;
    private String HiringManagerEmail;
    private Boolean isActive;
    private String jobAddress;
    private String city;
    private String state;
    private int minimumExperience;
    private int maximumExperience;
    private String departmentTitle;
    private String departmentDescription;
}
