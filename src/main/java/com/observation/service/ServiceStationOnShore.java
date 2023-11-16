package com.observation.service;

import com.observation.persistence.MapStruct;
import com.observation.persistence.model.StationOnShore;
import com.observation.persistence.payload.request.DTORequestStationOnShore;
import com.observation.persistence.payload.response.DTOResponseStationHistoricOnShore;
import com.observation.persistence.payload.response.DTOResponseStationOnShore;
import com.observation.persistence.repository.RepositoryStationHistoricOnShorePage;
import com.observation.persistence.repository.RepositoryStationOnShore;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service @RequiredArgsConstructor
public class ServiceStationOnShore implements ServiceInterface<DTOResponseStationOnShore, DTORequestStationOnShore> {

    private final RepositoryStationOnShore repositoryStationOnShore;
    private final RepositoryStationHistoricOnShorePage repositoryStationHistoricOnShorePage;

    public DTOResponseStationOnShore create(DTORequestStationOnShore created){
        return MapStruct.MAPPER.toDTO(repositoryStationOnShore.save(MapStruct.MAPPER.toObject(created)));
    }
    public Page<DTOResponseStationOnShore> retrieve(Pageable pageable, String key, String value){
        switch (key) {
            case "id": {
                return repositoryStationOnShore.findByIdOrderByIdAsc(pageable, UUID.fromString(value)).map(MapStruct.MAPPER::toDTO);
            }
            case "name": {
                return repositoryStationOnShore.findByNameContainingIgnoreCaseOrderByNameAsc(pageable, value).map(MapStruct.MAPPER::toDTO);
            }
            default: {
                return repositoryStationOnShore.findAll(pageable).map(MapStruct.MAPPER::toDTO);
            }
        }
    }
    public Page<DTOResponseStationHistoricOnShore> retrieveHistoric(Pageable pageable, String key, String value){
        switch (key) {
            case "id": {
                return repositoryStationHistoricOnShorePage.findByIdOrderByIdAsc(pageable, UUID.fromString(value)).map(MapStruct.MAPPER::toDTO);
            }
            default: {
                return repositoryStationHistoricOnShorePage.findAll(pageable).map(MapStruct.MAPPER::toDTO);
            }
        }
    }
    public DTOResponseStationOnShore update(UUID id, DTORequestStationOnShore updated){
        return MapStruct.MAPPER.toDTO(repositoryStationOnShore.save(MapStruct.MAPPER.toObject(updated)));
    }
    public DTOResponseStationOnShore delete(UUID id){
        StationOnShore object = repositoryStationOnShore.findById(id).orElse(null);
        repositoryStationOnShore.deleteById(id);
        return MapStruct.MAPPER.toDTO(object);
    }
    public void delete() {
        repositoryStationOnShore.deleteAll();
    }
    public boolean existsByName(String value) {
        return repositoryStationOnShore.existsByNameIgnoreCase(value);
    }
    public boolean existsByNameAndIdNot(String value, UUID id) {
        return repositoryStationOnShore.existsByNameIgnoreCaseAndIdNot(value, id);
    }
}