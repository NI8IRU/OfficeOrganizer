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

    @GetMapping("/get_office_prenotations/{officeId}")
    public List<GetPrenotationDto> getOfficePrenotations(@PathVariable Long officeId) {
        return prenotationService.getAllPrenotationOfOffice(officeId);
    }

    @GetMapping("/get_specialist_prenotations/{specialistId}")
    public List<GetPrenotationDto> getAllPrenotationOfSpecialist(@PathVariable Long specialistId) {
        return prenotationService.getAllPrenotationOfSpecialist(specialistId);
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
