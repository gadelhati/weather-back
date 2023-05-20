package br.eti.observation.service;

import br.eti.observation.persistence.MapStruct;
import br.eti.observation.persistence.model.Role;
import br.eti.observation.persistence.payload.request.DTORequestRole;
import br.eti.observation.persistence.payload.response.DTOResponseRole;
import br.eti.observation.persistence.repository.RepositoryRole;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service @RequiredArgsConstructor
public class ServiceRole implements ServiceInterface<DTOResponseRole, DTORequestRole, Role> {

    private final RepositoryRole repositoryRole;

    public DTOResponseRole create(DTORequestRole created){
        return MapStruct.MAPPER.toDTO(repositoryRole.save(MapStruct.MAPPER.toObject(created)));
    }
    public DTOResponseRole retrieve(UUID id) {
        return MapStruct.MAPPER.toDTO(repositoryRole.findById(id).orElse(null));
    }
    public List<DTOResponseRole> retrieve(){
        List<DTOResponseRole> list = new ArrayList<>();
        for(Role role: repositoryRole.findAll()) {
            list.add(MapStruct.MAPPER.toDTO(role));
        }
        return list;
    }
    public Page<DTOResponseRole> retrieve(Pageable pageable){
        List<DTOResponseRole> list = new ArrayList<>();
        for(Role role: repositoryRole.findAll()) {
            list.add(MapStruct.MAPPER.toDTO(role));
        }
        return new PageImpl<DTOResponseRole>(list, pageable, list.size());
    }
    public Page<DTOResponseRole> retrieve(Pageable pageable, String source){
        final List<DTOResponseRole> list = new ArrayList<>();
        if (source == null) {
            for (Role role : repositoryRole.findAll()) {
                list.add(MapStruct.MAPPER.toDTO(role));
            }
        } else {
            for (Role role : repositoryRole.findByNameContainingIgnoreCaseOrderByNameAsc(source)) {
                list.add(MapStruct.MAPPER.toDTO(role));
            }
        }
        return new PageImpl<>(list, pageable, list.size());
    }
    public DTOResponseRole update(UUID id, DTORequestRole updated){
        return MapStruct.MAPPER.toDTO(repositoryRole.save(MapStruct.MAPPER.toObject(updated)));
    }
    public DTOResponseRole delete(UUID id){
        Role object = repositoryRole.findById(id).orElse(null);
        repositoryRole.deleteById(id);
        return MapStruct.MAPPER.toDTO(object);
    }
    public void delete() {
        repositoryRole.deleteAll();
    }
    public Role findByName(String role) { return  repositoryRole.findByName(role); }

    @Override
    public boolean existsByNameIgnoreCase(String value) {
        return false;
    }
}