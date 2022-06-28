package com.yummyapps.employeeservice.service;

import com.yummyapps.employeeservice.dao.EmployeeRepository;
import com.yummyapps.employeeservice.dto.EmployeeInput;
import com.yummyapps.employeeservice.model.Employee;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
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

    public Employee findEmployeeByEmail(String email) {
        return employeeRepository.findByEmail(email).orElseThrow(() ->
                new EntityNotFoundException("email not found"));
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

    public Employee createEmployee(EmployeeInput employeeInput) {
        ModelMapper modelMapper = new ModelMapper();
        Employee employee;
//        BeanUtils.copyProperties(employeeInput, employee);
        employee = modelMapper.map(employeeInput, Employee.class);

        employeeRepository.findByEmail(employee.getEmail()).ifPresent(
                (email) -> {
                    throw new EntityExistsException(email.getEmail() + " already exist , please use other email ");
                }
        );
        employee.getAddresses().forEach(address -> address.setEmployee(employee));
        return employeeRepository.save(employee);
    }


    public Employee updateEmployee(EmployeeInput employeeInput) {
        return null;
    }

    public void deleteEmployee(Long id) {
        employeeRepository.findById(id).orElseThrow(() -> {
            throw new EntityNotFoundException("Employee not found");
        });
        employeeRepository.deleteById(id);
    }

}


//    List<ActiveUserList> activeUserListDTOs =
//            userEntities.stream().map(ActiveUserList::new).collect(Collectors.toList());