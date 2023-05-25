package com.observation.persistence.repository;

import com.observation.persistence.model.Weather;
import com.observation.persistence.model.WeatherId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryWeather extends JpaRepository<Weather, WeatherId> {

}