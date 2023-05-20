package br.eti.observation.persistence.repository;

import br.eti.observation.persistence.model.Observer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.util.Streamable;

import java.util.UUID;

public interface RepositoryObserver extends JpaRepository<Observer, UUID>, RepositoryInterface<Observer> {
    boolean existsByNipIgnoreCase(String value);
    boolean existsByNipIgnoreCaseAndIdNot(String nip, UUID id);
    boolean existsByNameIgnoreCase(String value);
    boolean existsById(UUID value);
    Streamable<Observer> findByNameContaining(String value);
    Streamable<Observer> findByIdNot(UUID value);
}