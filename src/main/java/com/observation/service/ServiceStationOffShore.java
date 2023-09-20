package com.observation.service;

import com.observation.persistence.MapStruct;
import com.observation.persistence.model.StationOffShore;
import com.observation.persistence.payload.request.DTORequestStationOffShore;
import com.observation.persistence.payload.response.DTOResponseStationHistoricOffShore;
import com.observation.persistence.payload.response.DTOResponseStationOffShore;
import com.observation.persistence.repository.RepositoryStationHistoricOffShorePage;
import com.observation.persistence.repository.RepositoryStationOffShore;
import com.observation.persistence.repository.RepositoryStationOffShorePage;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service @RequiredArgsConstructor
public class ServiceStationOffShore implements ServiceInterface<DTOResponseStationOffShore, DTORequestStationOffShore> {

    private final RepositoryStationOffShore repositoryStationOffShore;
    private final RepositoryStationOffShorePage repositoryStationOffShorePage;
    private final RepositoryStationHistoricOffShorePage repositoryStationHistoricOffShorePage;

    public DTOResponseStationOffShore create(DTORequestStationOffShore created){
        return MapStruct.MAPPER.toDTO(repositoryStationOffShore.save(MapStruct.MAPPER.toObject(created)));
    }
    public Page<DTOResponseStationOffShore> retrieve(Pageable pageable, String key, String value){
        switch (key) {
            case "id": {
                return repositoryStationOffShorePage.findByIdOrderByIdAsc(pageable, UUID.fromString(value)).map(MapStruct.MAPPER::toDTO);
            }
            default: {
                return repositoryStationOffShorePage.findAll(pageable).map(MapStruct.MAPPER::toDTO);
            }
        }
    }
    public Page<DTOResponseStationHistoricOffShore> retrieveHistoric(Pageable pageable, String key, String value){
        switch (key) {
            case "id": {
                return repositoryStationHistoricOffShorePage.findByIdOrderByIdAsc(pageable, UUID.fromString(value)).map(MapStruct.MAPPER::toDTO);
            }
            case "telegraphicCallSign": {
                return repositoryStationHistoricOffShorePage.findByTelegraphicCallSignContainingIgnoreCaseOrderByTelegraphicCallSignAsc(pageable, value).map(MapStruct.MAPPER::toDTO);
            }
            default: {
                return repositoryStationHistoricOffShorePage.findAll(pageable).map(MapStruct.MAPPER::toDTO);
            }
        }
    }
    public DTOResponseStationOffShore update(UUID id, DTORequestStationOffShore updated){
        return MapStruct.MAPPER.toDTO(repositoryStationOffShore.save(MapStruct.MAPPER.toObject(updated)));
    }
    public DTOResponseStationOffShore delete(UUID id){
        StationOffShore object = repositoryStationOffShore.findById(id).orElse(null);
        repositoryStationOffShore.deleteById(id);
        return MapStruct.MAPPER.toDTO(object);
    }
    public void delete() {
        repositoryStationOffShore.deleteAll();
    }
    public boolean existsByName(String value) {
        return false;
    }
    public boolean existsByNameAndIdNot(String value, UUID id) {
        return false;
    }
    public boolean existsByTelegraphicCallSign(String value) {
        return repositoryStationOffShore.existsByTelegraphicCallSignIgnoreCase(value);
    }
    public boolean existsByTelegraphicCallSignAndIdNot(String value, UUID id) {
        return repositoryStationOffShore.existsByTelegraphicCallSignIgnoreCaseAndIdNot(value, id);
    }
}