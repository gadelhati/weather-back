package com.observation.service;

import com.observation.persistence.MapStruct;
import com.observation.persistence.model.SynopticObservation;
import com.observation.persistence.model.SynopticObservationId;
import com.observation.persistence.payload.request.DTORequestSynopticObservation;
import com.observation.persistence.payload.response.DTOResponseSynopticObservation;
import com.observation.persistence.payload.response.DTOResponseSynopticObservationHistoric;
import com.observation.persistence.payload.response.DTOResponseSynopticObservationHistoricOffShore;
import com.observation.persistence.payload.response.DTOResponseSynopticObservationHistoricOnShore;
import com.observation.persistence.repository.*;
import jakarta.validation.ConstraintViolation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.ZoneId;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service @RequiredArgsConstructor
public class ServiceSynopticObservation {

    private final RepositorySynopticObservation repositorySynopticObservation;
    private final RepositoryStationOffShore repositoryStationOffShore;
    private final RepositoryObserver repositoryObserver;
    private final RepositorySynopticObservationPage repositorySynopticObservationPage;
    private final RepositorySynopticObservationHistoricPage repositorySynopticObservationHistoricPage;
    private final RepositorySynopticObservationHistoricPageOffShore repositorySynopticObservationHistoricPageOffShore;
    private final RepositorySynopticObservationHistoricPageOnShore repositorySynopticObservationHistoricPageOnShore;

    public DTOResponseSynopticObservation create(DTORequestSynopticObservation created){
        return MapStruct.MAPPER.toDTO(repositorySynopticObservation.save(MapStruct.MAPPER.toObject(created)));
    }
    public List<DTOResponseSynopticObservation> create(List<DTORequestSynopticObservation> createds){
        List<DTOResponseSynopticObservation> list = new ArrayList<>();
        Set<ConstraintViolation<DTORequestSynopticObservation>> violations = new HashSet<>();
        for(DTORequestSynopticObservation created : createds){
            created.setDateObservation(created.getDataObservacao().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime().withHour(Integer.parseInt(created.getGg())));
            created.setDdddddd(created.getEstacao());
//            created.setObserverName(created.getObservador());
            created.setMimi(created.getAabbxx().substring(0,2));
            created.setMjmj("XX");
            repositorySynopticObservation.save(MapStruct.MAPPER.toObject(created));
            list.add(MapStruct.MAPPER.toDTO(MapStruct.MAPPER.toObject(created)));
        }
        return list;
    }
    public List<DTOResponseSynopticObservation> retrieve(List<SynopticObservation> list){
        return list.stream().map(value -> MapStruct.MAPPER.toDTO(value)).collect(Collectors.toList());
    }
    public DTOResponseSynopticObservation retrieve(SynopticObservationId source){
        return MapStruct.MAPPER.toDTO(repositorySynopticObservation.findById(source).orElseGet(null));
    }
    public List<DTOResponseSynopticObservation> retrieve(){
        return retrieve(repositorySynopticObservation.findAll());
    }
    public Page<DTOResponseSynopticObservation> retrieve(Pageable pageable, String filter){
//        switch (pageable.getSort().toString().substring(0, pageable.getSort().toString().length() - 5)) {
//            case "id": {
//                return repositorySynopticObservationPage.findByIdOrderByIdAsc(pageable, UUID.fromString(filter)).map(MapStruct.MAPPER::toDTO);
//            }
//            case "name": {
//                return repositorySynopticObservationPage.findByNameContainingIgnoreCaseOrderByNameAsc(pageable, filter).map(MapStruct.MAPPER::toDTO);
//            }
//            default: {
                return repositorySynopticObservationPage.findAll(pageable).map(MapStruct.MAPPER::toDTO);
//            }
//        }
    }
    public Page<DTOResponseSynopticObservationHistoric> retrieveHistoric(Pageable pageable, String filter){
        return repositorySynopticObservationHistoricPage.findAll(pageable).map(MapStruct.MAPPER::toDTO);
    }
    public Page<DTOResponseSynopticObservationHistoricOffShore> retrieveHistoricOffShore(Pageable pageable, String filter){
        return repositorySynopticObservationHistoricPageOffShore.findAll(pageable).map(MapStruct.MAPPER::toDTO);
    }
    public Page<DTOResponseSynopticObservationHistoricOnShore> retrieveHistoricOnShore(Pageable pageable, String filter){
        return repositorySynopticObservationHistoricPageOnShore.findAll(pageable).map(MapStruct.MAPPER::toDTO);
    }
//    public Geometry wktToGeometry(String wellKnownText) throws ParseException {
//        return new WKTReader().read(wellKnownText);
//    }
    public DTOResponseSynopticObservation update(DTORequestSynopticObservation updated) {
        updated.setDateObservation(updated.getDataObservacao().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime().withHour(Integer.parseInt(updated.getGg())));
        updated.setDdddddd(updated.getEstacao());
        return MapStruct.MAPPER.toDTO(repositorySynopticObservation.save(MapStruct.MAPPER.toObject(updated)));
    }
    public DTOResponseSynopticObservation delete(SynopticObservationId synopticObservationId){
        repositorySynopticObservation.deleteById(synopticObservationId);
        return MapStruct.MAPPER.toDTO(repositorySynopticObservation.findById(synopticObservationId).orElse(null));
    }
    public void delete() {
        repositorySynopticObservation.deleteAll();
    };

//    public boolean isEstacaoValid(String value) {
//        return repository.existsByEstacao(value);
//    }
//    public List<DTOResponseObservation> retrieveByEstacao(String source){
//        final List<DTOResponseObservation> list = new ArrayList<>();
//        for (Observation observation : repository.findByEstacaoContainingIgnoreCaseOrderByEstacaoAsc(source)) {
//            list.add(DTOResponseObservation.toDTO(observation));
//        }
//        return list;
//    }
}