package com.example.demo.service;

import com.example.demo.entity.Secretary;
import com.example.demo.repository.SecretaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SecretaryService {
    private SecretaryRepository secretaryRepository;

    @Autowired
    public SecretaryService(SecretaryRepository secretaryRepository) {
        this.secretaryRepository = secretaryRepository;
    }

    public List<Secretary> findAll() {
        return secretaryRepository.findAll();
    }

    public Secretary findById(Long id) {
        return secretaryRepository.getReferenceById(id);
    }

    public void addSecretary(Secretary secretary) {
        secretaryRepository.save(secretary);
    }

    public void deleteSecretaryById(Long id) {
        secretaryRepository.deleteById(id);
    }

}
