package com.mandm.harmony_hr;

import com.mandm.harmony_hr.dto.CreateJobDto;
import com.mandm.harmony_hr.dto.DepartmentTitlesDto;
import com.mandm.harmony_hr.dto.JobDetailsDto;
import com.mandm.harmony_hr.dto.JobEditDetailsDto;
import com.mandm.harmony_hr.dto.JobsDto;
import com.mandm.harmony_hr.entities.Job;
import com.mandm.harmony_hr.services.DepartmentsService;
import com.mandm.harmony_hr.services.JobService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/jobs")
public class JobController {

    private final JobService jobService;
    private final DepartmentsService departmentService;

    public JobController(JobService jobService, DepartmentsService departmentService) {
        this.jobService = jobService;
        this.departmentService = departmentService;
    }

    @GetMapping("/")
    @PreAuthorize("hasRole('ADMIN') or hasRole('EMPLOYEE')")
    public ResponseEntity<List<JobsDto>> getAllJobsList() {
        return ResponseEntity.ok(jobService.getAllJobsList());
    }

    @GetMapping("/{jobid}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('EMPLOYEE')")
    public ResponseEntity<JobDetailsDto> getJobDetailsById(@PathVariable("jobid") Integer jobid) {
        JobDetailsDto job = jobService.getJobDetailsById(jobid);
        return ResponseEntity.ok(job);
    }

    @PutMapping("/deactivate")
    @PreAuthorize("hasRole('ADMIN') or hasRole('EMPLOYEE')")// Change this to 'ADMIN' 
    public ResponseEntity<String> deactivateMultipleJobs(@RequestBody List<Integer> jobIds) {
        jobService.deactivateJobs(jobIds);
        return ResponseEntity.ok("Jobs with IDs: " + jobIds + " have been deactivated.");
    }

    @PostMapping("/create")
    @PreAuthorize("hasRole('ADMIN') or hasRole('EMPLOYEE')")// Change this to 'ADMIN' 
    public ResponseEntity<JobDetailsDto> createJob(@RequestBody CreateJobDto createJobDto) {
        JobDetailsDto newJob = jobService.createJob(createJobDto);
        return new ResponseEntity<>(newJob, HttpStatus.CREATED);
    }

    @GetMapping("/editform/{jobid}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('EMPLOYEE')")// Change this to 'ADMIN' 
    public ResponseEntity<JobEditDetailsDto> getJobEditDetailsById(@PathVariable("jobid") Integer jobid) {
        JobEditDetailsDto job = jobService.getJobEditDetailsById(jobid);
        return ResponseEntity.ok(job);
    }

    @PutMapping("update/{jobid}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<JobDetailsDto> updateJob(@PathVariable("jobid") Integer jobid, @RequestBody CreateJobDto updateJobDto) {
        JobDetailsDto updatedJob = jobService.updateJob(jobid, updateJobDto);
        return ResponseEntity.ok(updatedJob);
    }

}
