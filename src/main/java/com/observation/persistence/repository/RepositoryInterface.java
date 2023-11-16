package com.observation.persistence.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface RepositoryInterface<T> {

    T findByName(String name);
    boolean existsByNameIgnoreCaseAndIdNot(String username, UUID id);
    boolean existsByName(String value);
    boolean existsByNameIgnoreCase(String value);
    Page<T> findByIdOrderByIdAsc(Pageable pageable, UUID id);
    Page<T> findByNameContainingIgnoreCaseOrderByNameAsc(Pageable pageable, String name);
}