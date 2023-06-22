package com.observation.controller;

import com.observation.persistence.payload.request.DTORequestManufacturer;
import com.observation.persistence.payload.response.DTOResponseManufacturer;
import com.observation.service.ServiceManufacturer;
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

@RestController @RequestMapping("/manufacturer") @RequiredArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
public class ControllerManufacturer implements ControllerInterface<DTOResponseManufacturer, DTORequestManufacturer> {

    private final ServiceManufacturer serviceManufacturer;

    @PostMapping("") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponseManufacturer> create(@RequestBody @Valid DTORequestManufacturer created){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/manufacturer").toUriString());
        return ResponseEntity.created(uri).body(serviceManufacturer.create(created));
    }
    @GetMapping("") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<Page<DTOResponseManufacturer>> retrieve(@RequestParam(value = "key", required = false) String key, @RequestParam(value = "value", required = false) String value, Pageable pageable){
        return ResponseEntity.ok().body(serviceManufacturer.retrieve(pageable, key, value));
    }
    @PutMapping("") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponseManufacturer> update(@RequestBody @Valid DTORequestManufacturer updated){
        return ResponseEntity.accepted().body(serviceManufacturer.update(updated.getId(), updated));
    }
    @DeleteMapping("/{id}") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponseManufacturer> delete(@PathVariable UUID id){
        return ResponseEntity.accepted().body(serviceManufacturer.delete(id));
    }
    @DeleteMapping("") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<HttpStatus> delete(){
        try {
            serviceManufacturer.delete();
            return new ResponseEntity<>(null, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(HttpStatus.BAD_REQUEST);
        }
    }
}