package com.observation.persistence.repository;

import com.observation.persistence.model.Weather;
import com.observation.persistence.model.WeatherId;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface RepositoryWeatherPage extends PagingAndSortingRepository<Weather, WeatherId> {

}