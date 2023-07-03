package com.example.demo.controller;

import com.example.demo.dto.secretary.CreateSecretaryDto;
import com.example.demo.dto.secretary.GetSecretaryDto;
import com.example.demo.entity.Secretary;
import com.example.demo.exeption.ResponseStatusNotFoundException;
import com.example.demo.service.OfficeService;
import com.example.demo.service.SecretaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/secretary")
public class SecretaryController {
    private SecretaryService secretaryService;
    private OfficeService officeService;

    @Autowired
    public SecretaryController(SecretaryService secretaryService, OfficeService officeService) {
        this.secretaryService = secretaryService;
        this.officeService = officeService;
    }

    @GetMapping
    public List<GetSecretaryDto> readAll() {
        List<Secretary> secretaryList = secretaryService.findAll();
        List<GetSecretaryDto> secretaryDtoList = new ArrayList<>();
        for (Secretary secretary : secretaryList) {
            secretaryDtoList.add(new GetSecretaryDto(secretary.getName(), secretary.getOffice().getOfficeName(),
                    secretary.getPhone(), secretary.getEmail()));
        }
        return secretaryDtoList;
    }

    @GetMapping("/{id}")
    public GetSecretaryDto getSecretaryDto(@PathVariable Long id) throws ResponseStatusNotFoundException {
            Secretary secretary = secretaryService.findById(id);
        return new GetSecretaryDto(secretary.getName(), secretary.getOffice().getOfficeName(),
                                   secretary.getPhone(), secretary.getEmail());
    }

    @PostMapping
    public ResponseEntity<?> createSecretaryDto(@RequestBody CreateSecretaryDto secretaryDto) throws ResponseStatusNotFoundException {
        Secretary secretary = new Secretary();
        secretary.setOffice(officeService.findById(secretaryDto.getOfficeId()));
        secretary.setName(secretaryDto.getName());
        secretary.setPhone(secretaryDto.getPhone());
        secretary.setEmail(secretaryDto.getEmail());
        secretaryService.addSecretary(secretary);
        return ResponseEntity.ok().body("Secretary added!");
    }
}
