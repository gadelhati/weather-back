package com.observation.persistence.repository;

import com.observation.persistence.model.State;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RepositoryState extends JpaRepository<State, Long>, RepositoryInterface<State> {
    State findByName(String name);
    boolean existsByNameIgnoreCaseAndIdNot(String username, long id);
    boolean existsByName(String value);
    boolean existsByNameIgnoreCase(String value);
    Page<State> findByIdOrderByIdAsc(Pageable pageable, long id);
    Page<State> findByNameContainingIgnoreCaseOrderByNameAsc(Pageable pageable, String name);
}