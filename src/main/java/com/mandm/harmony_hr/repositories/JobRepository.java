package com.mandm.harmony_hr.repositories;

import com.mandm.harmony_hr.entities.Employee;
import com.mandm.harmony_hr.entities.Job;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface JobRepository extends JpaRepository<Job, Integer> {

    @Query("SELECT j FROM Job j " +
            "LEFT JOIN FETCH j.postedBy pb " +
            "LEFT JOIN FETCH pb.address " +
            "LEFT JOIN FETCH j.hiringManager hm " +
            "LEFT JOIN FETCH hm.address " +
            "LEFT JOIN FETCH j.departmentId " +
            "WHERE j.jobId = :jobId")
    @EntityGraph(attributePaths = {"postedBy", "postedBy.address", "hiringManager", "hiringManager.address", "departmentId"})
    Optional<Job> findByJobId(Integer jobId);

    @Query("SELECT j FROM Job j " +
            "LEFT JOIN FETCH j.postedBy pb " +
            "LEFT JOIN FETCH pb.address " +
            "LEFT JOIN FETCH j.hiringManager hm " +
            "LEFT JOIN FETCH hm.address " +
            "LEFT JOIN FETCH j.departmentId " +
            "WHERE j.isActive = true")
    List<Job> findAllActive();

    @Modifying
    @Query("UPDATE Job j SET j.isActive = false WHERE j.jobId IN :jobIds")
    void deactivateJobsByIds(@Param("jobIds") List<Integer> jobIds);



}
