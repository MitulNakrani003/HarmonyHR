package com.mandm.harmony_hr.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "departments")
public class Departments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "department_id")
    private int departmentId;

    @Column(name = "department_title", nullable = false, length = 255)
    private String departmentTitle;

    @Column(name = "description", nullable = true, length = 1000)
    private String departmentDescription;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive;
}
