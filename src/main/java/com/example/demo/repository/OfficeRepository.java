package com.example.demo.repository;

import com.example.demo.entity.Office;
import com.example.demo.entity.Secretary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OfficeRepository extends JpaRepository<Office, Long> {

    /**
     * @param name Office's name
     * @return the office according to its name
     */
   Optional <Office> getReferenceByName(String name);

    /**
     * Delete the office according to its id
     *
     * @param name Office's name
     */
    void deleteByName(String name);

}
