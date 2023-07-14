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

        Office officeRepositoryReferenceByOfficeName = officeRepository.getReferenceByOfficeName(name);


        Optional<Office> optionalOffice = Optional.ofNullable(officeRepositoryReferenceByOfficeName);

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
     * This method delete logically the office, not physically, according to its id;
     * perhaps the office it's still in the database but its status is
     * "deleted"
     *
     * @param id office's ide
     * @return a new GetOfficeDto with datas updtated
     * @throws ResponseStatusNotFoundException if the office isn't found
     */
    public GetOfficeDto logicalDeleteOfficeById(Long id) throws ResponseStatusNotFoundException {
        Optional<Office> optionalOffice = officeRepository.findById(id);
        Office office1;

        if (optionalOffice.isPresent()) {
            office1 = optionalOffice.get();
        } else {
            throw new ResponseStatusNotFoundException("Secretary not found!");
        }

        office1.setStatus(StatusEnum.DELETED);
        officeRepository.save(office1);
        return new GetOfficeDto(office1.getOfficeName(), office1.getSecretary(), office1.getSpecialists(), office1.getPhone(),
                office1.getEmail(), office1.getAddress(), office1.getRating(), office1.getStatus());
    }


    /**
     * This method delete logically the office , not physically, according to its id;
     * perhaps the office it's still in the database but its status is
     * "deleted"
     *
     * @param name office's name
     * @return a new GetOfficeDto with datas updtated
     * @throws ResponseStatusNotFoundException if the office isn't found
     */
    public GetOfficeDto logicalDeleteOfficeByName(String name) throws ResponseStatusNotFoundException {


        Office officeRepositoryReferenceByOfficeName = officeRepository.getReferenceByOfficeName(name);


        Optional<Office> optionalOffice = Optional.ofNullable(officeRepositoryReferenceByOfficeName);

        Office office1;

        if (optionalOffice.isPresent()) {

            office1 = optionalOffice.get();
        } else {
            throw new ResponseStatusNotFoundException("Office not found !");
        }

        office1.setStatus(StatusEnum.DELETED);
        officeRepository.save(office1);
        return new GetOfficeDto(office1.getOfficeName(), office1.getSecretary(), office1.getSpecialists(), office1.getPhone(),
                office1.getEmail(), office1.getAddress(), office1.getRating(), office1.getStatus());
    }

    /**
     * Delete physically the office according to its name
     *
     * @param name Office's name
     */
    public void physicalDeleteOfficeByName(String name) {


        Office officeRepositoryReferenceByOfficeName = officeRepository.getReferenceByOfficeName(name);


        Optional<Office> optionalOffice = Optional.ofNullable(officeRepositoryReferenceByOfficeName);
        if (optionalOffice.isPresent()) {

            officeRepository.deleteByOfficeName(name);
        } else {

            throw new NullPointerException("The name seems to be null!");
        }

    }

    /**
     * This method delete physically the office
     * according to its id !
     *
     * @param id office's id
     * @throws NullPointerException if the id it's null!
     */

    public void physicalDeleteOfficeById(Long id) {


        Optional<Office> optionalOffice = officeRepository.findById(id);
        if (optionalOffice.isPresent()) {

            officeRepository.deleteById(id);
        } else {

            throw new NullPointerException("The id seems to be null!");
        }

    }


}