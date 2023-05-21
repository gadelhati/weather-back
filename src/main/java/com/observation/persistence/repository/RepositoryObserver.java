package com.observation.persistence.repository;

import com.observation.persistence.model.Observer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.util.Streamable;

import java.util.UUID;

public interface RepositoryObserver extends JpaRepository<Observer, UUID>, RepositoryInterface<Observer> {

    boolean existsByNipIgnoreCaseAndIdNot(String username, UUID id);
    boolean existsByNipIgnoreCase(String value);
}