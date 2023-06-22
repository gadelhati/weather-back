package com.observation.controller;

import com.observation.persistence.payload.request.DTORequestPlatform;
import com.observation.persistence.payload.response.DTOResponsePlatform;
import com.observation.service.ServicePlatform;
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

@RestController @RequestMapping("/platform") @RequiredArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
public class ControllerPlatform implements ControllerInterface<DTOResponsePlatform, DTORequestPlatform> {

    private final ServicePlatform servicePlatform;

    @PostMapping("") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponsePlatform> create(@RequestBody @Valid DTORequestPlatform created){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/platform").toUriString());
        return ResponseEntity.created(uri).body(servicePlatform.create(created));
    }
    @GetMapping("") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<Page<DTOResponsePlatform>> retrieve(@RequestParam(value = "key", required = false) String key, @RequestParam(value = "value", required = false) String value, Pageable pageable){
        return ResponseEntity.ok().body(servicePlatform.retrieve(pageable, key, value));
    }
    @PutMapping("") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponsePlatform> update(@RequestBody @Valid DTORequestPlatform updated){
        return ResponseEntity.accepted().body(servicePlatform.update(updated.getId(), updated));
    }
    @DeleteMapping("/{id}") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponsePlatform> delete(@PathVariable UUID id){
        return ResponseEntity.accepted().body(servicePlatform.delete(id));
    }
    @DeleteMapping("") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<HttpStatus> delete(){
        try {
            servicePlatform.delete();
            return new ResponseEntity<>(null, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(HttpStatus.BAD_REQUEST);
        }
    }
}