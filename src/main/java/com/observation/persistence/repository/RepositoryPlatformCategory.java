package com.observation.persistence.repository;

import com.observation.persistence.model.PlatformCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RepositoryPlatformCategory extends JpaRepository<PlatformCategory, UUID>, RepositoryInterface<PlatformCategory> {

}