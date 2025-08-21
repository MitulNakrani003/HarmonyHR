package com.mandm.harmony_hr.mappers;

import com.mandm.harmony_hr.dto.JobDetailsDto;
import com.mandm.harmony_hr.entities.Job;

public class JobToJobDetailsDtoMapper {

    public static JobDetailsDto mapToDto(Job job) {
        if (job == null) {
            return null;
        }
        JobDetailsDto jobDetailsDto = new JobDetailsDto();
        jobDetailsDto.setJobId(job.getJobId());
        jobDetailsDto.setJobTitle(job.getJobTitle());
        jobDetailsDto.setPostedOn(job.getPostedOn());
        jobDetailsDto.setCompensation(job.getCompensation());
        jobDetailsDto.setJobDescription(job.getJobDescription());
        jobDetailsDto.setPostedByName(job.getPostedBy().getFirstName() + " " + job.getPostedBy().getLastName());
        jobDetailsDto.setPostedByEmail(job.getPostedBy().getEmail());
        jobDetailsDto.setHiringManagerName(job.getHiringManager().getFirstName() + " " + job.getHiringManager().getLastName());
        jobDetailsDto.setHiringManagerEmail(job.getHiringManager().getEmail());
        jobDetailsDto.setIsActive(job.getIsActive());
        jobDetailsDto.setJobAddress(job.getJobAddress());
        jobDetailsDto.setCity(job.getCity());
        jobDetailsDto.setState(job.getState());
        jobDetailsDto.setMinimumExperience(job.getMinimumExperience());
        jobDetailsDto.setMaximumExperience(job.getMaximumExperience());
        jobDetailsDto.setDepartmentTitle(job.getDepartmentId().getDepartmentTitle());
        jobDetailsDto.setDepartmentDescription(job.getDepartmentId().getDepartmentDescription());
        return jobDetailsDto;
    }
}
