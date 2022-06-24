package com.yummyapps.employeeservice.resource;

import com.yummyapps.employeeservice.model.Employee;
import com.yummyapps.employeeservice.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/v1/employees")
public class EmployeeResource {

    private final EmployeeService employeeService;


    @GetMapping(path = "/all")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        var employeeList = employeeService.fetchAllEmployees();
        return new ResponseEntity<>(employeeList, HttpStatus.FOUND);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Employee> findEmployeeById(@PathVariable(name = "id") Long id) {
        var employee = employeeService.findEmployeeById(id);
        return new ResponseEntity<>(employee, HttpStatus.FOUND);
    }

    @GetMapping(path = "/{name}")
    public ResponseEntity<Employee> findEmployeeByName(@PathVariable(name = "name") String name) {
        var employee = employeeService.findEmployeeByName(name);
        return new ResponseEntity<>(employee, HttpStatus.FOUND);
    }

    @PostMapping(path = "/save")
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
        var savedEmployee = employeeService.saveEmployee(employee);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(path = "/del/{id}")
    public void deleteEmployee(@PathVariable(name = "id") Long id) {
        employeeService.deleteEmployee(id);
    }

}
