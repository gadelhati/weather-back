package br.eti.observation.service;

import br.eti.observation.persistence.MapStruct;
import br.eti.observation.persistence.model.StationOffShore;
import br.eti.observation.persistence.payload.request.DTORequestStationOffShore;
import br.eti.observation.persistence.payload.response.DTOResponseStationOffShore;
import br.eti.observation.persistence.repository.RepositoryStationOffShore;
import br.eti.observation.persistence.repository.RepositoryStationOffShorePage;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service @RequiredArgsConstructor
public class ServiceStationOffShore {

    private final RepositoryStationOffShore repositoryStationOffShore;
    private final RepositoryStationOffShorePage repositoryStationOffShorePage;

    public DTOResponseStationOffShore create(DTORequestStationOffShore created){
        return MapStruct.MAPPER.toDTO(repositoryStationOffShore.save(MapStruct.MAPPER.toObject(created)));
    }
    public DTOResponseStationOffShore retrieve(UUID id){
        return MapStruct.MAPPER.toDTO(repositoryStationOffShore.findById(id).orElse(null));
    }
    public List<DTOResponseStationOffShore> retrieve(){
        List<DTOResponseStationOffShore> list = new ArrayList<>();
        for(StationOffShore object: repositoryStationOffShore.findAll()) {
            list.add(MapStruct.MAPPER.toDTO(object));
        }
        return list;
    }
    public Page<DTOResponseStationOffShore> retrieve(Pageable pageable){
        List<DTOResponseStationOffShore> list = new ArrayList<>();
        for(StationOffShore object: repositoryStationOffShore.findAll()) {
            list.add(MapStruct.MAPPER.toDTO(object));
        }
        return new PageImpl<DTOResponseStationOffShore>(list, pageable, list.size());
    }
    public Page<DTOResponseStationOffShore> retrieve(Pageable pageable, String filter){
//        List<DTOResponseStation> list = repositoryStationPage.findAll(pageable).stream().map(object -> MapStruct.MAPPER.toDTO(object)).collect(Collectors.toList());
//        return new PageImpl<DTOResponseStation>(list, pageable, list.size());
        return repositoryStationOffShorePage.findAll(pageable).map(MapStruct.MAPPER::toDTO);
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

    public boolean existsByTelegraphicCallSignIgnoreCase(String value) {
        return repositoryStationOffShore.existsByTelegraphicCallsignIgnoreCase(value);
    }
    public boolean existsByTelegraphicCallSignIgnoreCaseAndIdNot(String value, UUID id) {
        return repositoryStationOffShore.existsByTelegraphicCallsignIgnoreCaseAndIdNot(value, id);
    }
}