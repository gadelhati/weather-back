package com.observation.persistence.repository;

import com.observation.persistence.model.PlatformCategory;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface RepositoryPlatformCategoryPage extends PagingAndSortingRepository<PlatformCategory, UUID>, RepositoryInterfacePage<PlatformCategory> {

}