package com.mandm.harmony_hr.mappers;

import com.mandm.harmony_hr.dto.DepartmentTitlesDto;
import com.mandm.harmony_hr.entities.Departments;

public class DepartmentsToDepartmentTitlesDto {

    public static DepartmentTitlesDto mapToDto(Departments department) {
        if (department == null) {
            return null;
        }
        
        DepartmentTitlesDto dto = new DepartmentTitlesDto();
        dto.setDepartmentId(department.getDepartmentId());
        dto.setDepartmentTitle(department.getDepartmentTitle());

        return dto;
    }
    
}
