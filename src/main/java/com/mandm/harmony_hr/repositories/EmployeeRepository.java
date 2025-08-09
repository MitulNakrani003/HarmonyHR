package com.mandm.harmony_hr.repositories;

import com.mandm.harmony_hr.entities.Employee;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    /**
     * Finds an employee by their employee ID.
     *
     * @param empId the employee ID to search for
     * @return an Optional containing the Employee if found, or empty if not found
     */
    Optional<Employee> findByEmpId(Integer empId);

    /**
     * Retrieves all employees along with their associated addresses.
     *
     * @return a list of all employees with their addresses
     */
    @EntityGraph(attributePaths = {"address"})
    List<Employee> findAll();

}
