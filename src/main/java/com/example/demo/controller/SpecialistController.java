package com.example.demo.controller;

import com.example.demo.dto.specialist.AddSpecialistDto;
import com.example.demo.dto.specialist.GetSpecialistDto;
import com.example.demo.exception.ResponseStatusNotFoundException;
import com.example.demo.service.SpecialistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
    @RestController
    @RequestMapping("/specialist")
    public class SpecialistController {
        private SpecialistService specialistService;
        @Autowired
        public SpecialistController(SpecialistService specialistService){
            this.specialistService=specialistService;
        }
        @PostMapping("/add")
        public AddSpecialistDto addSpecialist(@RequestBody AddSpecialistDto specialistDto)throws ResponseStatusNotFoundException {
            return specialistService.addSpecialistDto(specialistDto);
        }
        @GetMapping("/specialists")
        public List<GetSpecialistDto> readAll(){
            return specialistService.findAll();
        }
        @GetMapping("/{id}")
        public GetSpecialistDto getSpecialist(@PathVariable Long id)throws ResponseStatusNotFoundException{
            return specialistService.findById(id);
        }
        @PutMapping("/{id}")
        public AddSpecialistDto updateSpecialist(@PathVariable Long id,@RequestBody AddSpecialistDto specialistDto){
            return specialistService.updateSpecialistDto(id,specialistDto);
        }
        @DeleteMapping("/{id}")
        public GetSpecialistDto logicalDeleteSpecialist(@PathVariable Long id)throws ResponseStatusNotFoundException{
            return specialistService.logicalDeleteSpecialistById(id);
        }

    }



