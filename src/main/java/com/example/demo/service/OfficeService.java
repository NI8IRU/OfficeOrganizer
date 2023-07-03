package com.example.demo.service;


import com.example.demo.entity.Office;
import com.example.demo.repository.OfficeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OfficeService {


    private final OfficeRepository officeRepository;

    /**
     * @param officeRepository OfficeRepo's instance
     */
    @Autowired

    public OfficeService(OfficeRepository officeRepository) {
        this.officeRepository = officeRepository;
    }


    /**
     * @return all the offices
     */
    public List<Office> findAllOffices() {

        return officeRepository.findAll();
    }

    /**
     * To add new offices
     *
     * @param office office
     */
    public void addOffice(Office office) {

        if (office != null){

            officeRepository.save(office);
        }
    }

    /**
     * Delete the office according to its name
     *
     * @param name Office's name
     */
    public void  deleteOfficeByName(String name) {

        if(officeRepository.getReferenceByName(name).isPresent()){

            officeRepository.deleteByName(name);
        }

    }

    /**
     * @param name Office's name
     * @return the office according to its name
     */

    public Optional<Office> getOfficeByName(String name) {

        if(officeRepository.getReferenceByName(name).isPresent()){
            return officeRepository.getReferenceByName(name);

        } else{
           throw new NullPointerException("Something went wrong!");

        }
    }
}
