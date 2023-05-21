package com.observation.persistence.repository;

import com.observation.persistence.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RepositoryCompany extends JpaRepository<Company, UUID>, RepositoryInterface<Company> {

}