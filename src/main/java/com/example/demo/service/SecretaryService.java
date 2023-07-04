package com.example.demo.service;

import com.example.demo.dto.secretary.AddSecretaryDto;
import com.example.demo.dto.secretary.GetSecretaryDto;
import com.example.demo.entity.Secretary;
import com.example.demo.enums.StatusEnum;
import com.example.demo.exeption.ResponseStatusNotFoundException;
import com.example.demo.repository.SecretaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * The SecretaryService class provides methods to interact with Secretary entities.
 */
@Service
public class SecretaryService {
    private SecretaryRepository secretaryRepository;
    private OfficeService officeService;

    /**
     * Constructs a new SecretaryService with the specified SecretaryRepository.
     *
     * @param secretaryRepository the SecretaryRepository to be used
     */
    @Autowired
    public SecretaryService(SecretaryRepository secretaryRepository, OfficeService officeService) {
        this.secretaryRepository = secretaryRepository;
        this.officeService = officeService;
    }

    /**
     * Retrieves all Secretary entities.
     *
     * @return a list of all Secretary entities
     */
    public List<GetSecretaryDto> findAll() {
        List<Secretary> secretaryList = secretaryRepository.findAll();
        List<GetSecretaryDto> secretaryDtoList = new ArrayList<>();
        for (Secretary secretary : secretaryList) {
            secretaryDtoList.add(new GetSecretaryDto(secretary.getName(), secretary.getOffice().getOfficeName(),
                    secretary.getPhone(), secretary.getEmail()));
        }
        return secretaryDtoList;
    }

    /**
     * Retrieves a Secretary entity by its ID.
     *
     * @param id the ID of the Secretary entity to retrieve
     * @return the Secretary entity with the specified ID
     */
    public GetSecretaryDto findById(Long id) throws ResponseStatusNotFoundException {
        Optional<Secretary> optionalSecretary = secretaryRepository.findById(id);

        if (optionalSecretary.isPresent()) {
            Secretary secretary = optionalSecretary.get();
            GetSecretaryDto secretaryDto = new GetSecretaryDto(secretary.getName(), secretary.getOffice().getOfficeName(),
                                                               secretary.getPhone(), secretary.getEmail());
            if (secretary.getStatus() == StatusEnum.ACTIVE) {
                return secretaryDto;
            } else throw new ResponseStatusNotFoundException("Secretary is not active!");

        } else {
            throw new ResponseStatusNotFoundException("Secretary not found!");
        }

    }

    /**
     * Adds a new Secretary entity.
     *
     * @param secretary the Secretary entity to add
     */
    public AddSecretaryDto addSecretaryDto(AddSecretaryDto secretaryDto) throws ResponseStatusNotFoundException {

        Secretary secretary = new Secretary();
        secretary.setOffice(officeService.findById(secretaryDto.getOfficeId()));
        secretary.setName(secretaryDto.getName());
        secretary.setPhone(secretaryDto.getPhone());
        secretary.setEmail(secretaryDto.getEmail());
        secretaryRepository.save(secretary);
        secretaryDto.setOfficeId(secretary.getOffice().getId());
        secretaryDto.setName(secretary.getName());
        secretaryDto.setPhone(secretary.getPhone());
        secretaryDto.setEmail(secretary.getEmail());
        return secretaryDto;
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
