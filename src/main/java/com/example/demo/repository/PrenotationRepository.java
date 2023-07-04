package com.example.demo.repository;


import com.example.demo.entity.Prenotation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrenotationRepository extends JpaRepository<Prenotation, Long> {

    List<Prenotation> findAll();
    Prenotation getReferenceById(Long id);
    void deleteById(Long id);
}
