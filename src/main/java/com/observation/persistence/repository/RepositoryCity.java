package com.observation.persistence.repository;

import com.observation.persistence.model.City;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RepositoryCity extends JpaRepository<City, Long>, RepositoryInterface<City> {
    City findByName(String name);
    boolean existsByNameIgnoreCaseAndIdNot(String username, long id);
    boolean existsByName(String value);
    boolean existsByNameIgnoreCase(String value);
    Page<City> findByIdOrderByIdAsc(Pageable pageable, long id);
    Page<City> findByNameContainingIgnoreCaseOrderByNameAsc(Pageable pageable, String name);
}