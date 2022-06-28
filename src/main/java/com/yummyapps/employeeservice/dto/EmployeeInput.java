package com.yummyapps.employeeservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeInput {

    private Long id;
    private String firstName;
    private String lastName;
    private String userName;
    private String email;
    private String department;
    private String role;
    private List<AddressInput> addresses;

}
