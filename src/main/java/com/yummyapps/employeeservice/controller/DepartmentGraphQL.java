package com.yummyapps.employeeservice.controller;

import com.yummyapps.employeeservice.model.Department;
import com.yummyapps.employeeservice.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;

import org.springframework.security.access.prepost.PreAuthorize;

import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class DepartmentGraphQL {

    private final DepartmentService departmentService;


    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @MutationMapping()
    Department departmentCreate(@Argument String name) {
        var depart = new Department();
        depart.setName(name);
        return departmentService.createDepartment(depart);
    }

    @QueryMapping()
    @PreAuthorize("hasAnyRole('ROLE_GUEST','ROLE_USER','ROLE_ADMIN')")
    List<Department> departments() {
        return departmentService.deparmetns();
    }

}
