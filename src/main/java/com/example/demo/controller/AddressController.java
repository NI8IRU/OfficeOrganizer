package com.example.demo.controller;


import com.example.demo.dto.address.AddAddressDto;
import com.example.demo.dto.address.GetAddressDto;
import com.example.demo.entity.Address;
import com.example.demo.enums.StatusEnum;
import com.example.demo.exception.ResponseStatusNotFoundException;
import com.example.demo.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {


    private final AddressService addressService;

    @Autowired

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }


    @GetMapping
    public List<GetAddressDto> readAllAddress() {

        List<Address> addressList = addressService.gettingAllAddress();

        List<GetAddressDto> addressDtos = new ArrayList<>();


        for (Address address : addressList) {


            addressDtos.add(new GetAddressDto(address.getId(), address.getStreet(),
                    address.getPostalCode(), address.getCity(),
                    address.getAdditionalInformation(),
                    address.getStatus()));
        }

        return addressDtos;

    }

    @GetMapping("/{name}")
    public GetAddressDto readAddressByName(@PathVariable String name) throws ResponseStatusNotFoundException {

        return addressService.getAddressByStreetName(name);
    }

    @PostMapping("/addingAddress")
    public ResponseEntity<?> AddAddressDto(@RequestBody AddAddressDto getAddressDto) throws ResponseStatusNotFoundException {

        addressService.addAddress(getAddressDto);

        return ResponseEntity.ok().body("Address added");
    }


    @DeleteMapping("/physicalDelete/{id}")
    public ResponseEntity<?> physicalDeleteAddressById(@PathVariable Long id) {
        addressService.deleteAddressById(id);
        return ResponseEntity.ok().body("Address deleted");

    }


    @DeleteMapping("/logicalDelete/{id}")
    public ResponseEntity<?> logicalDeleteById(@PathVariable Long id) throws ResponseStatusNotFoundException {

        addressService.logicalDeleteById(id);

        return ResponseEntity.ok().body("Set address status to 'deleted'");
    }

}
