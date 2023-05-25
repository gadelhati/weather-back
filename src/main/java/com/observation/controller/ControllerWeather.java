package com.observation.controller;

import com.observation.persistence.model.WeatherId;
import com.observation.persistence.payload.request.DTORequestWeather;
import com.observation.persistence.payload.response.DTOResponseWeather;
import com.observation.persistence.payload.response.DTOResponseWeatherHistoric;
import com.observation.persistence.payload.response.DTOResponseWeatherHistoricOffShore;
import com.observation.persistence.payload.response.DTOResponseWeatherHistoricOnShore;
import com.observation.service.ServiceWeather;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.List;

@RestController @RequestMapping("/weather") @RequiredArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
public class ControllerWeather {

    private final ServiceWeather serviceWeather;

    @PostMapping("") @PreAuthorize("hasAnyRole('USER', 'MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponseWeather> create(@RequestBody @Valid DTORequestWeather created){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/synopticObservation").toUriString());
        return ResponseEntity.created(uri).body(serviceWeather.create(created));
    }
    @PostMapping("/createAll") @PreAuthorize("hasAnyRole('USER', 'MODERATOR', 'ADMIN')")
    public ResponseEntity<List<DTOResponseWeather>> create(@RequestBody @Valid List<DTORequestWeather> createds){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/synopticObservation/createAll").toUriString());
        return ResponseEntity.created(uri).body(serviceWeather.create(createds));
//        List<DTOResponseSynopticObservation> dtoResponseSynopticObservationsCreated = new ArrayList<>();
//        List<DTOResponseSynopticObservation> dtoResponseSynopticObservationsFailed = new ArrayList<>();
//        for(DTORequestSynopticObservation dtoRequestSynopticObservation : createds) {
//            try {
////                service.create(dtoRequestSynopticObservation);
//                create(dtoRequestSynopticObservation);
//                dtoResponseSynopticObservationsCreated.add(new DTOResponseSynopticObservation().toDTO(dtoRequestSynopticObservation.toObject()));
//            } catch (Exception e) {
//                dtoResponseSynopticObservationsFailed.add(new DTOResponseSynopticObservation().toDTO(dtoRequestSynopticObservation.toObject()));
//            }
//        }
//        if(!dtoResponseSynopticObservationsCreated.isEmpty()){
//            return new ResponseEntity<>(dtoResponseSynopticObservationsCreated, HttpStatus.CREATED);
//        } else {
//            return new ResponseEntity<>(dtoResponseSynopticObservationsFailed, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
    }
    @GetMapping("") @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<Page<DTOResponseWeather>> retrieve(@RequestParam(value = "filter", required = false) String filter, Pageable pageable){
        return ResponseEntity.ok().body(serviceWeather.retrieve(pageable, filter));
    }
    @GetMapping("/historic") @PreAuthorize("hasAnyRole('USER', 'MODERATOR', 'ADMIN')")
    public ResponseEntity<Page<DTOResponseWeatherHistoric>> retrieveHistoric(@RequestParam(value = "filter", required = false) String filter, Pageable pageable){
        return ResponseEntity.ok().body(serviceWeather.retrieveHistoric(pageable, filter));
    }
    @GetMapping("/historicOffShore") @PreAuthorize("hasAnyRole('USER', 'MODERATOR', 'ADMIN')")
    public ResponseEntity<Page<DTOResponseWeatherHistoricOffShore>> retrieveHistoricOffshore(@RequestParam(value = "filter", required = false) String filter, Pageable pageable){
        return ResponseEntity.ok().body(serviceWeather.retrieveHistoricOffShore(pageable, filter));
    }
    @GetMapping("/historicOnShore") @PreAuthorize("hasAnyRole('USER', 'MODERATOR', 'ADMIN')")
    public ResponseEntity<Page<DTOResponseWeatherHistoricOnShore>> retrieveHistoricOnShore(@RequestParam(value = "filter", required = false) String filter, Pageable pageable){
        return ResponseEntity.ok().body(serviceWeather.retrieveHistoricOnShore(pageable, filter));
    }
    //    @GetMapping(value = {"/{dateObservation}/{ii}/{iii}", "/{dateObservation}/{ddddddd}"}) @PreAuthorize("hasAnyRole('USER', 'MODERATOR', 'ADMIN')")
//    public ResponseEntity<DTOResponseSynopticObservation> retrieve(@PathVariable("dateObservation") LocalDateTime dateObservation, @PathVariable("ddddddd") String ddddddd, @PathVariable("ii") String ii, @PathVariable("iii") String iii){
//        return ResponseEntity.ok().body(serviceSynopticObservation.retrieve(new SynopticObservationId(dateObservation, ddddddd, ii, iii)));
//    }
    @PutMapping("") @PreAuthorize("hasAnyRole('USER', 'MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponseWeather> update(@RequestBody @Valid DTORequestWeather updated){
        return ResponseEntity.accepted().body(serviceWeather.update(new WeatherId(updated.getDateObservation(), updated.getDdddddd(), updated.getIi(), updated.getIii()), updated));
    }
    @DeleteMapping(value = {"/{dateObservation}/{ii}/{iii}", "/{dateObservation}/{ddddddd}"}) @PreAuthorize("hasAnyRole('USER', 'MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponseWeather> delete(@PathVariable("dateObservation") LocalDateTime dateObservation, @PathVariable("ddddddd") String ddddddd, @PathVariable("ii") String ii, @PathVariable("iii") String iii){
        return ResponseEntity.accepted().body(serviceWeather.delete(new WeatherId(dateObservation, ddddddd, ii, iii)));
    }
    @DeleteMapping("") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<HttpStatus> delete(){
        try {
            serviceWeather.delete();
            return new ResponseEntity<>(null, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}