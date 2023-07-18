package com.example.demo.service;


import com.example.demo.dto.address.AddAddressDto;
import com.example.demo.dto.office.AddOfficeDto;
import com.example.demo.dto.office.GetOfficeDto;
import com.example.demo.entity.Address;
import com.example.demo.entity.Office;
import com.example.demo.entity.Secretary;
import com.example.demo.enums.StatusEnum;
import com.example.demo.exception.ResponseStatusNotFoundException;
import com.example.demo.repository.OfficeRepository;


import com.example.demo.repository.SecretaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OfficeService {


    private final OfficeRepository officeRepository;
    private final SecretaryRepository secretaryRepository;

    /**
     * @param officeRepository OfficeRepo's instance
     */
    @Autowired
    public OfficeService(OfficeRepository officeRepository, SecretaryRepository secretaryRepository) {
        this.officeRepository = officeRepository;
        this.secretaryRepository = secretaryRepository;
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
     * @param officeDto office
     */
    public void addOffice(GetOfficeDto officeDto) {

        if (officeDto != null) {


            Office office = new Office();
            Secretary secretary = officeDto.getSecretary();

            office.setOfficeName(officeDto.getOfficeName());
            office.setSpecialists(officeDto.getSpecialists());
            office.setSecretary(secretary);
            office.setRating(officeDto.getRating());
            office.setPhone(officeDto.getPhone());
            office.setEmail(officeDto.getEmail());
            office.setAddress(officeDto.getAddress());
            office.setStatus(officeDto.getStatus());
            secretary.setOffice(office);

            officeRepository.save(office);
            secretaryRepository.save(secretary);


        } else throw new NullPointerException("This office is empty!");

    }


    public AddOfficeDto updateOffice(Long id, AddOfficeDto officeDto) throws ResponseStatusNotFoundException {


        Optional<Office> optionalOffice = officeRepository.findById(id);

        if (optionalOffice.isPresent()) {

            Office office = new Office();
            Secretary secretary = office.getSecretary();

            office.setOfficeName(officeDto.getOfficeName());
            office.setEmail(officeDto.getEmail());
            office.setPhone(officeDto.getPhone());
            office.setAddress(officeDto.getAddress());
            office.setSpecialists(officeDto.getSpecialists());
            office.setSecretary(secretary);
            office.setRating(officeDto.getRating());
            office.setStatus(officeDto.getStatus());


            officeRepository.save(office);
            secretaryRepository.save(secretary);


            officeDto.setOfficeName(office.getOfficeName());
            officeDto.setEmail(office.getEmail());
            officeDto.setPhone(office.getPhone());
            officeDto.setAddress(office.getAddress());
            officeDto.setSpecialists(office.getSpecialists());
            officeDto.setSecretary(office.getSecretary());
            officeDto.setRating(office.getRating());
            officeDto.setStatus(office.getStatus());


            return officeDto;
        } else {
            throw new ResponseStatusNotFoundException("Office not found!");


        }


    }


    /**
     * This method delete logically the office, not physically, according to its id;
     * perhaps the office it's still in the database but its status is
     * "deleted"
     *
     * @param id office's ide
     * @return a new GetOfficeDto with datas updated
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
     * @return a new GetOfficeDto with datas updated
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