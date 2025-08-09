package com.mandm.harmony_hr.entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int jobId;
    @Column(name = "jobTitle", nullable = false, length = 500)
    private String jobTitle;
    @Column(name = "postedOn")
    private Date postedOn;
    @Column(name = "compensation", nullable = false)
    private int compensation;
    @Column(name = "jobDescription", nullable = true)
    private String jobDescription;
    @OneToOne
    @JoinColumn(name = "postedBy", referencedColumnName = "empId")
    private Employee postedBy;
    @OneToOne
    @JoinColumn(name = "hiringManager", referencedColumnName = "empId")
    private Employee hiringManager;
    @Column(name = "isActive", nullable = false)
    private Boolean isActive;

    // Getters and Setters
    public int getJobId() {
        return jobId;
    }
    public void setJobId(int jobId) {
        this.jobId = jobId;
    }
    public String getJobTitle() {
        return jobTitle;
    }
    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }
    public Date getPostedOn() {
        return postedOn;
    }
    public void setPostedOn(Date postedOn) {
        this.postedOn = postedOn;
    }
    public int getCompensation() {
        return compensation;
    }
    public void setCompensation(int compensation) {
        this.compensation = compensation;
    }
    public Employee getHiringManager() {
        return hiringManager;
    }
    public void setHiringManager(Employee hiringManager) {
        this.hiringManager = hiringManager;
    }
    public Employee getPostedBy() {
        return postedBy;
    }
    public void setPostedBy(Employee postedBy) {
        this.postedBy = postedBy;
    }
    public String getJobDescription() {
        return jobDescription;
    }
    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }
    public Boolean getIsActive() {
        return isActive;
    }
    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }
}
