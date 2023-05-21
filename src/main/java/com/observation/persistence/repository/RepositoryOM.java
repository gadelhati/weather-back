package com.observation.persistence.repository;

import com.observation.persistence.model.OM;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RepositoryOM extends JpaRepository<OM, UUID>, RepositoryInterface<OM> {

}