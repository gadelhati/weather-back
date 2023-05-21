package com.observation.service;

import com.observation.persistence.MapStruct;
import com.observation.persistence.model.StationOnShore;
import com.observation.persistence.payload.request.DTORequestStationOnShore;
import com.observation.persistence.payload.response.DTOResponseStationOnShore;
import com.observation.persistence.repository.RepositoryStationOnShore;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service @RequiredArgsConstructor
public class ServiceStationOnShore implements ServiceInterface<DTOResponseStationOnShore, DTORequestStationOnShore, StationOnShore> {

    private final RepositoryStationOnShore repositoryStationOnShore;

    public DTOResponseStationOnShore create(DTORequestStationOnShore created){
        return MapStruct.MAPPER.toDTO(repositoryStationOnShore.save(MapStruct.MAPPER.toObject(created)));
    }
    public DTOResponseStationOnShore retrieve(UUID id){
        return MapStruct.MAPPER.toDTO(repositoryStationOnShore.findById(id).orElse(null));
    }
    public List<DTOResponseStationOnShore> retrieve(){
        List<DTOResponseStationOnShore> list = new ArrayList<>();
        for(StationOnShore object: repositoryStationOnShore.findAll()) {
            list.add(MapStruct.MAPPER.toDTO(object));
        }
        return list;
    }
    public Page<DTOResponseStationOnShore> retrieve(Pageable pageable){
        List<DTOResponseStationOnShore> list = new ArrayList<>();
        for(StationOnShore object: repositoryStationOnShore.findAll()) {
            list.add(MapStruct.MAPPER.toDTO(object));
        }
        return new PageImpl<DTOResponseStationOnShore>(list, pageable, list.size());
    }
    public Page<DTOResponseStationOnShore> retrieve(Pageable pageable, String source){
        final List<DTOResponseStationOnShore> list = new ArrayList<>();
        if (source == null) {
            for (StationOnShore object : repositoryStationOnShore.findAll()) {
                list.add(MapStruct.MAPPER.toDTO(object));
            }
        } else {
//            for (StationOffShore object : repositoryStationOffShore.findByLatitudeMostBottomContainingIgnoreCaseOrderByLatitudeMostBottomAsc(source)) {
//                list.add(DTOResponseStationOffShore.toDTO(object));
//            }
        }
        return new PageImpl<>(list, pageable, list.size());
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
    public StationOnShore findByName(String value) {
        return null;
    }
    public boolean existsByNameIgnoreCase(String value) {
        return repositoryStationOnShore.existsByNameIgnoreCase(value);
    }
    public boolean existsByNameIgnoreCaseAndIdNot(String value, UUID id) {
        return repositoryStationOnShore.existsByNameIgnoreCaseAndIdNot(value, id);
    }
}