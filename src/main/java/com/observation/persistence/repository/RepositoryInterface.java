package com.observation.persistence.repository;

import java.util.List;
import java.util.UUID;

public interface RepositoryInterface<T> {
    List<T> findByNameContainingIgnoreCaseOrderByNameAsc(String name);
    T findByName(String name);
    boolean existsByName(String value);
    boolean existsByNameIgnoreCase(String value);
    boolean existsByNameIgnoreCaseAndIdNot(String name, UUID id);
}