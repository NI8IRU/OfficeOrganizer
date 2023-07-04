package com.example.demo.controller;

import com.example.demo.dto.secretary.AddSecretaryDto;
import com.example.demo.dto.secretary.GetSecretaryDto;
import com.example.demo.entity.Secretary;
import com.example.demo.exeption.ResponseStatusNotFoundException;
import com.example.demo.service.OfficeService;
import com.example.demo.service.SecretaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/secretary")
public class SecretaryController {
    private SecretaryService secretaryService;

    @Autowired
    public SecretaryController(SecretaryService secretaryService) {
        this.secretaryService = secretaryService;
    }

    @GetMapping
    public List<GetSecretaryDto> readAll() {
        return secretaryService.findAll();
    }

    @GetMapping("/{id}")
    public GetSecretaryDto getSecretaryDto(@PathVariable Long id) throws ResponseStatusNotFoundException {
        return secretaryService.findById(id);
    }

    @PostMapping
    public AddSecretaryDto addSecretaryDto(@RequestBody AddSecretaryDto secretaryDto) throws ResponseStatusNotFoundException {
        return secretaryService.addSecretaryDto(secretaryDto);

    }
}
