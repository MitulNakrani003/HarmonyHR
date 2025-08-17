package com.mandm.harmony_hr.repositories;

import com.mandm.harmony_hr.entities.Job;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository extends JpaRepository<Job, Integer> {
    // Additional query methods can be defined here if needed
}
