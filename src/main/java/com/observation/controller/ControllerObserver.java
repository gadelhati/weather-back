package com.observation.controller;

import com.observation.persistence.payload.request.DTORequestObserver;
import com.observation.persistence.payload.response.DTOResponseObserver;
import com.observation.service.ServiceObserver;
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

@RestController @RequestMapping("/observer") @RequiredArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
public class ControllerObserver implements ControllerInterface<DTOResponseObserver, DTORequestObserver> {

    private final ServiceObserver serviceObserver;

    @PostMapping("") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponseObserver> create(@RequestBody @Valid DTORequestObserver created){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/observer").toUriString());
        return ResponseEntity.created(uri).body(serviceObserver.create(created));
    }
    @GetMapping("") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<Page<DTOResponseObserver>> retrieve(@RequestParam(required = false) String filter, Pageable pageable){
        return ResponseEntity.ok().body(serviceObserver.retrieve(pageable, filter));
    }
    @PutMapping("") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponseObserver> update(@RequestBody @Valid DTORequestObserver updated){
        return ResponseEntity.accepted().body(serviceObserver.update(updated.getId(), updated));
    }
    @DeleteMapping("/{id}") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponseObserver> delete(@PathVariable UUID id){
        return ResponseEntity.accepted().body(serviceObserver.delete(id));
    }
    @DeleteMapping("") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<HttpStatus> delete(){
        try {
            serviceObserver.delete();
            return new ResponseEntity<>(null, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(HttpStatus.BAD_REQUEST);
        }
    }
}