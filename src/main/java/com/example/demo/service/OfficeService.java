package com.example.demo.service;


import com.example.demo.entity.Office;
import com.example.demo.repository.OfficeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

        officeRepository.save(office);
    }

    /**
     * Delete the office according to its id
     *
     * @param id Office's id
     */
    public void deleteOfficeById(Long id) {

        officeRepository.deleteById(id);

    }

    /**
     *
     * @param id Office's id
     * @return the office according to its id
     */

    public Office getOfficeById(Long id) {

        return officeRepository.getReferenceById(id);
    }
}
