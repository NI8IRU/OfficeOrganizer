package com.example.demo.controller;

import com.example.demo.dto.prenotation.CreatePrenotationDto;
import com.example.demo.dto.prenotation.GetPrenotationDto;
import com.example.demo.exception.ResponseStatusNotFoundException;
import com.example.demo.service.PrenotationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prenotation")
public class PrenotationController {

    private PrenotationService prenotationService;

    @Autowired
    public PrenotationController(PrenotationService prenotationService) {
        this.prenotationService = prenotationService;
    }

    @GetMapping("/getAll")
    public List<GetPrenotationDto> readAllPrenotations(){
        return prenotationService.findAll();
    }

    @GetMapping("/{id}")
    public GetPrenotationDto getPrenotationById(@PathVariable Long id) throws ResponseStatusNotFoundException{
        return prenotationService.findById(id);
    }

    @PostMapping("/add")
    public CreatePrenotationDto addPrenotation(@RequestBody CreatePrenotationDto prenotationDto){
        return prenotationService.createPrenotationDto(prenotationDto);
    }

    @PutMapping("/{id}")
    public CreatePrenotationDto updatePrenotation(@PathVariable Long id, @RequestBody CreatePrenotationDto prenotationDto){
        return prenotationService.updatePrenotationDto(id, prenotationDto);
    }

    @DeleteMapping("/{id}")
    public GetPrenotationDto deletePrenotation(@PathVariable Long id) throws ResponseStatusNotFoundException{
        return prenotationService.deletePrenotationById(id);
    }
}
