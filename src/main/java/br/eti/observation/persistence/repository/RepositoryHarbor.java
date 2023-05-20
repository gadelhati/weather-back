package br.eti.observation.persistence.repository;

import br.eti.observation.persistence.model.Harbor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RepositoryHarbor extends JpaRepository<Harbor, UUID>, RepositoryInterface<Harbor> {

}