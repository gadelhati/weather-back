package com.observation.controller;

import com.observation.persistence.payload.request.DTORequestStationCategory;
import com.observation.persistence.payload.response.DTOResponseStationCategory;
import com.observation.service.ServiceStationCategory;
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

@RestController @RequestMapping("/stationCategory") @RequiredArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
public class ControllerStationCategory implements ControllerInterface<DTOResponseStationCategory, DTORequestStationCategory> {

    private final ServiceStationCategory serviceStationCategory;

    @PostMapping("") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponseStationCategory> create(@RequestBody @Valid DTORequestStationCategory created){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/stationCategory").toUriString());
        return ResponseEntity.created(uri).body(serviceStationCategory.create(created));
    }
    @GetMapping("") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<Page<DTOResponseStationCategory>> retrieve(@RequestParam(value = "key", required = false) String key, @RequestParam(value = "value", required = false) String value, Pageable pageable){
        return ResponseEntity.ok().body(serviceStationCategory.retrieve(pageable, key, value));
    }
    @PutMapping("") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponseStationCategory> update(@RequestBody @Valid DTORequestStationCategory updated){
        return ResponseEntity.accepted().body(serviceStationCategory.update(updated.getId(), updated));
    }
    @DeleteMapping("/{id}") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponseStationCategory> delete(@PathVariable UUID id){
        return ResponseEntity.accepted().body(serviceStationCategory.delete(id));
    }
    @DeleteMapping("") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<HttpStatus> delete(){
        try {
            serviceStationCategory.delete();
            return new ResponseEntity<>(null, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(HttpStatus.BAD_REQUEST);
        }
    }
}