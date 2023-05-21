package com.observation.controller;

import com.observation.persistence.payload.request.DTORequestStation;
import com.observation.persistence.payload.response.DTOResponseStation;
import com.observation.service.ServiceStation;
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

@RestController @RequestMapping("/station") @RequiredArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
public class ControllerStation implements ControllerInterface<DTOResponseStation, DTORequestStation> {

    private final ServiceStation serviceStation;

    @PostMapping("") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponseStation> create(@RequestBody @Valid DTORequestStation created){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/station").toUriString());
        return ResponseEntity.created(uri).body(serviceStation.create(created));
    }
    @GetMapping("") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<Page<DTOResponseStation>> retrieve(@RequestParam(required = false) String filter, Pageable pageable){
        return ResponseEntity.ok().body(serviceStation.retrieve(pageable, filter));
    }
    @PutMapping("") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponseStation> update(@RequestBody @Valid DTORequestStation updated){
        return ResponseEntity.accepted().body(serviceStation.update(updated.getId(), updated));
    }
    @DeleteMapping("/{id}") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponseStation> delete(@PathVariable UUID id){
        return ResponseEntity.accepted().body(serviceStation.delete(id));
    }
    @DeleteMapping("") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<HttpStatus> delete(){
        try {
            serviceStation.delete();
            return new ResponseEntity<>(null, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(HttpStatus.BAD_REQUEST);
        }
    }
}