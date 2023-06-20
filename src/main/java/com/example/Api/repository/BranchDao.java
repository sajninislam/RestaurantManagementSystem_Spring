package com.example.Api.repository;

import com.example.Api.model.BranchModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BranchDao extends JpaRepository<BranchModel,Long> {
}
