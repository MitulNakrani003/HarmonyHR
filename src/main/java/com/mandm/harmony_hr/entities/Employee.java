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
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "employee")
public class Employee {
    // Getters and Setters
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_id")
    private int empId;
    @Column(name = "first_name", nullable = false, length = 200)
    private String firstName;
    @Column(name = "last_name", nullable = true, length = 200)
    private String lastName;
    @Column(name = "email", nullable = false, length = 200, unique = true)
    private String email;
    @Column(name = "contact", nullable = false, length = 50)
    private String contact;
    @OneToOne
    @JoinColumn(name = "address_id", referencedColumnName = "address_id")
    private Address address;
    @Column(name = "job_title", nullable = false, length = 200)
    private String jobTitle;
    @Column(name = "dob", nullable = false)
    private Date dateOfBirth;
    @Column(name = "joining_date")
    private Date joiningDate;
    @Column(name = "is_serving")
    private Boolean isServing;

}
