package com.observation.persistence.repository;

import com.observation.persistence.model.WeatherHistoricOnShore;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface RepositoryWeatherHistoricPageOnShore extends PagingAndSortingRepository<WeatherHistoricOnShore, UUID> {
    Page<WeatherHistoricOnShore> findByIdOrderByIdAsc(Pageable pageable, UUID id);
    Page<WeatherHistoricOnShore> findByNameContainingIgnoreCaseOrderByNameAsc(Pageable pageable, String name);
}