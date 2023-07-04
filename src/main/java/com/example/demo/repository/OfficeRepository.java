package com.example.demo.repository;

import com.example.demo.entity.Office;
import org.hibernate.annotations.SQLDelete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OfficeRepository extends JpaRepository<Office, Long> {

    /**
     * @param name Office's name
     * @return the office according to its name
     */
    @Query("SELECT * FROM office o WHERE o.name = :name")
   Optional <Office> getReferenceByName(@Param("name") String name);

    /**
     * Delete the office according to its id
     *
     * @param name Office's name
     */
    @SQLDelete(sql = "DELETE FROM office o WHERE o.name = :name")
    void deleteByName(@Param("name") String name);

}
