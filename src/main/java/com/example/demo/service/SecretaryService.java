package com.example.demo.service;

import com.example.demo.entity.Secretary;
import com.example.demo.enums.StatusEnum;
import com.example.demo.exeption.ResponseStatusNotFoundException;
import com.example.demo.repository.SecretaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * The SecretaryService class provides methods to interact with Secretary entities.
 */
@Service
public class SecretaryService {
    private SecretaryRepository secretaryRepository;

    /**
     * Constructs a new SecretaryService with the specified SecretaryRepository.
     *
     * @param secretaryRepository the SecretaryRepository to be used
     */
    @Autowired
    public SecretaryService(SecretaryRepository secretaryRepository) {
        this.secretaryRepository = secretaryRepository;
    }

    /**
     * Retrieves all Secretary entities.
     *
     * @return a list of all Secretary entities
     */
    public List<Secretary> findAll() {
        return secretaryRepository.findAllAndActive();
    }

    /**
     * Retrieves a Secretary entity by its ID.
     *
     * @param id the ID of the Secretary entity to retrieve
     * @return the Secretary entity with the specified ID
     */
    public Secretary findById(Long id) throws ResponseStatusNotFoundException {
        Optional<Secretary> optionalSecretary = secretaryRepository.findById(id);
        Secretary secretary;

        if (optionalSecretary.isPresent()) {
            secretary = optionalSecretary.get();
        } else {
            throw new ResponseStatusNotFoundException("Secretary not found!");
        }

        if (secretary.getStatus() == StatusEnum.ACTIVE) {
            return secretary;
        } else throw new ResponseStatusNotFoundException("Secretary is not active!");
    }

    /**
     * Adds a new Secretary entity.
     *
     * @param secretary the Secretary entity to add
     */
    public void addSecretary(Secretary secretary) {
        secretaryRepository.save(secretary);
    }

    /**
     * Performs a logical deletion of a Secretary entity by its ID.
     *
     * @param id the ID of the Secretary entity to delete
     * @throws ResponseStatusNotFoundException if the Secretary entity with the specified ID is not found
     */
    public void logicalDeleteSecretaryById(Long id) throws ResponseStatusNotFoundException {
        Optional<Secretary> optionalSecretary = secretaryRepository.findById(id);
        Secretary secretary;

        if (optionalSecretary.isPresent()) {
            secretary = optionalSecretary.get();
        } else {
            throw new ResponseStatusNotFoundException("Secretary not found!");
        }

        secretary.setStatus(StatusEnum.DELETED);
        secretaryRepository.save(secretary);
    }
}
