package com.observation.persistence.repository;

import com.observation.persistence.model.SynopticObservation;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface RepositorySynopticObservationPage extends PagingAndSortingRepository<SynopticObservation, UUID> {

}