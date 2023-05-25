package com.observation.persistence.repository;

import com.observation.persistence.model.WeatherHistoricOnShore;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface RepositoryWeatherHistoricPageOnShore extends PagingAndSortingRepository<WeatherHistoricOnShore, UUID> {

}