package com.observation.persistence.repository;

import com.observation.persistence.model.Weather;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface RepositoryWeatherPage extends PagingAndSortingRepository<Weather, UUID> {

}