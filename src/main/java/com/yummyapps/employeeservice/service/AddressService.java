package com.yummyapps.employeeservice.service;

import com.yummyapps.employeeservice.dao.AddressRepository;
import com.yummyapps.employeeservice.model.Address;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressService {

    private final AddressRepository addressRepository;


    List<Address> findAddressWithEmployeeId(Long EmpId) {
        return addressRepository.findByEmployee_Id(EmpId);
    }

}
