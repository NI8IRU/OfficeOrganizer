package com.example.demo.repository;

import com.example.demo.entity.Specialist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpecialistRepository extends JpaRepository<Specialist ,Long> {
    List<Specialist>findAll();
    Specialist getReferenceById(Long id);
    void deleteById (Long id);

}
