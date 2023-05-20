package br.eti.observation.persistence.repository;

import br.eti.observation.persistence.model.Station;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RepositoryStationPage extends PagingAndSortingRepository<Station, UUID> {

}