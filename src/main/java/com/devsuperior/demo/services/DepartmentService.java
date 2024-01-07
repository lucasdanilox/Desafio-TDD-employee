package com.devsuperior.demo.services;

import com.devsuperior.demo.dto.DepartmentDTO;
import com.devsuperior.demo.entities.Department;
import com.devsuperior.demo.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;


    @Transactional(readOnly = true)
    public List<DepartmentDTO> findAll() {
        List<Department> result = departmentRepository.findAll(Sort.by("name"));
        return result.stream().map(x -> new DepartmentDTO(x)).collect(Collectors.toList());
    }

}
