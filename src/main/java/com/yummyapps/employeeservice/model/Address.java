package com.yummyapps.employeeservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import static com.fasterxml.jackson.annotation.JsonProperty.Access.WRITE_ONLY;

@Getter
@Setter
@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String type;
    private String city;
    private String country;
    private String mobile;
    private String zip;


    @JsonProperty(access = WRITE_ONLY)
    @ManyToOne(fetch = FetchType.LAZY)
    private Employee employee;
}
