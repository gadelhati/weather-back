package com.observation.persistence.repository;

import com.observation.persistence.model.OM;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface RepositoryOMPage extends PagingAndSortingRepository<OM, UUID>, RepositoryInterfacePage<OM> {

}