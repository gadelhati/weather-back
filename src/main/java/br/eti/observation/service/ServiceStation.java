package br.eti.observation.service;

import br.eti.observation.persistence.MapStruct;
import br.eti.observation.persistence.model.Station;
import br.eti.observation.persistence.payload.request.DTORequestStation;
import br.eti.observation.persistence.payload.response.DTOResponseStation;
import br.eti.observation.persistence.payload.response.DTOResponseStationHistoric;
import br.eti.observation.persistence.repository.RepositoryStation;
import br.eti.observation.persistence.repository.RepositoryStationHistoricPage;
import br.eti.observation.persistence.repository.RepositoryStationPage;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service @RequiredArgsConstructor
public class ServiceStation implements ServiceInterface<DTOResponseStation, DTORequestStation, Station> {

    private final RepositoryStation repositoryStation;
    private final RepositoryStationPage repositoryStationPage;
    private final RepositoryStationHistoricPage repositoryStationHistoricPage;

    public DTOResponseStation create(DTORequestStation created){
        return MapStruct.MAPPER.toDTO(repositoryStation.save(MapStruct.MAPPER.toObject(created)));
    }
    public DTOResponseStation retrieve(UUID id){
        return MapStruct.MAPPER.toDTO(repositoryStation.findById(id).orElse(null));
    }
    public List<DTOResponseStation> retrieve(){
        List<DTOResponseStation> list = new ArrayList<>();
        for(Station object: repositoryStation.findAll()) {
            list.add(MapStruct.MAPPER.toDTO(object));
        }
        return list;
    }

    @Override
    public Page<DTOResponseStation> retrieve(Pageable pageable) {
        return null;
    }

    //    public Page<DTOResponseStation> retrieve(Pageable pageable){
//        List<DTOResponseStation> list = new ArrayList<>();
//        for(Station object: repositoryStation.findAll()) {
//            list.add(MapStruct.MAPPER.toDTO(object));
//        }
//        return new PageImpl<DTOResponseStation>(list, pageable, list.size());
//    }
    public Page<DTOResponseStation> retrieve(Pageable pageable, String filter){
//        List<DTOResponseStation> list = repositoryStationPage.findAll(pageable).stream().map(object -> MapStruct.MAPPER.toDTO(object)).collect(Collectors.toList());
//        return new PageImpl<DTOResponseStation>(list, pageable, list.size());
        return repositoryStationPage.findAll(pageable).map(MapStruct.MAPPER::toDTO);
    }
    public Page<DTOResponseStationHistoric> retrieveHistoric(Pageable pageable, String filter){
        return repositoryStationHistoricPage.findAll(pageable).map(MapStruct.MAPPER::toDTO);
    }
//    @Override
    public Page<DTOResponseStation> retrievePage(Integer page, Integer size,/* String sort,*/ String value, String order){
        Pageable pageable = pageable = PageRequest.of(page, size);
//        if(order != null && order.equals("asc")) pageable = PageRequest.of(page, size, Sort.by(sort).ascending());
        if (value == null) {
            return repositoryStationPage.findAll(pageable).map(object -> MapStruct.MAPPER.toDTO(object));
        } else {
            return repositoryStationPage.findAll(pageable).map(object -> MapStruct.MAPPER.toDTO(object));
        }
    }
//    public Page<DTOResponseStation> retrieve(Pageable pageable, String source){
//        final List<DTOResponseStation> list = new ArrayList<>();
//        if (source == null) {
//            for (Station object : repositoryStation.findAll()) {
//                list.add(MapStruct.MAPPER.toDTO(object));
//            }
//        } else {
////            for (Station object : repositoryStation.findByComContainingIgnoreCaseOrderByComAsc(source)) {
////                list.add(DTOResponseStation.toDTO(object));
////            }
//        }
//        return new PageImpl<>(list, pageable, list.size());
//    }
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
    public Station findByName(String value) { return  null; }
    public boolean existsByNameIgnoreCase(String value) {
        return false;
    }
}