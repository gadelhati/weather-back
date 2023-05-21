package com.observation.persistence.repository;

import com.observation.persistence.model.StationOffShore;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RepositoryStationOffShorePage extends PagingAndSortingRepository<StationOffShore, UUID> {
    Page<StationOffShore> findByIdOrderByIdAsc(Pageable pageable, UUID id);
    Page<StationOffShore> findByTelegraphicCallSignContainingIgnoreCaseOrderByTelegraphicCallSignAsc(Pageable pageable, String telegraphicCallSign);
}