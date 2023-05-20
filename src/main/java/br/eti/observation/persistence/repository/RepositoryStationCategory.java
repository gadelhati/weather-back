package br.eti.observation.persistence.repository;

import br.eti.observation.persistence.model.StationCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RepositoryStationCategory extends JpaRepository<StationCategory, UUID>, RepositoryInterface<StationCategory> {

}