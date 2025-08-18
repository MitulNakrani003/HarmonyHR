package com.mandm.harmony_hr.services;

import com.mandm.harmony_hr.dto.JobsDto;
import com.mandm.harmony_hr.entities.Job;
import com.mandm.harmony_hr.mappers.JobToJobsDtoMapper;
import com.mandm.harmony_hr.repositories.JobRepository;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobService {

    public final JobRepository jobRepository;

    public JobService(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    public List<JobsDto> getAllJobsList() {
        List<Job> jobs = jobRepository.findAll();
        List<JobsDto> jobsDtos = new ArrayList<>();
        for (Job job : jobs) {
            jobsDtos.add(JobToJobsDtoMapper.mapToDto(job));
        }
        return jobsDtos;
    }
}
