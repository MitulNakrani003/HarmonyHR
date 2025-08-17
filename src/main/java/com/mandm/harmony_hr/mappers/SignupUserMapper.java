package com.mandm.harmony_hr.mappers;

import com.mandm.harmony_hr.dto.SignupRequest;
import com.mandm.harmony_hr.entities.Employee;
import com.mandm.harmony_hr.entities.Users;
import com.mandm.harmony_hr.models.Roles;
import com.mandm.harmony_hr.repositories.EmployeeRepository;
import org.springframework.security.crypto.password.PasswordEncoder;

public class SignupUserMapper {

    public static Users toEntity(SignupRequest signUpRequest, PasswordEncoder passwordEncoder, EmployeeRepository employeeRepository) {
        Users user = new Users();
        user.setUsername(signUpRequest.getUsername());
        user.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));
        user.setAccessRights(Roles.valueOf(signUpRequest.getAccessRights()));

        // Fetch the Employee entity and set it
        Employee employee = employeeRepository.findByEmail(signUpRequest.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("Invalid employee Email: " + signUpRequest.getEmail()));
        user.setBelongsTo(employee);

        return user;
    }
}
