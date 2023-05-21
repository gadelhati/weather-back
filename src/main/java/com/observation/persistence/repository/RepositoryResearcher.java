package com.observation.persistence.repository;

import com.observation.persistence.model.Researcher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RepositoryResearcher extends JpaRepository<Researcher, UUID>, RepositoryInterface<Researcher> {
    boolean existsByEmail(String value);
    boolean existsByEmailIgnoreCase(String value);
    boolean existsByEmailIgnoreCaseAndIdNot(String name, UUID id);
}