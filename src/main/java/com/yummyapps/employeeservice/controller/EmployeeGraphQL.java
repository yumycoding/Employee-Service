package com.yummyapps.employeeservice.controller;

import com.yummyapps.employeeservice.model.Employee;
import com.yummyapps.employeeservice.service.EmployeeService;
import lombok.RequiredArgsConstructor;
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

}
