package com.example.demo.service;

import com.example.demo.entity.Specialist;
import com.example.demo.repository.SpecialistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpecialistService {
    private SpecialistRepository specialistRepository;
    @Autowired
    public SpecialistService(SpecialistRepository specialistRepository){
        this.specialistRepository=specialistRepository;
    }
    public List<Specialist> findAll(){
        return specialistRepository.findAll();
    }
    public Specialist findById(Long id){
        return specialistRepository.getReferenceById(id);
    }
    public void addSpecialist(Specialist specialist){
         specialistRepository.save(specialist);
    }
    public void deleteSpecialistById(Long id){
        specialistRepository.deleteById(id);
    }
}
