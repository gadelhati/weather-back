package com.observation.controller;

import com.observation.persistence.MapStruct;
import com.observation.persistence.payload.request.DTORequestWeather;
import com.observation.persistence.payload.response.*;
import com.observation.service.ServiceWeather;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static com.observation.exception.validator.Validator.isNull;

@RestController @RequestMapping("/weather") @RequiredArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
@Validated
public class ControllerWeather {

    private final ServiceWeather serviceWeather;

    @PostMapping("") @PreAuthorize("hasAnyRole('USER', 'MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponseWeather> create(@RequestBody @Valid DTORequestWeather created){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/weather").toUriString());
        return ResponseEntity.created(uri).body(serviceWeather.create(created));
    }
    @PostMapping("/createAll") @PreAuthorize("hasAnyRole('USER', 'MODERATOR', 'ADMIN')")
    public ResponseEntity<List<DTOResponseWeather>> create(@RequestBody List<DTORequestWeather> createds){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/weather/createAll").toUriString());
//        return ResponseEntity.created(uri).body(serviceWeather.create(createds));
        List<DTOResponseWeather> dtoResponseWeathers = new ArrayList<>();
        List<DTOResponseWeather> dtoResponseSynopticObservationsFailed = new ArrayList<>();
        for(DTORequestWeather dtoRequestWeather : createds) {
            dtoRequestWeather.setDdddddd(dtoRequestWeather.getIi() == null && dtoRequestWeather.getIii() == null ? dtoRequestWeather.getEstacao() : dtoRequestWeather.getDdddddd());
            try {
//                service.create(dtoRequestWeather);
                dtoRequestWeather.setDateObservation(dtoRequestWeather.getDataObservacao() == null ? null : dtoRequestWeather.getDataObservacao().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime().withHour(Integer.parseInt(dtoRequestWeather.getGg())));
                if(//!isNull(dtoRequestWeather.getDataObservacao()) &&
                        !serviceWeather.existsByWeather(dtoRequestWeather.getDateObservation(), dtoRequestWeather.getGg(), dtoRequestWeather.getIi(), dtoRequestWeather.getIii()) &&
                        !serviceWeather.existsByWeather(dtoRequestWeather.getDateObservation(), dtoRequestWeather.getGg(), dtoRequestWeather.getDdddddd())
                ) {
                    create(dtoRequestWeather);
                    dtoResponseWeathers.add(MapStruct.MAPPER.toDTO(MapStruct.MAPPER.toObject(dtoRequestWeather)));
                }
            } catch (Exception e) {
                dtoResponseWeathers.add(null);
            }
        }
        if(!dtoResponseWeathers.isEmpty()){
            return ResponseEntity.ok().body(dtoResponseWeathers);
        } else {
            return ResponseEntity.badRequest().body(null);
        }
    }
    @GetMapping("/complete")
    public ResponseEntity<Page<DTOResponseWeather>> complete(@RequestParam(name = "key", defaultValue = "", required = false) String key, @RequestParam(name="value", defaultValue = "", required = false) String value, Pageable pageable){
        return ResponseEntity.ok().body(serviceWeather.retrieve(pageable, key, value));
    }
    @GetMapping("/abbreviated")
    public ResponseEntity<Page<DTOResponseWeatherAbbreviated>> abbreviated(@RequestParam(name = "key", defaultValue = "", required = false) String key, @RequestParam(name="value", defaultValue = "", required = false) String value, Pageable pageable){
        return ResponseEntity.ok().body(serviceWeather.abbreviated(pageable, key, value));
    }
    @GetMapping("/reduced")
    public ResponseEntity<Page<DTOResponseWeatherReduced>> reduced(@RequestParam(name = "key", defaultValue = "", required = false) String key, @RequestParam(name="value", defaultValue = "", required = false) String value, Pageable pageable){
        return ResponseEntity.ok().body(serviceWeather.reduced(pageable, key, value));
    }
    @GetMapping("/abbreviated/msg")
    public String abbreviatedMsg(@RequestParam(name="id", defaultValue = "id") UUID id){
        return serviceWeather.abbreviatedMsg(id);
    }
    @GetMapping("/reduced/msg")
    public String reducedMsg(@RequestParam(name="id", defaultValue = "id") UUID id){
        return serviceWeather.reducedMsg(id);
    }
    @GetMapping("")
    public ResponseEntity<Page<DTOResponseWeather>> retrieve(@RequestParam(name = "key", defaultValue = "", required = false) String key, @RequestParam(name="value", defaultValue = "", required = false) String value, Pageable pageable){
        return ResponseEntity.ok().body(serviceWeather.retrieve(pageable, key, value));
    }
    @GetMapping("/historic") @PreAuthorize("hasAnyRole('USER', 'MODERATOR', 'ADMIN')")
    public ResponseEntity<Page<DTOResponseWeatherHistoric>> retrieveHistoric(@RequestParam(name = "key", defaultValue = "", required = false) String key, @RequestParam(name="value", defaultValue = "", required = false) String value, Pageable pageable){
        return ResponseEntity.ok().body(serviceWeather.retrieveHistoric(pageable, key, value));
    }
    @GetMapping("OffShore/historic") @PreAuthorize("hasAnyRole('USER', 'MODERATOR', 'ADMIN')")
    public ResponseEntity<Page<DTOResponseWeatherHistoricOffShore>> retrieveHistoricOffshore(@RequestParam(name = "key", defaultValue = "", required = false) String key, @RequestParam(name="value", defaultValue = "", required = false) String value, Pageable pageable){
        return ResponseEntity.ok().body(serviceWeather.retrieveHistoricOffShore(pageable, key, value));
    }
    @GetMapping("OnShore/historic") @PreAuthorize("hasAnyRole('USER', 'MODERATOR', 'ADMIN')")
    public ResponseEntity<Page<DTOResponseWeatherHistoricOnShore>> retrieveHistoricOnShore(@RequestParam(name = "key", defaultValue = "", required = false) String key, @RequestParam(name="value", defaultValue = "", required = false) String value, Pageable pageable){
        return ResponseEntity.ok().body(serviceWeather.retrieveHistoricOnShore(pageable, key, value));
    }
    @PutMapping("") @PreAuthorize("hasAnyRole('USER', 'MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponseWeather> update(@RequestBody @Valid DTORequestWeather updated){
        return ResponseEntity.accepted().body(serviceWeather.update(updated.getId(), updated));
    }
    @DeleteMapping("/{id}") @PreAuthorize("hasAnyRole('USER', 'MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponseWeather> delete(@PathVariable @Valid UUID id){
        return ResponseEntity.accepted().body(serviceWeather.delete(id));
    }
//    @DeleteMapping("") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
//    public ResponseEntity<HttpStatus> delete(){
//        try {
//            serviceWeather.delete();
//            return new ResponseEntity<>(null, HttpStatus.ACCEPTED);
//        } catch (Exception e) {
//            return ResponseEntity.badRequest().body(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
}