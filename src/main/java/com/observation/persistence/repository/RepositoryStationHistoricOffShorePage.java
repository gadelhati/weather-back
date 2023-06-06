package com.observation.persistence.repository;

import com.observation.persistence.model.StationHistoricOffShore;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RepositoryStationHistoricOffShorePage extends PagingAndSortingRepository<StationHistoricOffShore, UUID> {

    Page<StationHistoricOffShore> findByIdOrderByIdAsc(Pageable pageable, UUID id);
    Page<StationHistoricOffShore> findByTelegraphicCallSignContainingIgnoreCaseOrderByTelegraphicCallSignAsc(Pageable pageable, String telegraphicCallSign);
}