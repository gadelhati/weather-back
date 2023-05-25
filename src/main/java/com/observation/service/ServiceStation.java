package com.observation.service;

import com.observation.persistence.MapStruct;
import com.observation.persistence.model.Station;
import com.observation.persistence.payload.request.DTORequestStation;
import com.observation.persistence.payload.response.DTOResponseStation;
import com.observation.persistence.payload.response.DTOResponseStationHistoric;
import com.observation.persistence.repository.RepositoryStation;
import com.observation.persistence.repository.RepositoryStationHistoricPage;
import com.observation.persistence.repository.RepositoryStationPage;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service @RequiredArgsConstructor
public class ServiceStation implements ServiceInterface<DTOResponseStation, DTORequestStation> {

    private final RepositoryStation repositoryStation;
    private final RepositoryStationPage repositoryStationPage;
    private final RepositoryStationHistoricPage repositoryStationHistoricPage;

    public DTOResponseStation create(DTORequestStation created){
        return MapStruct.MAPPER.toDTO(repositoryStation.save(MapStruct.MAPPER.toObject(created)));
    }
    public Page<DTOResponseStation> retrieve(Pageable pageable, String filter) {
        switch (pageable.getSort().toString().substring(0, pageable.getSort().toString().length() - 5)) {
            case "id": {
                return repositoryStationPage.findByIdOrderByIdAsc(pageable, UUID.fromString(filter)).map(MapStruct.MAPPER::toDTO);
            }
            default: {
                return repositoryStationPage.findAll(pageable).map(MapStruct.MAPPER::toDTO);
            }
        }
    }
    public Page<DTOResponseStationHistoric> retrieveHistoric(Pageable pageable, String filter){
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