package com.example.demo.service;

import com.example.demo.dto.specialist.AddSpecialistDto;
import com.example.demo.dto.specialist.GetSpecialistDto;
import com.example.demo.entity.Specialist;
import com.example.demo.enums.StatusEnum;
import com.example.demo.exception.ResponseStatusNotFoundException;
import com.example.demo.repository.SpecialistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SpecialistService {
    private SpecialistRepository specialistRepository;
    @Autowired
    public SpecialistService(SpecialistRepository specialistRepository){
        this.specialistRepository=specialistRepository;

    }
    public List<GetSpecialistDto> findAll(){
        List<Specialist>specialistList=specialistRepository.findAll();
        List<GetSpecialistDto>specialistDtoList=new ArrayList<>();
        for(Specialist specialist:specialistList){
            specialistDtoList.add(new GetSpecialistDto(specialist.getSpecialistName(),specialist.getSpecialistType(),specialist.getRating()));
        }
        return specialistDtoList;
    }
    public GetSpecialistDto findById(Long id)throws ResponseStatusNotFoundException {
        Optional<Specialist> optionalSpecialist=specialistRepository.findById(id);
       if (optionalSpecialist.isPresent()){
           Specialist specialist=optionalSpecialist.get();
           GetSpecialistDto specialistDto= new GetSpecialistDto(specialist.getSpecialistName(),specialist.getSpecialistType(),specialist.getRating());
           if (specialist.getStatus()== StatusEnum.ACTIVE){
               return specialistDto;
           }else{
               throw new ResponseStatusNotFoundException("Specialist is not active!");
           }
       }else{
           throw new ResponseStatusNotFoundException("Specialist not found");
       }
    }
    public AddSpecialistDto addSpecialistDto (AddSpecialistDto specialistDto){
         Specialist specialist= new Specialist();
         specialist.setSpecialistName(specialistDto.getName());
         specialist.setSpecialistType(specialistDto.getType());
         specialist.setRating(specialistDto.getSpecialistRating());
         specialistRepository.save(specialist);
         specialistDto.setName(specialist.getSpecialistName());
         specialistDto.setType(specialist.getSpecialistType());
         specialistDto.setSpecialistRating(specialist.getRating());
         return specialistDto;

    }
    public AddSpecialistDto updateSpecialistDto(Long id,AddSpecialistDto specialistDto){
        Specialist specialist=new Specialist();
//        specialist.setOffice(id);
        specialist.setSpecialistName(specialistDto.getName());
        specialist.setSpecialistType(specialistDto.getType());
        specialist.setRating(specialistDto.getSpecialistRating());
        specialistRepository.save(specialist);
        specialistDto.setName(specialist.getSpecialistName());
        specialistDto.setType(specialist.getSpecialistType());
        specialistDto.setSpecialistRating(specialist.getRating());
        return specialistDto;
    }
    public GetSpecialistDto logicalDeleteSpecialistById(Long id) throws ResponseStatusNotFoundException{
        Optional<Specialist>optionalSpecialist=specialistRepository.findById(id);
        Specialist specialist;
        if (optionalSpecialist.isPresent()){
            specialist = optionalSpecialist.get();
        }else{
            throw new ResponseStatusNotFoundException("Specialist not found!");
        }
        specialist.setStatus(StatusEnum.DELETED);
        specialistRepository.save(specialist);
        return new GetSpecialistDto(specialist.getSpecialistName(),specialist.getSpecialistType(),specialist.getRating());
    }
}
