package com.yummyapps.employeeservice.controller;

import com.yummyapps.employeeservice.model.Department;
import com.yummyapps.employeeservice.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
<<<<<<< HEAD
import org.springframework.security.access.prepost.PreAuthorize;
=======
>>>>>>> origin/master
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class DepartmentGraphQL {

    private final DepartmentService departmentService;

<<<<<<< HEAD
    @PreAuthorize("hasRole('ROLE_ADMIN')")
=======
>>>>>>> origin/master
    @MutationMapping()
    Department departmentCreate(@Argument String name) {
        var depart = new Department();
        depart.setName(name);
        return departmentService.createDepartment(depart);
    }

    @QueryMapping()
<<<<<<< HEAD
    @PreAuthorize("hasAnyRole('ROLE_GUEST','ROLE_USER','ROLE_ADMIN')")
=======
>>>>>>> origin/master
    List<Department> departments() {
        return departmentService.deparmetns();
    }

}
