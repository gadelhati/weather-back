package com.observation.service;

import com.observation.persistence.MapStruct;
import com.observation.persistence.payload.request.DTORequestWeather;
import com.observation.persistence.payload.response.DTOResponseWeather;
import com.observation.persistence.payload.response.DTOResponseWeatherHistoric;
import com.observation.persistence.payload.response.DTOResponseWeatherHistoricOffShore;
import com.observation.persistence.payload.response.DTOResponseWeatherHistoricOnShore;
import com.observation.persistence.repository.*;
import javax.transaction.Transactional;
import javax.validation.ConstraintViolation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;

@Service @RequiredArgsConstructor
public class ServiceWeather {

    private final RepositoryWeather repositoryWeather;
    private final RepositoryStationOffShore repositoryStationOffShore;
    private final RepositoryObserver repositoryObserver;
    private final RepositoryWeatherHistoricPage repositoryWeatherHistoricPage;
    private final RepositoryWeatherHistoricPageOffShore repositoryWeatherHistoricPageOffShore;
    private final RepositoryWeatherHistoricPageOnShore repositoryWeatherHistoricPageOnShore;

    public DTOResponseWeather create(DTORequestWeather created){
        created.setDateObservation(created.getDataObservacao() == null ? null : created.getDataObservacao().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime().withHour(Integer.parseInt(created.getGg())));
        created.setDdddddd(created.getIi() == null && created.getIii() == null ? created.getEstacao() : created.getDdddddd());
        created.setIi(created.getIi() == null ? "" : created.getIi());
        created.setIii(created.getIii() == null ? "" : created.getIii());
        created.setObserverName(created.getObservador());
        created.setMiMi(created.getAabbxx().substring(0,2));
        created.setMjMj("XX");
        return MapStruct.MAPPER.toDTO(repositoryWeather.save(MapStruct.MAPPER.toObject(created)));
    }
    public List<DTOResponseWeather> create(List<DTORequestWeather> createds){
        List<DTOResponseWeather> list = new ArrayList<>();
//        Set<ConstraintViolation<DTORequestWeather>> violations = new HashSet<>();
        for(DTORequestWeather created : createds){
            created.setDateObservation(created.getDataObservacao() == null ? null : created.getDataObservacao().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime().withHour(Integer.parseInt(created.getGg())));
            created.setDdddddd(created.getIi() == null && created.getIii() == null ? created.getEstacao() : created.getDdddddd());
            created.setIi(created.getIi() == null ? "" : created.getIi());
            created.setIii(created.getIii() == null ? "" : created.getIii());
            created.setObserverName(created.getObservador());
            created.setMiMi(created.getAabbxx().substring(0,2));
            created.setMjMj("XX");
            repositoryWeather.save(MapStruct.MAPPER.toObject(created));
            list.add(MapStruct.MAPPER.toDTO(MapStruct.MAPPER.toObject(created)));
        }
        return list;
    }
    public DTOResponseWeather retrieve(UUID id){
        return MapStruct.MAPPER.toDTO(repositoryWeather.findById(id).orElseGet(null));
    }
    public Page<DTOResponseWeather> retrieve(Pageable pageable, String key, String value){
        switch (key) {
//            case "id": {
//                return repositoryWeather.findById(pageable, new WeatherId(dateObservation, ddddddd, ii, iii)).map(MapStruct.MAPPER::toDTO);
//            }
            default: {
                return repositoryWeather.findAll(pageable).map(MapStruct.MAPPER::toDTO);
            }
        }
    }
    public Page<DTOResponseWeatherHistoric> retrieveHistoric(Pageable pageable, String key, String value){
        switch (key) {
//            case "id": {
//                return repositoryWeatherHistoricPage.findByIdOrderByIdAsc(pageable, UUID.fromString(value)).map(MapStruct.MAPPER::toDTO);
//            }
            default: {
                return repositoryWeatherHistoricPage.findAll(pageable).map(MapStruct.MAPPER::toDTO);
            }
        }
    }
    public Page<DTOResponseWeatherHistoricOffShore> retrieveHistoricOffShore(Pageable pageable, String key, String value){
        switch (key) {
//            case "id": {
//                return repositoryWeatherHistoricPageOffShore.findByIdOrderByIdAsc(pageable, UUID.fromString(value)).map(MapStruct.MAPPER::toDTO);
//            }
            default: {
                return repositoryWeatherHistoricPageOffShore.findAll(pageable).map(MapStruct.MAPPER::toDTO);
            }
        }
    }
    public Page<DTOResponseWeatherHistoricOnShore> retrieveHistoricOnShore(Pageable pageable, String key, String value){
        switch (key) {
//            case "id": {
//                return repositoryWeatherHistoricPageOnShore.findByIdOrderByIdAsc(pageable, UUID.fromString(value)).map(MapStruct.MAPPER::toDTO);
//            }
            default: {
                return repositoryWeatherHistoricPageOnShore.findAll(pageable).map(MapStruct.MAPPER::toDTO);
            }
        }
    }
    public DTOResponseWeather update(UUID id, DTORequestWeather updated) {
        updated.setDateObservation(updated.getDataObservacao().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime().withHour(Integer.parseInt(updated.getGg())));
        return MapStruct.MAPPER.toDTO(repositoryWeather.save(MapStruct.MAPPER.toObject(updated)));
    }
    @Transactional
    public DTOResponseWeather delete(UUID id){
        DTOResponseWeather dtoResponseWeather = MapStruct.MAPPER.toDTO(repositoryWeather.findById(id).orElse(null));
        repositoryWeather.deleteById(id);
        return dtoResponseWeather;
    }
    public void delete() {
        repositoryWeather.deleteAll();
    };
    public boolean existsByDateObservation(LocalDateTime dateObservation, String ii, String iii) {
        return repositoryWeather.existsByDateObservationAndIiIgnoreCaseAndIiiIgnoreCase(dateObservation, ii, iii);
    }
    public boolean existsByDateObservationAndIdNot(LocalDateTime dateObservation, String ii, String iii, UUID id) {
        return repositoryWeather.existsByDateObservationAndIiIgnoreCaseAndIiiIgnoreCaseAndIdNot(dateObservation, ii, iii, id);
    }
    public boolean existsByDataObservacao(Date dataObservacao, String gg, String ii, String iii) {
        return repositoryWeather.existsByDataObservacaoAndGgIgnoreCaseAndIiIgnoreCaseAndIiiIgnoreCase(dataObservacao, gg, ii, iii);
    }
    public boolean existsByDataObservacaoAndIdNot(Date dataObservacao, String gg, String ii, String iii, UUID id) {
        return repositoryWeather.existsByDataObservacaoAndGgIgnoreCaseAndIiIgnoreCaseAndIiiIgnoreCaseAndIdNot(dataObservacao, gg, ii, iii, id);
    }
}