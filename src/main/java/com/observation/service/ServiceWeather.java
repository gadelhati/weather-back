package com.observation.service;

import com.observation.persistence.MapStruct;
import com.observation.persistence.model.Weather;
import com.observation.persistence.payload.request.DTORequestWeather;
import com.observation.persistence.payload.response.*;
import com.observation.persistence.repository.*;
import javax.transaction.Transactional;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.Instant;
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
//        created.setIi(created.getIi() == null ? "" : created.getIi());
//        created.setIii(created.getIii() == null ? "" : created.getIii());
        created.setObserverName(created.getObservador());
        created.setMiMi(created.getMiMi() == null ? created.getAabbxx().substring(0,2) : created.getMiMi());
        created.setMjMj("XX");
        return MapStruct.MAPPER.toDTO(repositoryWeather.save(MapStruct.MAPPER.toObject(created)));
    }
    public List<DTOResponseWeather> create(List<DTORequestWeather> createds){
        List<DTOResponseWeather> list = new ArrayList<>();
//        Set<ConstraintViolation<DTORequestWeather>> violations = new HashSet<>();
        for(DTORequestWeather created : createds){
            created.setDateObservation(created.getDataObservacao() == null ? null : created.getDataObservacao().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime().withHour(Integer.parseInt(created.getGg())));
            created.setDdddddd(created.getIi() == null && created.getIii() == null ? created.getEstacao() : created.getDdddddd());
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
            case "miMi": {
                return repositoryWeather.findByMiMiContainingIgnoreCaseOrderByMiMiAsc(pageable, value).map(MapStruct.MAPPER::toDTO);
            }
            case "ddddddd": {
                return repositoryWeather.findByDddddddContainingIgnoreCaseOrderByDddddddAsc(pageable, value).map(MapStruct.MAPPER::toDTO);
            }
            case "yy": {
                return repositoryWeather.findByYyContainingIgnoreCaseOrderByYyAsc(pageable, value).map(MapStruct.MAPPER::toDTO);
            }
            case "ii": {
                return repositoryWeather.findByIiContainingIgnoreCaseOrderByIiAsc(pageable, value).map(MapStruct.MAPPER::toDTO);
            }
            case "iii": {
                return repositoryWeather.findByIiiContainingIgnoreCaseOrderByIiiAsc(pageable, value).map(MapStruct.MAPPER::toDTO);
            }
            case "dateObservation": {
                return repositoryWeather.findByDateObservationContainingIgnoreCaseOrderByDateObservationAsc(pageable, value).map(MapStruct.MAPPER::toDTO);
            }
            default: {
                return repositoryWeather.findAll(pageable).map(MapStruct.MAPPER::toDTO);
            }
        }
    }
    public Page<DTOResponseWeatherReduced> reduced(Pageable pageable, String key, String value){
        switch (key) {
            case "ddddddd": {
                return repositoryWeather.findByDddddddContainingIgnoreCaseOrderByDddddddAsc(pageable, value).map(MapStruct.MAPPER::toDTOReduced);
            }
            case "ii": {
                return repositoryWeather.findByIiContainingIgnoreCaseOrderByIiAsc(pageable, value).map(MapStruct.MAPPER::toDTOReduced);
            }
            case "iii": {
                return repositoryWeather.findByIiiContainingIgnoreCaseOrderByIiiAsc(pageable, value).map(MapStruct.MAPPER::toDTOReduced);
            }
            default: {
                return repositoryWeather.findAll(pageable).map(MapStruct.MAPPER::toDTOReduced);
            }
        }
    }
    public String abbreviatedMsg(UUID id){
        Weather weather = repositoryWeather.findById(id).get();
        System.out.println(weather);
        return baseMsg(id)+" "+"8"+weather.getNh()+weather.getCl()+weather.getCm()+weather.getCh()+" "+"222"+weather.getDs()+weather.getVs();
    }
    public String reducedMsg(UUID id){
        Weather weather = repositoryWeather.findById(id).get();
        return baseMsg(id)+" "+"222"+weather.getDs()+weather.getVs();
    }
    public String baseMsg(UUID id){
        Weather weather = repositoryWeather.findById(id).get();
        if(weather.getMiMi().equals("AA")){
            return weather.getMiMi()+weather.getMjMj()+" "+
                    weather.getIi()+weather.getIii()+" "+
                    weather.getYy()+weather.getGg()+weather.getIw()+
                    weather.getIr()+weather.getIx()+weather.getH()+weather.getVv()+
                    weather.getN()+weather.getDd()+weather.getFf()+
                    "1sn"+weather.getTtt()+" "+
                    "4"+weather.getPpp()+" "+
                    "7"+weather.getWw()+weather.getW1()+weather.getW2();
        }else{
            return weather.getMiMi()+weather.getMjMj()+" "+
                    weather.getDdddddd()+" "+
                    weather.getYy()+weather.getGg()+weather.getIw()+" "+
                    "99"+weather.getLaLaLa()+" "+weather.getQc()+weather.getLoLoLoLo()+" "+
                    weather.getIr()+weather.getIx()+weather.getH()+weather.getVv()+" "+
                    weather.getN()+weather.getDd()+weather.getFf()+" "+
                    "1sn"+weather.getTtt()+" "+
                    "4"+weather.getPpp()+" "+
                    "7"+weather.getWw()+weather.getW1()+weather.getW2();
        }
    }
    public Page<DTOResponseWeatherAbbreviated> abbreviated(Pageable pageable, String key, String value){
        switch (key) {
            case "ddddddd": {
                return repositoryWeather.findByDddddddContainingIgnoreCaseOrderByDddddddAsc(pageable, value).map(MapStruct.MAPPER::toDTOAbbreviated);
            }
            case "ii": {
                return repositoryWeather.findByIiContainingIgnoreCaseOrderByIiAsc(pageable, value).map(MapStruct.MAPPER::toDTOAbbreviated);
            }
            case "iii": {
                return repositoryWeather.findByIiiContainingIgnoreCaseOrderByIiiAsc(pageable, value).map(MapStruct.MAPPER::toDTOAbbreviated);
            }
            default: {
                return repositoryWeather.findAll(pageable).map(MapStruct.MAPPER::toDTOAbbreviated);
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
        updated.setDataObservacao(Date.from(Instant.from(updated.getDateObservation().atZone(ZoneId.of("Z")))));
        updated.setDateObservation(updated.getDataObservacao() == null ? null : updated.getDataObservacao().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime().withHour(Integer.parseInt(updated.getGg())));
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
    public boolean existsByWeather(LocalDateTime dateObservation, String gg, String ii, String iii) {
        return repositoryWeather.existsByDateObservationAndGgIgnoreCaseAndIiIgnoreCaseAndIiiIgnoreCase(dateObservation, gg, ii, iii);
    }
    public boolean existsByWeatherAndIdNot(LocalDateTime dateObservation, String gg, String ii, String iii, UUID id) {
        return repositoryWeather.existsByDateObservationAndGgIgnoreCaseAndIiIgnoreCaseAndIiiIgnoreCaseAndIdNot(dateObservation, gg, ii, iii, id);
    }
    public boolean existsByWeather(LocalDateTime dateObservation, String gg, String ddddddd) {
        return repositoryWeather.existsByDateObservationAndGgIgnoreCaseAndDddddddIgnoreCase(dateObservation, gg, ddddddd);
    }
    public boolean existsByWeatherAndIdNot(LocalDateTime dateObservation, String gg, String ddddddd, UUID id) {
        return repositoryWeather.existsByDateObservationAndGgIgnoreCaseAndDddddddIgnoreCaseAndIdNot(dateObservation, gg, ddddddd, id);
    }
}