package br.eti.observation.persistence.repository;

import br.eti.observation.persistence.model.Station;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RepositoryStation extends JpaRepository<Station, UUID> {

}