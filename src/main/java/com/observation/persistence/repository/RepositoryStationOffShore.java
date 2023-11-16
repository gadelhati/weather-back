package com.observation.persistence.repository;

import com.observation.persistence.model.StationOffShore;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RepositoryStationOffShore extends JpaRepository<StationOffShore, UUID> {

    boolean existsByTelegraphicCallSignIgnoreCaseAndIdNot(String telegraphicCallSign, UUID id);
    boolean existsByTelegraphicCallSignIgnoreCase(String value);
    Page<StationOffShore> findByIdOrderByIdAsc(Pageable pageable, UUID id);
    Page<StationOffShore> findByTelegraphicCallSignContainingIgnoreCaseOrderByTelegraphicCallSignAsc(Pageable pageable, String telegraphicCallSign);
}