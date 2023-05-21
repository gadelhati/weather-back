package com.observation.persistence.repository;

import com.observation.persistence.model.Commission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RepositoryCommission extends JpaRepository<Commission, UUID>, RepositoryInterface<Commission> {

}