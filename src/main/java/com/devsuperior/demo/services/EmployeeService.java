package com.devsuperior.demo.services;

import com.devsuperior.demo.dto.EmployeeDTO;
import com.devsuperior.demo.entities.Department;
import com.devsuperior.demo.entities.Employee;
import com.devsuperior.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Transactional(readOnly = true)
    public Page<EmployeeDTO> findAll(Pageable pageable) {
        Page<Employee> result = employeeRepository.findAll(pageable);
        return result.map(x -> new EmployeeDTO(x));
    }


    @Transactional
    public EmployeeDTO insert(EmployeeDTO dto) {
        Employee employee = new Employee();
        copyEmployee(dto, employee);
        employee = employeeRepository.save(employee);

        return new EmployeeDTO(employee);

    }

    private void copyEmployee(EmployeeDTO dto, Employee employee) {

        employee.setId(dto.getId());
        employee.setName(dto.getName());
        employee.setEmail(dto.getEmail());

        Department department = new Department();
        department.setId(dto.getDepartmentId());
        employee.setDepartment(department);
    }
}

