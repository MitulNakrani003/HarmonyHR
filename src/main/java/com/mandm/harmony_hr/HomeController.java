package com.mandm.harmony_hr;

import com.mandm.harmony_hr.entities.Employee;
import com.mandm.harmony_hr.entities.Users;
import com.mandm.harmony_hr.repositories.UsersRepository;
import com.mandm.harmony_hr.services.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/home")
public class HomeController {

    private final EmployeeService employeeService;
    private final UsersRepository usersRepository;

    @Autowired
    public HomeController(EmployeeService employeeService, UsersRepository usersRepository) {
        this.employeeService = employeeService;
        this.usersRepository = usersRepository;
    }


}
