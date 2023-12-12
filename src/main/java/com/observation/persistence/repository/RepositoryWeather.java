package com.observation.persistence.repository;

import com.observation.persistence.model.Weather;
import com.observation.persistence.model.WeatherHistoric;
import com.observation.persistence.model.WeatherId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;

public interface RepositoryWeather extends JpaRepository<Weather, UUID> {

    boolean existsByDateObservationAndGgIgnoreCaseAndIiIgnoreCaseAndIiiIgnoreCase(LocalDateTime dataObservacao, String gg, String ii, String iii);
    boolean existsByDateObservationAndGgIgnoreCaseAndIiIgnoreCaseAndIiiIgnoreCaseAndIdNot(LocalDateTime dataObservacao, String gg, String ii, String iii, UUID id);
    boolean existsByDateObservationAndGgIgnoreCaseAndDddddddIgnoreCase(LocalDateTime dataObservacao, String gg, String ddddddd);
    boolean existsByDateObservationAndGgIgnoreCaseAndDddddddIgnoreCaseAndIdNot(LocalDateTime dataObservacao, String gg, String ddddddd, UUID id);
    Optional<Weather> findByDateObservationAndIiAndIii(LocalDateTime dateObservation, String ii, String iii);
    Optional<Weather> findByDateObservationAndDdddddd(LocalDateTime dateObservation, String ddddddd);
    void deleteByDateObservationAndIiAndIii(LocalDateTime dateObservation, String ii, String iii);
    void deleteByDateObservationAndDdddddd(LocalDateTime dateObservation, String ddddddd);
}