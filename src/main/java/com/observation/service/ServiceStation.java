package com.observation.service;

import com.observation.persistence.MapStruct;
import com.observation.persistence.model.Station;
import com.observation.persistence.payload.request.DTORequestStation;
import com.observation.persistence.payload.response.DTOResponseStation;
import com.observation.persistence.payload.response.DTOResponseStationHistoric;
import com.observation.persistence.repository.RepositoryStation;
import com.observation.persistence.repository.RepositoryStationHistoricPage;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.UUID;

@Service @RequiredArgsConstructor
public class ServiceStation implements ServiceInterface<DTOResponseStation, DTORequestStation> {

    private final RepositoryStation repositoryStation;
    private final RepositoryStationHistoricPage repositoryStationHistoricPage;

    public DTOResponseStation create(DTORequestStation created){
        return MapStruct.MAPPER.toDTO(repositoryStation.save(MapStruct.MAPPER.toObject(created)));
    }
    public Page<DTOResponseStation> retrieve(Pageable pageable, String key, String value) {
        switch (key) {
            case "id": {
                return repositoryStation.findByIdOrderByIdAsc(pageable, UUID.fromString(value)).map(MapStruct.MAPPER::toDTO);
            }
            default: {
                return repositoryStation.findAll(pageable).map(MapStruct.MAPPER::toDTO);
            }
        }
    }
    public Page<DTOResponseStationHistoric> retrieveHistoric(Pageable pageable){
        return repositoryStationHistoricPage.findAll(pageable).map(MapStruct.MAPPER::toDTO);
    }
    public DTOResponseStation update(UUID id, DTORequestStation updated){
        return MapStruct.MAPPER.toDTO(repositoryStation.save(MapStruct.MAPPER.toObject(updated)));
    }
    public DTOResponseStation delete(UUID id){
        Station object = repositoryStation.findById(id).orElse(null);
        repositoryStation.deleteById(id);
        return MapStruct.MAPPER.toDTO(object);
    }
    public void delete() {
        repositoryStation.deleteAll();
    }
    //    public Station findByName(String value) { return  null; }
    public boolean existsByNameIgnoreCase(String value) {
        return false;
    }
}