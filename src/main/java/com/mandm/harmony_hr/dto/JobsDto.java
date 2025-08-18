package com.mandm.harmony_hr.dto;

import com.mandm.harmony_hr.entities.Employee;

import java.util.Date;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class JobsDto {
    private int jobId;
    private String jobTitle;
    private Date postedOn;
    private String jobDescription;
    private Boolean isActive;
    private String jobAddress;
    private String city;
    private String state;
    private int minimumExperience;
    private int maximumExperience;
    private String departmentTitle;
}
