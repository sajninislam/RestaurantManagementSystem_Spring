package com.example.Api.repository;
import com.example.Api.model.Bookcus;
import org.springframework.data.jpa.repository.JpaRepository;
public interface MyRepository extends JpaRepository<Bookcus,Long> {
}
