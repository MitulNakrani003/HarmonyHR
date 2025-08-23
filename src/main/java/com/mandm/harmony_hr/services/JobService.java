package com.mandm.harmony_hr.services;

import com.mandm.harmony_hr.dto.CreateJobDto;
import com.mandm.harmony_hr.dto.JobDetailsDto;
import com.mandm.harmony_hr.dto.JobEditDetailsDto;
import com.mandm.harmony_hr.dto.JobsDto;
import com.mandm.harmony_hr.entities.Departments;
import com.mandm.harmony_hr.entities.Employee;
import com.mandm.harmony_hr.entities.Job;
import com.mandm.harmony_hr.mappers.JobToJobDetailsDtoMapper;
import com.mandm.harmony_hr.mappers.JobToJobEditDetailsDtoMapper;
import com.mandm.harmony_hr.mappers.JobToJobsDtoMapper;
import com.mandm.harmony_hr.repositories.DepartmentsRepository;
import com.mandm.harmony_hr.repositories.EmployeeRepository;
import com.mandm.harmony_hr.repositories.JobRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class JobService {

    private final JobRepository jobRepository;
    private final EmployeeRepository employeeRepository;
    private final DepartmentsRepository departmentsRepository;

    public JobService(JobRepository jobRepository, EmployeeRepository employeeRepository,
            DepartmentsRepository departmentsRepository) {
        this.jobRepository = jobRepository;
        this.employeeRepository = employeeRepository;
        this.departmentsRepository = departmentsRepository;
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

    public JobEditDetailsDto getJobEditDetailsById(Integer jobId) {
        Job job = jobRepository.findByJobId(jobId)
                .orElseThrow(() -> new RuntimeException("Job not found with id: " + jobId));
        return JobToJobEditDetailsDtoMapper.mapToDto(job);
    }

    @Transactional
    public JobDetailsDto createJob(CreateJobDto createJobDto) {
        Employee postedBy = employeeRepository.findEmployeeByUserId(createJobDto.getPostedByUserId())
                .orElseThrow(() -> new RuntimeException("Posted By Employee not found with id: " + createJobDto.getPostedByUserId()));

        Employee hiringManager = employeeRepository.findById(createJobDto.getHiringManagerId())
                .orElseThrow(() -> new RuntimeException("Hiring Manager not found with id: " + createJobDto.getHiringManagerId()));

        Departments department = departmentsRepository.findById(createJobDto.getDepartmentId())
                .orElseThrow(() -> new RuntimeException("Department not found with id: " + createJobDto.getDepartmentId()));

        Job job = new Job();
        job.setJobTitle(createJobDto.getJobTitle());
        job.setCompensation(createJobDto.getCompensation());
        job.setJobDescription(createJobDto.getJobDescription());
        job.setPostedBy(postedBy);
        job.setHiringManager(hiringManager);
        job.setDepartmentId(department);
        job.setJobAddress(createJobDto.getJobAddress());
        job.setCity(createJobDto.getCity());
        job.setState(createJobDto.getState());
        job.setMinimumExperience(createJobDto.getMinimumExperience());
        job.setMaximumExperience(createJobDto.getMaximumExperience());
        job.setPostedOn(new Date());
        job.setIsActive(true);

        Job savedJob = jobRepository.save(job);
        return JobToJobDetailsDtoMapper.mapToDto(savedJob);
    }

    @Transactional
    public JobDetailsDto updateJob(Integer jobId, CreateJobDto updateJobDto) {
        Job jobToUpdate = jobRepository.findById(jobId)
                .orElseThrow(() -> new RuntimeException("Job not found with id: " + jobId));

        Employee postedBy = employeeRepository.findEmployeeByUserId(updateJobDto.getPostedByUserId())
                .orElseThrow(() -> new RuntimeException("Posted By Employee not found with user id: " + updateJobDto.getPostedByUserId()));

        Employee hiringManager = employeeRepository.findById(updateJobDto.getHiringManagerId())
                .orElseThrow(() -> new RuntimeException("Hiring Manager not found with id: " + updateJobDto.getHiringManagerId()));

        Departments department = departmentsRepository.findById(updateJobDto.getDepartmentId())
                .orElseThrow(() -> new RuntimeException("Department not found with id: " + updateJobDto.getDepartmentId()));

        jobToUpdate.setJobTitle(updateJobDto.getJobTitle());
        jobToUpdate.setCompensation(updateJobDto.getCompensation());
        jobToUpdate.setJobDescription(updateJobDto.getJobDescription());
        jobToUpdate.setPostedBy(postedBy);
        jobToUpdate.setHiringManager(hiringManager);
        jobToUpdate.setDepartmentId(department);
        jobToUpdate.setJobAddress(updateJobDto.getJobAddress());
        jobToUpdate.setCity(updateJobDto.getCity());
        jobToUpdate.setState(updateJobDto.getState());
        jobToUpdate.setMinimumExperience(updateJobDto.getMinimumExperience());
        jobToUpdate.setMaximumExperience(updateJobDto.getMaximumExperience());

        Job updatedJob = jobRepository.save(jobToUpdate);
        return JobToJobDetailsDtoMapper.mapToDto(updatedJob);
    }

    @Transactional
    public void deactivateJobs(List<Integer> jobIds) {
        if (jobIds == null || jobIds.isEmpty()) {
            throw new IllegalArgumentException("Job IDs list cannot be null or empty.");
        }
        jobRepository.deactivateJobsByIds(jobIds);
    }
}
