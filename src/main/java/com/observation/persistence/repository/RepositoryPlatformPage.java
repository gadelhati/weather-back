package com.observation.persistence.repository;

import com.observation.persistence.model.Platform;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface RepositoryPlatformPage extends PagingAndSortingRepository<Platform, UUID>, RepositoryInterfacePage<Platform> {

}