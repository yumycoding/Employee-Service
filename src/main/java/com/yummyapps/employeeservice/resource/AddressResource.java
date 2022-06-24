package com.yummyapps.employeeservice.resource;

import com.yummyapps.employeeservice.dao.AddressRepository;
import com.yummyapps.employeeservice.model.Address;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/addresses")
public class AddressResource {

    private final AddressRepository addressRepository;


    @GetMapping(path = "/{id}")
    public ResponseEntity<List<Address>> findAddressWithEmployeeId(@PathVariable(name = "id") Long id) {
        var addressList = addressRepository.findByEmployee_Id(id);
        if (addressList.size() == 0)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(addressList, HttpStatus.FOUND);
    }

}
