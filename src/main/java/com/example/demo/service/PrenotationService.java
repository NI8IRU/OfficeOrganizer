package com.example.demo.service;

import com.example.demo.entity.Prenotation;
import com.example.demo.repository.PrenotationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrenotationService {

    private PrenotationRepository prenotationRepository;
    @Autowired
    public PrenotationService(PrenotationRepository prenotationRepository) {
        this.prenotationRepository = prenotationRepository;
    }

    public List<Prenotation> findAll() {
        return prenotationRepository.findAll();
    }

    public Prenotation findById(Long id) {
        return prenotationRepository.getReferenceById(id);
    }

    public void addPrenotation(Prenotation secretary) {
        prenotationRepository.save(secretary);
    }

    public void deletePrenotationById(Long id) {
        prenotationRepository.deleteById(id);
    }
}
