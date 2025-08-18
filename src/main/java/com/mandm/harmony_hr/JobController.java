package com.mandm.harmony_hr;

import com.mandm.harmony_hr.dto.JobsDto;
import com.mandm.harmony_hr.entities.Job;
import com.mandm.harmony_hr.services.JobService;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/jobs")
public class JobController {

    private final JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping("/")
    @PreAuthorize("hasRole('ADMIN') or hasRole('EMPLOYEE')")
    public ResponseEntity<List<JobsDto>> getAllJobsList() {
        return ResponseEntity.ok(jobService.getAllJobsList());
    }
}
