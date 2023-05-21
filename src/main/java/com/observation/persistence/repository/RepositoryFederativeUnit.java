package com.observation.persistence.repository;

import com.observation.persistence.model.FederativeUnit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RepositoryFederativeUnit extends JpaRepository<FederativeUnit, UUID>, RepositoryInterface<FederativeUnit> {
    boolean existsByInitialsIgnoreCase(String value);
}