package com.mandm.harmony_hr.repositories;

import com.mandm.harmony_hr.entities.Employee;
import com.mandm.harmony_hr.entities.Job;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface JobRepository extends JpaRepository<Job, Integer> {

    @Query("SELECT j FROM Job j LEFT JOIN FETCH j.postedBy LEFT JOIN FETCH j.hiringManager LEFT JOIN FETCH j.departmentId WHERE j.jobId = :jobId")
    Optional<Job> findByJobId(Integer jobId);

    @Query("SELECT j FROM Job j LEFT JOIN FETCH j.postedBy LEFT JOIN FETCH j.hiringManager LEFT JOIN FETCH j.departmentId")
    List<Job> findAll();

}
