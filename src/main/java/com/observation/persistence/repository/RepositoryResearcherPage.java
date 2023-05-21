package com.observation.persistence.repository;

import com.observation.persistence.model.Researcher;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface RepositoryResearcherPage extends PagingAndSortingRepository<Researcher, UUID>, RepositoryInterfacePage<Researcher> {

}