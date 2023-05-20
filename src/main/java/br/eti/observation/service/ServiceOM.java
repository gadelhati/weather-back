package br.eti.observation.service;

import br.eti.observation.persistence.MapStruct;
import br.eti.observation.persistence.model.OM;
import br.eti.observation.persistence.payload.request.DTORequestOM;
import br.eti.observation.persistence.payload.response.DTOResponseOM;
import br.eti.observation.persistence.repository.RepositoryOM;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service @RequiredArgsConstructor
public class ServiceOM implements ServiceInterface<DTOResponseOM, DTORequestOM, OM> {

    private final RepositoryOM repositoryOM;

    public DTOResponseOM create(DTORequestOM created){
        return MapStruct.MAPPER.toDTO(repositoryOM.save(MapStruct.MAPPER.toObject(created)));
    }
    public List<DTOResponseOM> retrieve(){
        List<DTOResponseOM> list = new ArrayList<>();
        for(OM om: repositoryOM.findAll()) {
            list.add(MapStruct.MAPPER.toDTO(om));
        }
        return list;
    }
    public Page<DTOResponseOM> retrieve(Pageable pageable){
        List<DTOResponseOM> list = new ArrayList<>();
        for(OM role: repositoryOM.findAll()) {
            list.add(MapStruct.MAPPER.toDTO(role));
        }
        return new PageImpl<DTOResponseOM>(list, pageable, list.size());
    }
    public Page<DTOResponseOM> retrieve(Pageable pageable, String source) {
        List<DTOResponseOM> list = new ArrayList<>();
        for(OM object: repositoryOM.findAll()) {
            list.add(MapStruct.MAPPER.toDTO(object));
        }
        return new PageImpl<DTOResponseOM>(list, pageable, list.size());
    }
    public DTOResponseOM retrieve(UUID id){
        return MapStruct.MAPPER.toDTO(repositoryOM.findById(id).orElse(null));
    }
    public Page<DTOResponseOM> retrieveSource(Pageable pageable, String source){
        final List<DTOResponseOM> list = new ArrayList<>();
        if (source == null) {
            for (OM role : repositoryOM.findAll()) {
                list.add(MapStruct.MAPPER.toDTO(role));
            }
        } else {
            for (OM role : repositoryOM.findByNameContainingIgnoreCaseOrderByNameAsc(source)) {
                list.add(MapStruct.MAPPER.toDTO(role));
            }
        }
        return new PageImpl<>(list, pageable, list.size());
    }
    public DTOResponseOM update(UUID id, DTORequestOM updated){
        return MapStruct.MAPPER.toDTO(repositoryOM.save(MapStruct.MAPPER.toObject(updated)));
    }
    public DTOResponseOM delete(UUID id){
        OM object = repositoryOM.findById(id).orElse(null);
        repositoryOM.deleteById(id);
        return MapStruct.MAPPER.toDTO(object);
    }
    public void delete() {
        repositoryOM.deleteAll();
    }
    public OM findByName(String value) { return  repositoryOM.findByName(value); }
    public boolean existsByNameIgnoreCase(String value) {
        return repositoryOM.existsByNameIgnoreCase(value);
    }
}