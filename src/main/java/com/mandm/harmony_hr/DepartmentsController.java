package com.mandm.harmony_hr;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mandm.harmony_hr.dto.DepartmentTitlesDto;
import com.mandm.harmony_hr.services.DepartmentsService;

@RestController
@RequestMapping("/api/departments")
public class DepartmentsController {

    private final DepartmentsService departmentService;

    public DepartmentsController(DepartmentsService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/")
    @PreAuthorize("hasRole('ADMIN') or hasRole('EMPLOYEE')")
    public ResponseEntity<List<DepartmentTitlesDto>> getActiveDepartments() {
        return ResponseEntity.ok(departmentService.getAllActiveDepartmentTitles());
    }

}
