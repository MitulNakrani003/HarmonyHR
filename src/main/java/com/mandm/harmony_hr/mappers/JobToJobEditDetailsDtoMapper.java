package com.mandm.harmony_hr.mappers;

import com.mandm.harmony_hr.dto.JobDetailsDto;
import com.mandm.harmony_hr.dto.JobEditDetailsDto;
import com.mandm.harmony_hr.entities.Job;

public class JobToJobEditDetailsDtoMapper {

     public static JobEditDetailsDto mapToDto(Job job) {
            if (job == null) {
                 return null;
            }
    
            JobEditDetailsDto dto = new JobEditDetailsDto();
            dto.setJobId(job.getJobId());
            dto.setJobTitle(job.getJobTitle());
            dto.setJobDescription(job.getJobDescription());
            dto.setJobAddress(job.getJobAddress());
            dto.setCompensation(job.getCompensation());
            dto.setCity(job.getCity());
            dto.setState(job.getState());
            dto.setMinimumExperience(job.getMinimumExperience());
            dto.setMaximumExperience(job.getMaximumExperience());
            dto.setDepartmentId(job.getDepartmentId().getDepartmentId());
            dto.setHiringManagerId(job.getHiringManager().getEmpId());
            return dto;
        }
    
}
