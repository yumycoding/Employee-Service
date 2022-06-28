package com.yummyapps.employeeservice.controller;

import com.yummyapps.employeeservice.dto.EmployeeInput;
import com.yummyapps.employeeservice.model.Employee;
import com.yummyapps.employeeservice.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class EmployeeGraphQL {

    private final EmployeeService employeeService;

    @QueryMapping
    List<Employee> employees() {
        return employeeService.fetchAllEmployees();
    }

    @QueryMapping
    Employee employeeById(@Argument long id) {
        return employeeService.findEmployeeById(id);
    }


    @QueryMapping
    Employee employeeByEmail(@Argument String email) {
        return employeeService.findEmployeeByEmail(email);
    }


    @MutationMapping
    Employee employeeCreate(@Argument EmployeeInput employeeInput) {
        return employeeService.createEmployee(employeeInput);
    }

    @MutationMapping
    Employee employeeUpdate(@Argument EmployeeInput employeeInput) {
        return employeeService.updateEmployee(employeeInput);
    }


}
