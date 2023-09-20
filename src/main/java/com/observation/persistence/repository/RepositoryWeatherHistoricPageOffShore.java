package com.observation.persistence.repository;

import com.observation.persistence.model.WeatherHistoricOffShore;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface RepositoryWeatherHistoricPageOffShore extends PagingAndSortingRepository<WeatherHistoricOffShore, UUID> {
    Page<WeatherHistoricOffShore> findByIdOrderByIdAsc(Pageable pageable, UUID id);
    Page<WeatherHistoricOffShore> findByNameContainingIgnoreCaseOrderByNameAsc(Pageable pageable, String name);
}