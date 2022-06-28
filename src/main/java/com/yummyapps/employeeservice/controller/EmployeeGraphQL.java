package com.yummyapps.employeeservice.controller;

import com.yummyapps.employeeservice.dto.EmployeeInput;
import com.yummyapps.employeeservice.model.Employee;
import com.yummyapps.employeeservice.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class EmployeeGraphQL {

    private final EmployeeService employeeService;


    @QueryMapping
    @PreAuthorize("hasAnyRole({'ROLE_ADMIN','ROLE_USER'})")
    List<Employee> employees() {
        return employeeService.fetchAllEmployees();
    }


    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
    @QueryMapping
    Employee employeeById(@Argument long id) {
        return employeeService.findEmployeeById(id);
    }


    @QueryMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
    Employee employeeByEmail(@Argument String email) {
        return employeeService.findEmployeeByEmail(email);
    }


    @Secured("ROLE_ADMIN")
    @PreAuthorize("hasRole('ADMIN')")
    @MutationMapping
    Employee employeeCreate(@Argument EmployeeInput employeeInput) {
        return employeeService.createEmployee(employeeInput);
    }

    @MutationMapping
    Employee employeeUpdate(@Argument EmployeeInput employeeInput) {
        return employeeService.updateEmployee(employeeInput);
    }


}
