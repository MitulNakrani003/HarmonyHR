package com.mandm.harmony_hr.services;

import com.mandm.harmony_hr.entities.Employee;
import com.mandm.harmony_hr.repositories.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(int empId) {
        return employeeRepository.findByEmpId(empId)
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + empId));
    }
}
