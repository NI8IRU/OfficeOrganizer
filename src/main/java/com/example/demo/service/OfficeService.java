package com.example.demo.service;


import com.example.demo.dto.office.GetOfficeDto;
import com.example.demo.entity.Office;
import com.example.demo.enums.StatusEnum;
import com.example.demo.exception.ResponseStatusNotFoundException;
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
     * @param name Office's name
     * @return the office according to its name
     */

    public GetOfficeDto getOfficeByName(String name) {

        Optional<Office> optionalOffice = officeRepository.getReferenceByName(name);


        if (optionalOffice.isPresent()) {

            Office office = optionalOffice.get();

            GetOfficeDto office2 = new GetOfficeDto();


            office2.setOfficeName(office.getOfficeName());
            office2.setAddress(office.getAddress());
            office2.setEmail(office.getEmail());
            office2.setPhone(office.getPhone());
            office2.setRating(office.getRating());
            office2.setSecretary(office.getSecretary());
            office2.setSpecialists(office.getSpecialists());

            return office2;

        } else {
            throw new NullPointerException("Something went wrong!");

        }
    }

    /**
     * @return all the offices
     */
    public List<Office> findAllOffices() {

        return officeRepository.findAll();
    }

    public GetOfficeDto findById(Long id) throws ResponseStatusNotFoundException {
        Optional<Office> optionalOffice = officeRepository.findById(id);

        GetOfficeDto getOfficeDto = new GetOfficeDto();
        Office office;

        if (optionalOffice.isPresent()) {
            office = optionalOffice.get();

            getOfficeDto.setId(office.getId());
            getOfficeDto.setOfficeName(office.getOfficeName());
            getOfficeDto.setAddress(office.getAddress());
            getOfficeDto.setSecretary(office.getSecretary());
            getOfficeDto.setSpecialists(office.getSpecialists());
            getOfficeDto.setEmail(office.getEmail());
            getOfficeDto.setPhone(office.getPhone());
            getOfficeDto.setRating(office.getRating());
            getOfficeDto.setStatus(office.getStatus());


        } else {
            throw new ResponseStatusNotFoundException("Office not found!");
        }

        if (getOfficeDto.getStatus() == StatusEnum.ACTIVE) {
            return getOfficeDto;
        } else throw new ResponseStatusNotFoundException("Office is not active!");
    }

    /**
     * To add new offices
     *
     * @param office office
     */
    public void addOffice(GetOfficeDto office) {

        if (office != null) {


            Office office1 = new Office();

            office1.setOfficeName(office.getOfficeName());
            office1.setSpecialists(office.getSpecialists());
            office1.setSecretary(office.getSecretary());
            office1.setRating(office.getRating());
            office1.setPhone(office.getPhone());
            office1.setEmail(office.getEmail());
            office1.setAddress(office.getAddress());
            office1.setStatus(office.getStatus());

            officeRepository.save(office1);


        } else throw new NullPointerException("This office is empty!");

    }

    /**
     * Delete the office according to its name
     *
     * @param name Office's name
     */
    public void deleteOfficeByName(String name) {


         Optional<Office> optionalOffice = officeRepository.getReferenceByName(name);
        if (optionalOffice.isPresent()) {

            officeRepository.deleteByName(name);
        }else{

            throw new NullPointerException("The name seems to be null!");
        }

    }

}