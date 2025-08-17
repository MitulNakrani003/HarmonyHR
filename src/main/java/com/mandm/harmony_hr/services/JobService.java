package com.mandm.harmony_hr.services;

import com.mandm.harmony_hr.entities.Job;
import com.mandm.harmony_hr.repositories.JobRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {

    public final JobRepository jobRepository;

    public JobService(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }
}
