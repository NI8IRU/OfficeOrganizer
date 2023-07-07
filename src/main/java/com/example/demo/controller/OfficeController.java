package com.example.demo.controller;


import com.example.demo.dto.office.GetOfficeDto;
import com.example.demo.entity.Address;
import com.example.demo.entity.Office;
import com.example.demo.exception.ResponseStatusNotFoundException;
import com.example.demo.service.OfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/office")
public class OfficeController {

    private final OfficeService officeService;

    @Autowired
    public OfficeController(OfficeService officeService) {
        this.officeService = officeService;

    }


    @GetMapping
    public List<GetOfficeDto> readAllOffices() {

        List<Office> officeList = officeService.findAllOffices();
        List<GetOfficeDto> officeDto = new ArrayList<>();


        for (Office office : officeList) {
            officeDto.add(new GetOfficeDto(office.getOfficeName(), office.getSecretary(),
                    office.getSpecialists(), office.getPhone(), office.getEmail(), office.getAddress(), office.getRating(), office.getStatus()));
        }

        return officeDto;

    }

    @GetMapping("/{id}")
    public GetOfficeDto getOfficeDtoById(@PathVariable Long id) throws ResponseStatusNotFoundException {

        return officeService.findById(id);
    }


    @PostMapping
    public ResponseEntity<?> createOfficeDto(@RequestBody GetOfficeDto getOfficeDto) {


        officeService.addOffice(getOfficeDto);
        return ResponseEntity.ok().body("Office added!");

    }


    @DeleteMapping("/logicalDelete/{name}")
    public ResponseEntity<?> logicalDeleteByOfficeName(@PathVariable String name) throws ResponseStatusNotFoundException {


        officeService.logicalDeleteOfficeByName(name);

        return ResponseEntity.ok().body("office deleted !");
    }


}
