package com.mandm.harmony_hr.mappers;

import com.mandm.harmony_hr.dto.JobsDto;
import com.mandm.harmony_hr.entities.Job;

public class JobToJobsDtoMapper {

    public static JobsDto mapToDto(Job job){
        if (job == null) {
            return null;
        }
        JobsDto jobsDto = new JobsDto();
        jobsDto.setJobId(job.getJobId());
        jobsDto.setJobTitle(job.getJobTitle());
        jobsDto.setPostedOn(job.getPostedOn());
        jobsDto.setJobDescription(job.getJobDescription());
        jobsDto.setIsActive(job.getIsActive());
        jobsDto.setJobAddress(job.getJobAddress());
        jobsDto.setCity(job.getCity());
        jobsDto.setState(job.getState());
        jobsDto.setMinimumExperience(job.getMinimumExperience());
        jobsDto.setMaximumExperience(job.getMaximumExperience());
        jobsDto.setDepartmentTitle(job.getDepartmentId().getDepartmentTitle());

        return jobsDto;
    }
}
