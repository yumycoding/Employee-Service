package com.yummyapps.employeeservice.service;

import com.yummyapps.employeeservice.dao.AddressRepository;
import com.yummyapps.employeeservice.dao.EmployeeRepository;
import com.yummyapps.employeeservice.model.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public List<Employee> fetchAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee findEmployeeById(Long employeeId) {
        return employeeRepository.findById(employeeId).orElseThrow(() ->
                new EntityNotFoundException("record not found"));
    }

    public Employee findEmployeeByName(String name) {
        return employeeRepository.findByFirstNameOrLastName(name).orElseThrow(() ->
                new EntityNotFoundException("record not found"));
    }

    public Employee saveEmployee(Employee employee) {
        employeeRepository.findByEmail(employee.getEmail()).ifPresent(
                (email) -> {
                    throw new EntityExistsException(email.getEmail() + " already exist , please use other email ");
                }
        );

        employee.getAddresses().forEach(address -> address.setEmployee(employee));
        return employeeRepository.save(employee);

    }

    public void deleteEmployee(Long id) {
        employeeRepository.findById(id).orElseThrow(() -> {
            throw new EntityNotFoundException("Employee not found");
        });
        employeeRepository.deleteById(id);
    }

}
