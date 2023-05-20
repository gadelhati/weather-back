package br.eti.observation.persistence.repository;

import br.eti.observation.persistence.model.Individual;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RepositoryIndividual extends JpaRepository<Individual, UUID>, RepositoryInterface<Individual> {

}