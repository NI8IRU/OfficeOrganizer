package com.example.demo.repository;

import com.example.demo.entity.Office;
import jakarta.persistence.Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OfficeRepository extends JpaRepository<Office, Long> {

    /**
     * @param officeName Office's officeName
     * @return the office according to its officeName
     */

    @Query(value = "SELECT o FROM Office o WHERE o.officeName = :officeName")
   Office getReferenceByOfficeName(@Param("officeName") String officeName);

    /**
     * Delete the office according to its officeName
     *
     * @param officeName Office's officeName
     */

    @Query("DELETE FROM Office o WHERE o.officeName = :officeName")
    void deleteByOfficeName(@Param("officeName") String officeName);


}
