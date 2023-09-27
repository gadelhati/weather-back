package com.observation.persistence.repository;

import com.observation.persistence.model.Weather12;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RepositoryWeather12 extends JpaRepository<Weather12, UUID> {

}