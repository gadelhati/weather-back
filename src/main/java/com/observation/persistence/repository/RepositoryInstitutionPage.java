package com.observation.persistence.repository;

import com.observation.persistence.model.Institution;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface RepositoryInstitutionPage extends PagingAndSortingRepository<Institution, UUID>, RepositoryInterfacePage<Institution> {

}