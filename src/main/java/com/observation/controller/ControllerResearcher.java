package com.observation.controller;

import com.observation.persistence.payload.request.DTORequestResearcher;
import com.observation.persistence.payload.response.DTOResponseResearcher;
import com.observation.service.ServiceResearcher;
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

@RestController @RequestMapping("/researcher") @RequiredArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
public class ControllerResearcher implements ControllerInterface<DTOResponseResearcher, DTORequestResearcher> {

    private final ServiceResearcher serviceResearcher;

    @PostMapping("") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponseResearcher> create(@RequestBody @Valid DTORequestResearcher created){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/researcher").toUriString());
        return ResponseEntity.created(uri).body(serviceResearcher.create(created));
    }
    @GetMapping("") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<Page<DTOResponseResearcher>> retrieve(@RequestParam(value = "key", required = false) String key, @RequestParam(value = "value", required = false) String value, Pageable pageable){
        return ResponseEntity.ok().body(serviceResearcher.retrieve(pageable, key, value));
    }
    @PutMapping("") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponseResearcher> update(@RequestBody @Valid DTORequestResearcher updated){
        return ResponseEntity.accepted().body(serviceResearcher.update(updated.getId(), updated));
    }
    @DeleteMapping("/{id}") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponseResearcher> delete(@PathVariable UUID id){
        return ResponseEntity.accepted().body(serviceResearcher.delete(id));
    }
    @DeleteMapping("") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<HttpStatus> delete(){
        try {
            serviceResearcher.delete();
            return new ResponseEntity<>(null, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(HttpStatus.BAD_REQUEST);
        }
    }
}