package com.example.demo.repository;

import com.example.demo.entity.Address;
import com.example.demo.entity.Office;
import org.hibernate.annotations.SQLDelete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface AddressRepository extends JpaRepository<Address, Long> {

    /**
     * @param name address's name
     * @return the address
     */
    @Query("SELECT * FROM address a WHERE a.name = :name")
    Optional<Address> getReferenceByName(@Param("name") String name);

    /**
     * Delete the address according to its name
     *
     * @param name address' name
     */
    @SQLDelete(sql = "DELETE FROM address a WHERE a.name = :name")
    void deleteByName(@Param("name") String name);

    /**
     * Retrieves a reference to an address by its ID.
     *
     * @param id the ID of the address
     * @return a reference to the address by its ID
     */
    Address getReferenceById(Long id);
}
