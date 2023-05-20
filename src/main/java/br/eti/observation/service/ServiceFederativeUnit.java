package br.eti.observation.service;

import br.eti.observation.persistence.MapStruct;
import br.eti.observation.persistence.model.FederativeUnit;
import br.eti.observation.persistence.payload.request.DTORequestFederativeUnit;
import br.eti.observation.persistence.payload.response.DTOResponseFederativeUnit;
import br.eti.observation.persistence.repository.RepositoryFederativeUnit;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service @RequiredArgsConstructor
public class ServiceFederativeUnit implements ServiceInterface<DTOResponseFederativeUnit, DTORequestFederativeUnit, FederativeUnit> {

    private final RepositoryFederativeUnit repositoryFederativeUnit;

    public DTOResponseFederativeUnit create(DTORequestFederativeUnit created){
        return MapStruct.MAPPER.toDTO(repositoryFederativeUnit.save(MapStruct.MAPPER.toObject(created)));
    }
    public List<DTOResponseFederativeUnit> retrieve(){
        List<DTOResponseFederativeUnit> list = new ArrayList<>();
        for(FederativeUnit om: repositoryFederativeUnit.findAll()) {
            list.add(MapStruct.MAPPER.toDTO(om));
        }
        return list;
    }
    public Page<DTOResponseFederativeUnit> retrieve(Pageable pageable){
        List<DTOResponseFederativeUnit> list = new ArrayList<>();
        for(FederativeUnit role: repositoryFederativeUnit.findAll()) {
            list.add(MapStruct.MAPPER.toDTO(role));
        }
        return new PageImpl<DTOResponseFederativeUnit>(list, pageable, list.size());
    }
    public Page<DTOResponseFederativeUnit> retrieve(Pageable pageable, String source) {
        List<DTOResponseFederativeUnit> list = new ArrayList<>();
        for(FederativeUnit object: repositoryFederativeUnit.findAll()) {
            list.add(MapStruct.MAPPER.toDTO(object));
        }
        return new PageImpl<DTOResponseFederativeUnit>(list, pageable, list.size());
    }
    public DTOResponseFederativeUnit retrieve(UUID id){
        return MapStruct.MAPPER.toDTO(repositoryFederativeUnit.findById(id).orElse(null));
    }
    public Page<DTOResponseFederativeUnit> retrieveSource(Pageable pageable, String source){
        final List<DTOResponseFederativeUnit> list = new ArrayList<>();
        if (source == null) {
            for (FederativeUnit role : repositoryFederativeUnit.findAll()) {
                list.add(MapStruct.MAPPER.toDTO(role));
            }
        } else {
            for (FederativeUnit role : repositoryFederativeUnit.findByNameContainingIgnoreCaseOrderByNameAsc(source)) {
                list.add(MapStruct.MAPPER.toDTO(role));
            }
        }
        return new PageImpl<>(list, pageable, list.size());
    }
    public DTOResponseFederativeUnit update(UUID id, DTORequestFederativeUnit updated){
        return MapStruct.MAPPER.toDTO(repositoryFederativeUnit.save(MapStruct.MAPPER.toObject(updated)));
    }
    public DTOResponseFederativeUnit delete(UUID id){
        FederativeUnit object = repositoryFederativeUnit.findById(id).orElse(null);
        repositoryFederativeUnit.deleteById(id);
        return MapStruct.MAPPER.toDTO(object);
    }
    public void delete() {
        repositoryFederativeUnit.deleteAll();
    }
    public FederativeUnit findByName(String value) { return  repositoryFederativeUnit.findByName(value); }
    public boolean existsByNameIgnoreCase(String value) {
        return repositoryFederativeUnit.existsByNameIgnoreCase(value);
    }
    public boolean existsByInitials(String value) {
        return repositoryFederativeUnit.existsByInitialsIgnoreCase(value);
    }
}