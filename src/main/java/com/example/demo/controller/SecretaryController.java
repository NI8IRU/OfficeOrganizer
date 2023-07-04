package com.example.demo.controller;

import com.example.demo.dto.secretary.AddSecretaryDto;
import com.example.demo.dto.secretary.GetSecretaryDto;
import com.example.demo.exception.ResponseStatusNotFoundException;
import com.example.demo.service.SecretaryService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public GetSecretaryDto getSecretary(@PathVariable Long id) throws ResponseStatusNotFoundException {
        return secretaryService.findById(id);
    }

    @PostMapping
    public AddSecretaryDto addSecretary(@RequestBody AddSecretaryDto secretaryDto) throws ResponseStatusNotFoundException {
        return secretaryService.addSecretaryDto(secretaryDto);

    }

    @PostMapping("/{id}")
    public AddSecretaryDto updateSecretary(@PathVariable Long id, @RequestBody AddSecretaryDto secretaryDto) {
        return secretaryService.updateSecretaryDto(id, secretaryDto);
    }

    @DeleteMapping("/{id}")
    public GetSecretaryDto logicalDeleteSecretary(@PathVariable Long id) throws ResponseStatusNotFoundException {
        return secretaryService.logicalDeleteSecretaryById(id);
    }
}
