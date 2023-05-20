package br.eti.observation.persistence.repository;

import br.eti.observation.persistence.model.Commission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RepositoryCommission extends JpaRepository<Commission, UUID>, RepositoryInterface<Commission> {

}