package com.observation.persistence.repository;

import com.observation.persistence.model.WeatherHistoricOffShore;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface RepositoryWeatherHistoricPageOffShore extends PagingAndSortingRepository<WeatherHistoricOffShore, UUID> {

}