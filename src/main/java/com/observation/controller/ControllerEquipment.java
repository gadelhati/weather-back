package com.observation.controller;

import com.observation.persistence.payload.request.DTORequestEquipment;
import com.observation.persistence.payload.response.DTOResponseEquipment;
import com.observation.service.ServiceEquipment;
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

@RestController @RequestMapping("/equipment") @RequiredArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
public class ControllerEquipment implements ControllerInterface<DTOResponseEquipment, DTORequestEquipment> {

    private final ServiceEquipment serviceEquipment;

    @PostMapping("") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponseEquipment> create(@RequestBody @Valid DTORequestEquipment created){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/equipment").toUriString());
        return ResponseEntity.created(uri).body(serviceEquipment.create(created));
    }
    @GetMapping("") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<Page<DTOResponseEquipment>> retrieve(@RequestParam(value = "key", required = false) String key, @RequestParam(value = "value", required = false) String value, Pageable pageable){
        return ResponseEntity.ok().body(serviceEquipment.retrieve(pageable, key, value));
    }
    @PutMapping("") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponseEquipment> update(@RequestBody @Valid DTORequestEquipment updated){
        return ResponseEntity.accepted().body(serviceEquipment.update(updated.getId(), updated));
    }
    @DeleteMapping("/{id}") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponseEquipment> delete(@PathVariable UUID id){
        return ResponseEntity.accepted().body(serviceEquipment.delete(id));
    }
    @DeleteMapping("") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<HttpStatus> delete(){
        try {
            serviceEquipment.delete();
            return new ResponseEntity<>(null, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(HttpStatus.BAD_REQUEST);
        }
    }
}