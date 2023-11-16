package com.observation.persistence.repository;

import com.observation.persistence.model.Station;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RepositoryStation extends JpaRepository<Station, UUID> {
    Page<Station> findByIdOrderByIdAsc(Pageable pageable, UUID id);
}