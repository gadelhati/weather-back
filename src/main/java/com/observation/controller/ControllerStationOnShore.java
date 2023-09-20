package com.observation.controller;

import com.observation.persistence.payload.request.DTORequestStationOnShore;
import com.observation.persistence.payload.response.DTOResponseStationHistoricOnShore;
import com.observation.persistence.payload.response.DTOResponseStationOnShore;
import com.observation.service.ServiceStationOnShore;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.UUID;

@RestController @RequestMapping("/stationOnShore") @RequiredArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
public class ControllerStationOnShore implements ControllerInterface<DTOResponseStationOnShore, DTORequestStationOnShore> {

    private final ServiceStationOnShore serviceStationOnShore;

    @PostMapping("") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponseStationOnShore> create(@RequestBody @Valid DTORequestStationOnShore created){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/stationOnShore").toUriString());
        return ResponseEntity.created(uri).body(serviceStationOnShore.create(created));
    }
    @GetMapping("") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<Page<DTOResponseStationOnShore>> retrieve(@RequestParam(name = "key", defaultValue = "", required = false) String key, @RequestParam(name="value", defaultValue = "", required = false) String value, Pageable pageable){
        return ResponseEntity.ok().body(serviceStationOnShore.retrieve(pageable, key, value));
    }
    @GetMapping("/historic") @PreAuthorize("hasAnyRole('USER', 'MODERATOR', 'ADMIN')")
    public ResponseEntity<Page<DTOResponseStationHistoricOnShore>> retrieveHistoric(@RequestParam(name = "key", defaultValue = "", required = false) String key, @RequestParam(name="value", defaultValue = "", required = false) String value, Pageable pageable){
        return ResponseEntity.ok().body(serviceStationOnShore.retrieveHistoric(pageable, key, value));
    }
    @PutMapping("") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponseStationOnShore> update(@RequestBody @Valid DTORequestStationOnShore updated){
        return ResponseEntity.accepted().body(serviceStationOnShore.update(updated.getId(), updated));
    }
    @DeleteMapping("/{id}") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponseStationOnShore> delete(@PathVariable UUID id){
        return ResponseEntity.accepted().body(serviceStationOnShore.delete(id));
    }
    @DeleteMapping("") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<HttpStatus> delete(){
        try {
            serviceStationOnShore.delete();
            return new ResponseEntity<>(null, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(HttpStatus.BAD_REQUEST);
        }
    }
}