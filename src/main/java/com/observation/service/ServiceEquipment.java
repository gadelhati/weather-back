package com.observation.service;

import com.observation.persistence.MapStruct;
import com.observation.persistence.model.Equipment;
import com.observation.persistence.payload.request.DTORequestEquipment;
import com.observation.persistence.payload.response.DTOResponseEquipment;
import com.observation.persistence.repository.RepositoryEquipment;
import com.observation.persistence.repository.RepositoryEquipmentPage;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service @RequiredArgsConstructor
public class ServiceEquipment implements ServiceInterface<DTOResponseEquipment, DTORequestEquipment> {

    private final RepositoryEquipment repositoryEquipment;
    private final RepositoryEquipmentPage repositoryEquipmentPage;

    public DTOResponseEquipment create(DTORequestEquipment created){
        return MapStruct.MAPPER.toDTO(repositoryEquipment.save(MapStruct.MAPPER.toObject(created)));
    }
    public Page<DTOResponseEquipment> retrieve(Pageable pageable, String key, String value){
        switch (key) {
            case "id": {
                return repositoryEquipmentPage.findByIdOrderByIdAsc(pageable, UUID.fromString(value)).map(MapStruct.MAPPER::toDTO);
            }
            default: {
                return repositoryEquipmentPage.findAll(pageable).map(MapStruct.MAPPER::toDTO);
            }
        }
    }
    public DTOResponseEquipment update(UUID id, DTORequestEquipment updated){
        return MapStruct.MAPPER.toDTO(repositoryEquipment.save(MapStruct.MAPPER.toObject(updated)));
    }
    public DTOResponseEquipment delete(UUID id){
        Equipment object = repositoryEquipment.findById(id).orElse(null);
        repositoryEquipment.deleteById(id);
        return MapStruct.MAPPER.toDTO(object);
    }
    public void delete() {
        repositoryEquipment.deleteAll();
    }
    public boolean existsByName(String value) {
        return repositoryEquipment.existsByNameIgnoreCase(value);
    }
    public boolean existsByNameAndIdNot(String value, UUID id) {
        return repositoryEquipment.existsByNameIgnoreCaseAndIdNot(value, id);
    }
}