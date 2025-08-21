package com.mandm.harmony_hr.dto;

import lombok.Data;

@Data
public class CreateJobDto {
    private String jobTitle;
    private int compensation;
    private String jobDescription;
    private Integer postedByUserId;
    private Integer hiringManagerId;
    private Integer departmentId;
    private String jobAddress;
    private String city;
    private String state;
    private int minimumExperience;
    private int maximumExperience;
}
