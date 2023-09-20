package com.observation.persistence.repository;

import com.observation.persistence.model.Weather;
import com.observation.persistence.model.WeatherId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface RepositoryWeatherPage extends PagingAndSortingRepository<Weather, WeatherId> {
    Page<Weather> findByIdOrderByIdAsc(Pageable pageable, WeatherId id);
    Page<Weather> findByNameContainingIgnoreCaseOrderByNameAsc(Pageable pageable, String name);
}