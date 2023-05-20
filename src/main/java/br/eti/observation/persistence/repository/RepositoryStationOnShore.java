package br.eti.observation.persistence.repository;

import br.eti.observation.persistence.model.Manufacturer;
import br.eti.observation.persistence.model.StationOnShore;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RepositoryStationOnShore extends JpaRepository<StationOnShore, UUID>, RepositoryInterface<Manufacturer> {

}