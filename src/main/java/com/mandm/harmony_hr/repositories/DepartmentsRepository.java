package com.mandm.harmony_hr.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mandm.harmony_hr.entities.Departments;
import com.mandm.harmony_hr.entities.Employee;

@Repository
public interface DepartmentsRepository extends JpaRepository<Departments, Integer>{

    @Query("SELECT d FROM Departments d WHERE d.isActive = true")
    List<Departments> findAllActive();
}
