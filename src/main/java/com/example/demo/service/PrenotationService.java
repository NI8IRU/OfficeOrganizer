package com.example.demo.service;

import com.example.demo.dto.prenotation.CreatePrenotationDto;
import com.example.demo.dto.prenotation.GetPrenotationDto;
import com.example.demo.entity.Prenotation;
import com.example.demo.exception.ResponseStatusNotFoundException;
import com.example.demo.repository.OfficeRepository;
import com.example.demo.repository.PrenotationRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PrenotationService {

    private PrenotationRepository prenotationRepository;
    private UserRepository userRepository;
    @Autowired
    public PrenotationService(PrenotationRepository prenotationRepository, UserRepository userRepository) {
        this.prenotationRepository = prenotationRepository;
        this.userRepository = userRepository;
    }

    public List<GetPrenotationDto> findAll() {

        List<Prenotation> prenotationList = prenotationRepository.findAll();
        List<GetPrenotationDto> prenotationDtoList = new ArrayList<>();

        for(Prenotation prenotation : prenotationList){
            prenotationDtoList.add(new GetPrenotationDto(prenotation.getSpecialist_id(),
                    prenotation.getUser_id(), prenotation.getDescription(), prenotation.getDate()));
        }

        return prenotationDtoList;
    }

    public GetPrenotationDto findById(Long id) throws ResponseStatusNotFoundException {

        Optional<Prenotation> optionalPrenotation = prenotationRepository.findById(id);

        if(optionalPrenotation.isPresent()){
            Prenotation prenotation = optionalPrenotation.get();
            GetPrenotationDto prenotationDto = new GetPrenotationDto(prenotation.getSpecialist_id(), prenotation.getUser_id(),
                    prenotation.getDescription(), prenotation.getDate());
            return prenotationDto;
        } else {
            throw new ResponseStatusNotFoundException("Prenotation not found");
        }
    }

    public CreatePrenotationDto createPrenotationDto(CreatePrenotationDto prenotationDto) {

        Prenotation prenotation = new Prenotation();

        prenotation.setId(prenotationDto.getId());
        prenotation.setSpecialist_id(prenotationDto.getSpecialist_id());
        prenotation.setUser_id(userRepository.getReferenceById(prenotationDto.getId()));
        prenotation.setDescription(prenotationDto.getDescription());
        prenotation.setDate(prenotationDto.getDate());
        prenotationRepository.save(prenotation);

        prenotationDto.setId(prenotation.getId());
        prenotationDto.setSpecialist_id(prenotation.getSpecialist_id());
        prenotationDto.setUser_id(prenotation.getUser_id());
        prenotationDto.setDescription(prenotation.getDescription());
        prenotationDto.setDate(prenotation.getDate());

        return prenotationDto;
    }

    public CreatePrenotationDto updatePrenotationDto(Long id, CreatePrenotationDto prenotationDto){

        Prenotation prenotation = new Prenotation();

        prenotation.setId(id);
        prenotation.setSpecialist_id(prenotationDto.getSpecialist_id());
        prenotation.setUser_id(userRepository.getReferenceById(prenotationDto.getId()));
        prenotation.setDescription(prenotationDto.getDescription());
        prenotation.setDate(prenotationDto.getDate());
        prenotationRepository.save(prenotation);

        prenotationDto.setId(prenotation.getId());
        prenotationDto.setSpecialist_id(prenotation.getSpecialist_id());
        prenotationDto.setUser_id(prenotation.getUser_id());
        prenotationDto.setDescription(prenotation.getDescription());
        prenotationDto.setDate(prenotation.getDate());

        return prenotationDto;

    }

    public void deletePrenotationById(Long id) {
        prenotationRepository.deleteById(id);
    }
}
