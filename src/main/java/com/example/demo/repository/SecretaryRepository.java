package com.example.demo.repository;

import com.example.demo.entity.Secretary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SecretaryRepository extends JpaRepository<Secretary, Long> {
    @Query("SELECT * FROM secretary WHERE status = 'ACTIVE'")
    List<Secretary> findAllAndActive();
}
