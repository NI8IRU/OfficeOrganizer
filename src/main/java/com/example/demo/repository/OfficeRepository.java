package com.example.demo.repository;

import com.example.demo.entity.Office;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OfficeRepository extends JpaRepository<Office, Long> {

    /**
     * @param officeName Office's officeName
     * @return the office according to its officeName
     */
//    @Query("SELECT * FROM office o WHERE officeName = :officeName")
   Optional <Office> getReferenceByofficeName(String officeName);

    /**
     * Delete the office according to its officeName
     *
     * @param officeName Office's officeName
     */
//    @Query("DELETE FROM office o WHERE officeName = :officeName")
    void deleteByofficeName(String officeName);

    /**
     * Retrieves a reference to an office by its ID.
     *
     * @param id the ID of the office
     * @return a reference to the office with the specified ID
     */
    Office getReferenceById(Long id);
}
