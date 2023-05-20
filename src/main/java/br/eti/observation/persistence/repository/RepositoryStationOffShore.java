package br.eti.observation.persistence.repository;

import br.eti.observation.persistence.model.StationOffShore;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RepositoryStationOffShore extends JpaRepository<StationOffShore, UUID> {

    boolean existsByTelegraphicCallsignIgnoreCase(String name);
    boolean existsByTelegraphicCallsignIgnoreCaseAndIdNot(String name, UUID id);
}