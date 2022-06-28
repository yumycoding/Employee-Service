package com.yummyapps.employeeservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddressInput {

    private Long id;
    private String type;
    private String city;
    private String country;
    private String mobile;
    private String zip;

}
