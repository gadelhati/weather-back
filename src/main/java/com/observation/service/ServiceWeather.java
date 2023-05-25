package com.observation.service;

import com.observation.persistence.MapStruct;
import com.observation.persistence.model.WeatherId;
import com.observation.persistence.payload.request.DTORequestWeather;
import com.observation.persistence.payload.response.DTOResponseWeather;
import com.observation.persistence.payload.response.DTOResponseWeatherHistoric;
import com.observation.persistence.payload.response.DTOResponseWeatherHistoricOffShore;
import com.observation.persistence.payload.response.DTOResponseWeatherHistoricOnShore;
import com.observation.persistence.repository.*;
import jakarta.validation.ConstraintViolation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.ZoneId;
import java.util.*;

@Service @RequiredArgsConstructor
public class ServiceWeather {

    private final RepositoryWeather repositoryWeather;
    private final RepositoryStationOffShore repositoryStationOffShore;
    private final RepositoryObserver repositoryObserver;
    private final RepositoryWeatherPage repositoryWeatherPage;
    private final RepositoryWeatherHistoricPage repositoryWeatherHistoricPage;
    private final RepositoryWeatherHistoricPageOffShore repositoryWeatherHistoricPageOffShore;
    private final RepositoryWeatherHistoricPageOnShore repositoryWeatherHistoricPageOnShore;

    public DTOResponseWeather create(DTORequestWeather created){
        return MapStruct.MAPPER.toDTO(repositoryWeather.save(MapStruct.MAPPER.toObject(created)));
    }
    public List<DTOResponseWeather> create(List<DTORequestWeather> createds){
        List<DTOResponseWeather> list = new ArrayList<>();
        Set<ConstraintViolation<DTORequestWeather>> violations = new HashSet<>();
        for(DTORequestWeather created : createds){
            created.setDateObservation(created.getDataObservacao().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime().withHour(Integer.parseInt(created.getGg())));
            created.setDdddddd(created.getEstacao());
//            created.setObserverName(created.getObservador());
            created.setMimi(created.getAabbxx().substring(0,2));
            created.setMjmj("XX");
            repositoryWeather.save(MapStruct.MAPPER.toObject(created));
            list.add(MapStruct.MAPPER.toDTO(MapStruct.MAPPER.toObject(created)));
        }
        return list;
    }
    public Page<DTOResponseWeather> retrieve(Pageable pageable, String filter){
        switch (pageable.getSort().toString().substring(0, pageable.getSort().toString().length() - 5)) {
            default: {
                return repositoryWeatherPage.findAll(pageable).map(MapStruct.MAPPER::toDTO);
            }
        }
    }
    public Page<DTOResponseWeatherHistoric> retrieveHistoric(Pageable pageable, String filter){
        return repositoryWeatherHistoricPage.findAll(pageable).map(MapStruct.MAPPER::toDTO);
    }
    public Page<DTOResponseWeatherHistoricOffShore> retrieveHistoricOffShore(Pageable pageable, String filter){
        return repositoryWeatherHistoricPageOffShore.findAll(pageable).map(MapStruct.MAPPER::toDTO);
    }
    public Page<DTOResponseWeatherHistoricOnShore> retrieveHistoricOnShore(Pageable pageable, String filter){
        return repositoryWeatherHistoricPageOnShore.findAll(pageable).map(MapStruct.MAPPER::toDTO);
    }
    public DTOResponseWeather update(WeatherId id, DTORequestWeather updated) {
        updated.setDateObservation(updated.getDataObservacao().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime().withHour(Integer.parseInt(updated.getGg())));
        updated.setDdddddd(updated.getEstacao());
        return MapStruct.MAPPER.toDTO(repositoryWeather.save(MapStruct.MAPPER.toObject(updated)));
    }
    public DTOResponseWeather delete(WeatherId weatherId){
//        DTOResponseSynopticObservation dtoResponseSynopticObservation = MapStruct.MAPPER.toDTO(repositorySynopticObservation.findById(id).orElse(null));
//        repositorySynopticObservation.deleteById(id);
//        return dtoResponseSynopticObservation;

        repositoryWeather.deleteById(weatherId);
        return MapStruct.MAPPER.toDTO(repositoryWeather.findById(weatherId).orElse(null));
    }
    public void delete() {
        repositoryWeather.deleteAll();
    };
}