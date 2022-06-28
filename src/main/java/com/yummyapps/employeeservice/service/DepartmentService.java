package com.yummyapps.employeeservice.service;

import com.yummyapps.employeeservice.dao.DepartmentRepository;
import com.yummyapps.employeeservice.model.Department;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentService {
    private final DepartmentRepository departmentRepository;

    public Department createDepartment(Department department) {
        return departmentRepository.save(department);
    }

    public List<Department> deparmetns() {
        return departmentRepository.findAll();
    }

}
