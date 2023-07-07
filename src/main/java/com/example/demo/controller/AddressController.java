package com.example.demo.controller;


import com.example.demo.dto.address.AddAddressDto;
import com.example.demo.dto.address.GetAddressDto;
import com.example.demo.exception.ResponseStatusNotFoundException;
import com.example.demo.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/address")
public class AddressController {


    private final AddressService addressService;

    @Autowired

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }


    @GetMapping
    public GetAddressDto readAddressByName(@RequestParam String name) throws ResponseStatusNotFoundException {

        return addressService.getAddressByname(name);
    }

    @PostMapping
    public ResponseEntity<?> AddAddressDto(@RequestBody AddAddressDto getAddressDto) throws ResponseStatusNotFoundException {

        addressService.addAddress(getAddressDto);

        return ResponseEntity.ok().body("Address added");
    }


    @DeleteMapping("/logicalDelete")
    public ResponseEntity<?> logicalDeleteAddressByName(String name) {
        addressService.deleteAddressByName(name);
        return ResponseEntity.ok().body("Address deleted");

    }

}
