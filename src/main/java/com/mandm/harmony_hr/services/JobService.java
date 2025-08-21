package com.mandm.harmony_hr.services;

import com.mandm.harmony_hr.dto.JobDetailsDto;
import com.mandm.harmony_hr.dto.JobsDto;
import com.mandm.harmony_hr.entities.Job;
import com.mandm.harmony_hr.mappers.JobToJobDetailsDtoMapper;
import com.mandm.harmony_hr.mappers.JobToJobsDtoMapper;
import com.mandm.harmony_hr.repositories.JobRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobService {

    public final JobRepository jobRepository;

    public JobService(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    public List<JobsDto> getAllJobsList() {
        List<Job> jobs = jobRepository.findAllActive();
        List<JobsDto> jobsDtos = new ArrayList<>();
        for (Job job : jobs) {
            jobsDtos.add(JobToJobsDtoMapper.mapToDto(job));
        }
        return jobsDtos;
    }

    public JobDetailsDto getJobDetailsById(Integer jobId) {
        Job job = jobRepository.findByJobId(jobId)
                .orElseThrow(() -> new RuntimeException("Job not found with id: " + jobId));
        return JobToJobDetailsDtoMapper.mapToDto(job);
    }

    @Transactional
    public void deactivateJobs(List<Integer> jobIds) {
        if (jobIds == null || jobIds.isEmpty()) {
            throw new IllegalArgumentException("Job IDs list cannot be null or empty.");
        }
        jobRepository.deactivateJobsByIds(jobIds);
    }
}
