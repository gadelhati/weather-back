package com.observation.persistence.repository;

import com.observation.persistence.model.WeatherHistoric;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface RepositoryWeatherHistoricPage extends PagingAndSortingRepository<WeatherHistoric, UUID> {
    Page<WeatherHistoric> findByIdOrderByIdAsc(Pageable pageable, UUID id);
    Page<WeatherHistoric> findByNameContainingIgnoreCaseOrderByNameAsc(Pageable pageable, String name);
}