package com.observation.persistence.repository;

import java.util.UUID;

public interface RepositoryInterface<T> {

    T findByName(String name);
    boolean existsByNameIgnoreCaseAndIdNot(String username, UUID id);
    boolean existsByName(String value);
    boolean existsByNameIgnoreCase(String value);
}