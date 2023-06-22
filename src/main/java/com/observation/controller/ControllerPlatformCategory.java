package com.observation.controller;

import com.observation.persistence.payload.request.DTORequestPlatformCategory;
import com.observation.persistence.payload.response.DTOResponsePlatformCategory;
import com.observation.service.ServicePlatformCategory;
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

@RestController @RequestMapping("/platformCategory") @RequiredArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
public class ControllerPlatformCategory implements ControllerInterface<DTOResponsePlatformCategory, DTORequestPlatformCategory> {

    private final ServicePlatformCategory servicePlatformCategory;

    @PostMapping("") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponsePlatformCategory> create(@RequestBody @Valid DTORequestPlatformCategory created){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/platformCategory").toUriString());
        return ResponseEntity.created(uri).body(servicePlatformCategory.create(created));
    }
    @GetMapping("") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<Page<DTOResponsePlatformCategory>> retrieve(@RequestParam(value = "key", required = false) String key, @RequestParam(value = "value", required = false) String value, Pageable pageable){
        return ResponseEntity.ok().body(servicePlatformCategory.retrieve(pageable, key, value));
    }
    @PutMapping("") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponsePlatformCategory> update(@RequestBody @Valid DTORequestPlatformCategory updated){
        return ResponseEntity.accepted().body(servicePlatformCategory.update(updated.getId(), updated));
    }
    @DeleteMapping("/{id}") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponsePlatformCategory> delete(@PathVariable UUID id){
        return ResponseEntity.accepted().body(servicePlatformCategory.delete(id));
    }
    @DeleteMapping("") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<HttpStatus> delete(){
        try {
            servicePlatformCategory.delete();
            return new ResponseEntity<>(null, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(HttpStatus.BAD_REQUEST);
        }
    }
}