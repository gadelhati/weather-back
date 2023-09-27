package com.observation.persistence.repository;

import com.observation.persistence.model.Weather12;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface RepositoryWeather12Page extends PagingAndSortingRepository<Weather12, UUID> {
    Page<Weather12> findByIdOrderByIdAsc(Pageable pageable, UUID id);
}