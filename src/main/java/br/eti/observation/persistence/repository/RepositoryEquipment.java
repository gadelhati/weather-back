package br.eti.observation.persistence.repository;

import br.eti.observation.persistence.model.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RepositoryEquipment extends JpaRepository<Equipment, UUID>, RepositoryInterface<Equipment> {

}