package com.observation.controller;

import com.observation.persistence.payload.request.DTORequestSurveying;
import com.observation.persistence.payload.response.DTOResponseSurveying;
import com.observation.service.ServiceSurveying;
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

@RestController @RequestMapping("/surveying") @RequiredArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
public class ControllerSurveying implements ControllerInterface<DTOResponseSurveying, DTORequestSurveying> {

    private final ServiceSurveying serviceSurveying;

    @PostMapping("") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponseSurveying> create(@RequestBody @Valid DTORequestSurveying created){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/surveying").toUriString());
        return ResponseEntity.created(uri).body(serviceSurveying.create(created));
    }
    @GetMapping("") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<Page<DTOResponseSurveying>> retrieve(@RequestParam(required = false) String filter, Pageable pageable){
        return ResponseEntity.ok().body(serviceSurveying.retrieve(pageable, filter));
    }
    @PutMapping("") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponseSurveying> update(@RequestBody @Valid DTORequestSurveying updated){
        return ResponseEntity.accepted().body(serviceSurveying.update(updated.getId(), updated));
    }
    @DeleteMapping("/{id}") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponseSurveying> delete(@PathVariable UUID id){
        return ResponseEntity.accepted().body(serviceSurveying.delete(id));
    }
    @DeleteMapping("") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<HttpStatus> delete(){
        try {
            serviceSurveying.delete();
            return new ResponseEntity<>(null, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(HttpStatus.BAD_REQUEST);
        }
    }
}