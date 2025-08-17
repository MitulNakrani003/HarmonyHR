package com.mandm.harmony_hr.repositories;

import com.mandm.harmony_hr.entities.Employee;
import com.mandm.harmony_hr.entities.Job;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface JobRepository extends JpaRepository<Job, Integer> {
    Optional<Job> findByJobId(Integer jobId);

    @EntityGraph(attributePaths = {"employee", "departments"})
    List<Job> findAll();
}
