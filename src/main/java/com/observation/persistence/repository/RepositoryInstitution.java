package com.observation.persistence.repository;

import com.observation.persistence.model.Institution;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RepositoryInstitution extends JpaRepository<Institution, UUID>, RepositoryInterface<Institution> {

}