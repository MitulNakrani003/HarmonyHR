package com.mandm.harmony_hr.entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "job")
public class Job {
    // Getters and Setters
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "job_id")
    private int jobId;

    @Column(name = "job_title", nullable = false, length = 500)
    private String jobTitle;

    @Column(name = "posted_on")
    private Date postedOn;

    @Column(name = "compensation", nullable = false)
    private int compensation;

    @Column(name = "job_description", nullable = true)
    private String jobDescription;

    @OneToOne
    @JoinColumn(name = "posted_by", referencedColumnName = "emp_id")
    private Employee postedBy;

    @OneToOne
    @JoinColumn(name = "hiring_manager", referencedColumnName = "emp_id")
    private Employee hiringManager;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive;

    @Column(name = "job_address", nullable = true, length = 999)
    private String jobAddress;

    @Column(name = "city", nullable = true, length = 200)
    private String city;

    @Column(name = "state", nullable = true, length = 200)
    private String state;

    @Column(name = "minimum_experience", nullable = false)
    private int minimumExperience;

    @Column(name = "maximum_experience", nullable = true)
    private int maximumExperience;

    @OneToOne
    @JoinColumn(name = "department_id", referencedColumnName = "department_id")
    private Departments departmentId;
}
