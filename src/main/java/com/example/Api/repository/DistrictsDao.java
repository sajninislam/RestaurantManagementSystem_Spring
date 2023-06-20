package com.example.Api.repository;

import com.example.Api.model.bangladesh.Districts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DistrictsDao extends JpaRepository<Districts, Long> {

    @Query(value = "select * from districts where id = :dis_id ;", nativeQuery = true)
    List<Districts> findAllByDistrict(@Param("dis_id") Long id);
}
