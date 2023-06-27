package com.example.demo.repository;

import com.example.demo.entity.Secretary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SecretaryDao extends JpaRepository<Secretary, Long> {
    List<Secretary> findAll();
    Secretary getReferenceById(Long id);
//    Secretary save(Secretary secretary);
    void deleteById(Long id);
}
