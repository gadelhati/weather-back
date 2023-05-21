package com.observation.controller;

import com.observation.persistence.payload.request.DTORequestStationOffShore;
import com.observation.persistence.payload.response.DTOResponseStationOffShore;
import com.observation.service.ServiceStationOffShore;
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
import java.util.UUID;

@RestController @RequestMapping("/stationOffShore") @RequiredArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
public class ControllerStationOffShore implements ControllerInterface<DTOResponseStationOffShore, DTORequestStationOffShore> {

    private final ServiceStationOffShore serviceStationOffShore;

    @PostMapping("") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponseStationOffShore> create(@RequestBody @Valid DTORequestStationOffShore created){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/stationOffShore").toUriString());
        return ResponseEntity.created(uri).body(serviceStationOffShore.create(created));
    }
    @GetMapping("") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<Page<DTOResponseStationOffShore>> retrieve(@RequestParam(required = false) String filter, Pageable pageable){
        return ResponseEntity.ok().body(serviceStationOffShore.retrieve(pageable, filter));
    }
    @PutMapping("") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponseStationOffShore> update(@RequestBody @Valid DTORequestStationOffShore updated){
        return ResponseEntity.accepted().body(serviceStationOffShore.update(updated.getId(), updated));
    }
    @DeleteMapping("/{id}") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponseStationOffShore> delete(@PathVariable UUID id){
        return ResponseEntity.accepted().body(serviceStationOffShore.delete(id));
    }
    @DeleteMapping("") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<HttpStatus> delete(){
        try {
            serviceStationOffShore.delete();
            return new ResponseEntity<>(null, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(HttpStatus.BAD_REQUEST);
        }
    }
}