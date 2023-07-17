package com.example.demo.repository;

import com.example.demo.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface AddressRepository extends JpaRepository<Address, Long> {

    /**
     * @param street address's street
     * @return the address
     */
    @Query("SELECT a FROM Address a WHERE a.street = :street")
  Optional <Address> getReferenceByStreet(@Param("street") String street);


    /**
     * Retrieves a reference to an address by its ID.
     *
     * @param id the ID of the address
     * @return a reference to the address by its ID
     */
    Address getReferenceById(Long id);
}
