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
    private String postedByName;
    private String postedByEmail;
    private String hiringManagerName;
    private String hiringManagerEmail;
    private Boolean isActive;
    private String jobAddress;
    private String city;
    private String state;
    private int minimumExperience;
    private int maximumExperience;
    private String departmentTitle;
    private String departmentDescription;
}
