package com.devsuperior.demo.repository;

import com.devsuperior.demo.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    @Query("SELECT d FROM Department d ORDER BY d.name ASC")
    List<Department> findAllOrderByName();
}
