package br.eti.observation.persistence.repository;

import br.eti.observation.persistence.model.Institution;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RepositoryInstitution extends JpaRepository<Institution, UUID>, RepositoryInterface<Institution> {

}