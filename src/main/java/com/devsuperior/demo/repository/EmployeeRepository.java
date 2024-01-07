package com.devsuperior.demo.repository;

import com.devsuperior.demo.entities.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    @Query("SELECT d FROM Employee d ORDER BY d.name ASC")
    Page<Employee> searchByName(String name, Pageable pageable);

}
