package br.eti.observation.persistence.repository;

import br.eti.observation.persistence.model.PlatformCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RepositoryPlatformCategory extends JpaRepository<PlatformCategory, UUID>, RepositoryInterface<PlatformCategory> {

}