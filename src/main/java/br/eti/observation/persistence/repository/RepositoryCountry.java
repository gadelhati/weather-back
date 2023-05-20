package br.eti.observation.persistence.repository;

import br.eti.observation.persistence.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RepositoryCountry extends JpaRepository<Country, UUID>, RepositoryInterface<Country> {

}