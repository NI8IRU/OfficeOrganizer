package com.example.demo.repository;

import com.example.demo.entity.Office;
import com.example.demo.entity.Secretary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OfficeRepository extends JpaRepository<Office, Long> {

    /**
     * @param id Office's id
     * @return the office according to its id
     */
    Office getReferenceById(Long id);

    /**
     * Delete the office according to its id
     *
     * @param id Office's id
     */
    void deleteById(Long id);

}
