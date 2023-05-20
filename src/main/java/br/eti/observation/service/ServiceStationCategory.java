package br.eti.observation.service;

import br.eti.observation.persistence.MapStruct;
import br.eti.observation.persistence.model.StationCategory;
import br.eti.observation.persistence.payload.request.DTORequestStationCategory;
import br.eti.observation.persistence.payload.response.DTOResponseStationCategory;
import br.eti.observation.persistence.repository.RepositoryStationCategory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service @RequiredArgsConstructor
public class ServiceStationCategory implements ServiceInterface<DTOResponseStationCategory, DTORequestStationCategory, StationCategory> {

    private final RepositoryStationCategory repositoryStationCategory;

    public DTOResponseStationCategory create(DTORequestStationCategory created){
        return MapStruct.MAPPER.toDTO(repositoryStationCategory.save(MapStruct.MAPPER.toObject(created)));
    }
    public DTOResponseStationCategory retrieve(UUID id) {
        return MapStruct.MAPPER.toDTO(repositoryStationCategory.findById(id).orElse(null));
    }
    public List<DTOResponseStationCategory> retrieve(){
        List<DTOResponseStationCategory> list = new ArrayList<>();
        for(StationCategory stationCategory: repositoryStationCategory.findAll()) {
            list.add(MapStruct.MAPPER.toDTO(stationCategory));
        }
        return list;
    }
    public Page<DTOResponseStationCategory> retrieve(Pageable pageable){
        List<DTOResponseStationCategory> list = new ArrayList<>();
        for(StationCategory stationCategory: repositoryStationCategory.findAll()) {
            list.add(MapStruct.MAPPER.toDTO(stationCategory));
        }
        return new PageImpl<DTOResponseStationCategory>(list, pageable, list.size());
    }
    public Page<DTOResponseStationCategory> retrieve(Pageable pageable, String source){
        final List<DTOResponseStationCategory> list = new ArrayList<>();
        if (source == null) {
            for (StationCategory stationCategory : repositoryStationCategory.findAll()) {
                list.add(MapStruct.MAPPER.toDTO(stationCategory));
            }
        } else {
            for (StationCategory stationCategory : repositoryStationCategory.findByNameContainingIgnoreCaseOrderByNameAsc(source)) {
                list.add(MapStruct.MAPPER.toDTO(stationCategory));
            }
        }
        return new PageImpl<>(list, pageable, list.size());
    }
    public DTOResponseStationCategory update(UUID id, DTORequestStationCategory updated){
        return MapStruct.MAPPER.toDTO(repositoryStationCategory.save(MapStruct.MAPPER.toObject(updated)));
    }
    public DTOResponseStationCategory delete(UUID id){
        StationCategory object = repositoryStationCategory.findById(id).orElse(null);
        repositoryStationCategory.deleteById(id);
        return MapStruct.MAPPER.toDTO(object);
    }
    public void delete() {
        repositoryStationCategory.deleteAll();
    }
    public StationCategory findByName(String stationCategory) { return  repositoryStationCategory.findByName(stationCategory); }
    public boolean existsByNameIgnoreCase(String value) {
        return repositoryStationCategory.existsByNameIgnoreCase(value);
    }
    public boolean existsByNameIgnoreCaseAndIdNot(String value, UUID id) {
        return repositoryStationCategory.existsByNameIgnoreCaseAndIdNot(value, id);
    }
}