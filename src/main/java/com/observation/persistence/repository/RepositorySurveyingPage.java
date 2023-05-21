package com.observation.persistence.repository;

import com.observation.persistence.model.Surveying;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface RepositorySurveyingPage extends PagingAndSortingRepository<Surveying, UUID>, RepositoryInterfacePage<Surveying> {

}