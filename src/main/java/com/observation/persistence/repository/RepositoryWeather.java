package com.observation.persistence.repository;

import com.observation.persistence.model.Weather;
import com.observation.persistence.model.WeatherId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.Optional;

public interface RepositoryWeather extends JpaRepository<Weather, WeatherId> {

    Optional<Weather> findByDateObservationAndIiAndIii(LocalDateTime dateObservation, String ii, String iii);
    Optional<Weather> findByDateObservationAndDdddddd(LocalDateTime dateObservation, String ddddddd);
    void deleteByDateObservationAndIiAndIii(LocalDateTime dateObservation, String ii, String iii);
    void deleteByDateObservationAndDdddddd(LocalDateTime dateObservation, String ddddddd);
}