package com.example.Api.repository;

import com.example.Api.model.bangladesh.Upazilas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UpazilasDao extends JpaRepository<Upazilas, Long> {

    @Query(value = "select id from districts;", nativeQuery = true)
    List<Upazilas> findAllDistrict();

    @Query(value = "select * from upazilas where district_id = :dis_id ;", nativeQuery = true)
    List<Upazilas> findAllByDistrict(@Param("dis_id") Long id);

}
