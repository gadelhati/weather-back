package com.observation.persistence.repository;

import com.observation.persistence.model.Platform;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RepositoryPlatform extends JpaRepository<Platform, UUID>, RepositoryInterface<Platform> {
    boolean existsByTelegraphicCallsignIgnoreCase(String value);
    boolean existsByTelegraphicCallsignIgnoreCaseAndIdNot(String telegraphicCallsign, UUID id);
}