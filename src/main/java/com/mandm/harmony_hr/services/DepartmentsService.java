package com.mandm.harmony_hr.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.mandm.harmony_hr.dto.DepartmentTitlesDto;
import com.mandm.harmony_hr.dto.JobsDto;
import com.mandm.harmony_hr.entities.Departments;
import com.mandm.harmony_hr.mappers.DepartmentsToDepartmentTitlesDto;
import com.mandm.harmony_hr.repositories.DepartmentsRepository;

@Service
public class DepartmentsService {

    private final DepartmentsRepository departmentsRepository;

    public DepartmentsService(DepartmentsRepository departmentsRepository) {
        this.departmentsRepository = departmentsRepository;
    }

    public List<DepartmentTitlesDto> getAllActiveDepartmentTitles() {
        List<Departments> activeDepartments = departmentsRepository.findAllActive();
        List<DepartmentTitlesDto> departmentTitlesDtos = new ArrayList<>();
        for (Departments department : activeDepartments) {
            departmentTitlesDtos.add(DepartmentsToDepartmentTitlesDto.mapToDto(department));
        }
        return departmentTitlesDtos;
    }

}
