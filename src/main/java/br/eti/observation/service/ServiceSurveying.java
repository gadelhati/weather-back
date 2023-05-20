package br.eti.observation.service;

import br.eti.observation.persistence.MapStruct;
import br.eti.observation.persistence.model.Surveying;
import br.eti.observation.persistence.payload.request.DTORequestSurveying;
import br.eti.observation.persistence.payload.response.DTOResponseSurveying;
import br.eti.observation.persistence.repository.RepositorySurveying;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service @RequiredArgsConstructor
public class ServiceSurveying implements ServiceInterface<DTOResponseSurveying, DTORequestSurveying, Surveying> {

    private final RepositorySurveying repositorySurveying;

    public DTOResponseSurveying create(DTORequestSurveying created){
        return MapStruct.MAPPER.toDTO(repositorySurveying.save(MapStruct.MAPPER.toObject(created)));
    }
    public List<DTOResponseSurveying> retrieve(){
        List<DTOResponseSurveying> list = new ArrayList<>();
        for(Surveying om: repositorySurveying.findAll()) {
            list.add(MapStruct.MAPPER.toDTO(om));
        }
        return list;
    }
    public Page<DTOResponseSurveying> retrieve(Pageable pageable){
        List<DTOResponseSurveying> list = new ArrayList<>();
        for(Surveying role: repositorySurveying.findAll()) {
            list.add(MapStruct.MAPPER.toDTO(role));
        }
        return new PageImpl<DTOResponseSurveying>(list, pageable, list.size());
    }
    public Page<DTOResponseSurveying> retrieve(Pageable pageable, String source) {
        List<DTOResponseSurveying> list = new ArrayList<>();
        for(Surveying object: repositorySurveying.findAll()) {
            list.add(MapStruct.MAPPER.toDTO(object));
        }
        return new PageImpl<DTOResponseSurveying>(list, pageable, list.size());
    }
    public DTOResponseSurveying retrieve(UUID id){
        return MapStruct.MAPPER.toDTO(repositorySurveying.findById(id).orElse(null));
    }
    public Page<DTOResponseSurveying> retrieveSource(Pageable pageable, String source){
        final List<DTOResponseSurveying> list = new ArrayList<>();
        if (source == null) {
            for (Surveying role : repositorySurveying.findAll()) {
                list.add(MapStruct.MAPPER.toDTO(role));
            }
        } else {
            for (Surveying role : repositorySurveying.findByNameContainingIgnoreCaseOrderByNameAsc(source)) {
                list.add(MapStruct.MAPPER.toDTO(role));
            }
        }
        return new PageImpl<>(list, pageable, list.size());
    }
    public DTOResponseSurveying update(UUID id, DTORequestSurveying updated){
        Surveying object = repositorySurveying.findById(id).orElse(null);
        object.setName(updated.getName());
        return MapStruct.MAPPER.toDTO(repositorySurveying.save(object));
    }
    public DTOResponseSurveying delete(UUID id){
        Surveying object = repositorySurveying.findById(id).orElse(null);
        repositorySurveying.deleteById(id);
        return MapStruct.MAPPER.toDTO(object);
    }
    public void delete() {
        repositorySurveying.deleteAll();
    }
    public Surveying findByName(String value) { return  repositorySurveying.findByName(value); }
    public boolean existsByNameIgnoreCase(String value) {
        return repositorySurveying.existsByNameIgnoreCase(value);
    }
    public boolean existsByNameIgnoreCaseAndIdNot(String value, UUID id) {
        return repositorySurveying.existsByNameIgnoreCaseAndIdNot(value, id);
    }
}