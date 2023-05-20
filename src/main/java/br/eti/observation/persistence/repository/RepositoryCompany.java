package br.eti.observation.persistence.repository;

import br.eti.observation.persistence.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RepositoryCompany extends JpaRepository<Company, UUID>, RepositoryInterface<Company> {

}