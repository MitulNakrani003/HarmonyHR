package com.mandm.harmony_hr.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeEmailDto {
    private Integer empId;
    private String firstName;
    private String lastName;
    private String email;
}
