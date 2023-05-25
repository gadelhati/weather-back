package com.observation.persistence.repository;

import com.observation.persistence.model.WeatherHistoric;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface RepositoryWeatherHistoricPage extends PagingAndSortingRepository<WeatherHistoric, UUID> {

}