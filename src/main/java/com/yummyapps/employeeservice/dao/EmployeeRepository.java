package com.yummyapps.employeeservice.dao;

import com.yummyapps.employeeservice.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query("select e from Employee e where e.firstName = ?1 or e.lastName = ?1")
    Optional<Employee> findByFirstNameOrLastName(@NonNull String name);

    Optional<Employee> findByEmail(@NonNull String email);


}
