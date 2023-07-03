package com.example.demo.service;


import com.example.demo.entity.Office;
import com.example.demo.entity.Secretary;
import com.example.demo.enums.StatusEnum;
import com.example.demo.exeption.ResponseStatusNotFoundException;
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

    public Office findById(Long id) throws ResponseStatusNotFoundException {
        Optional<Office> optionalOffice = officeRepository.findById(id);
        Office office;

        if (optionalOffice.isPresent()) {
            office = optionalOffice.get();
        } else {
            throw new ResponseStatusNotFoundException("Office not found!");
        }

        if (office.getStatus() == StatusEnum.ACTIVE) {
            return office;
        } else throw new ResponseStatusNotFoundException("Office is not active!");
    }

    /**
     * To add new offices
     *
     * @param office office
     */
    public void addOffice(Office office) {

        if (office != null) {

            officeRepository.save(office);
        }
    }

    /**
     * Delete the office according to its name
     *
     * @param name Office's name
     */
    public void deleteOfficeByName(String name) {

        if (officeRepository.getReferenceByName(name).isPresent()) {

            officeRepository.deleteByName(name);
        }

    }

    /**
     * @param name Office's name
     * @return the office according to its name
     */

    public Optional<Office> getOfficeByName(String name) {

        Optional<Office> optionalOffice = officeRepository.getReferenceByName(name);

        Office office2 = new Office();


        if (optionalOffice.isPresent()) {

            Office office = optionalOffice.get();
            office2.setOfficeName(office.getOfficeName());
            office2.setAddress(office.getAddress());
            office2.setEmail(office.getEmail());
            office2.setPhone(office.getPhone());
            office2.setId(office.getId());
            office2.setRating(office.getRating());
            office2.setSecretary(office.getSecretary());
            office2.setSpecialists(office.getSpecialists());

            return officeRepository.getReferenceByName(name);

        } else {
            throw new NullPointerException("Something went wrong!");

        }
    }
}
