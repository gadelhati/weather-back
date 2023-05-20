package br.eti.observation.persistence.repository;

import br.eti.observation.persistence.model.Surveying;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RepositorySurveying extends JpaRepository<Surveying, UUID>, RepositoryInterface<Surveying> {

}