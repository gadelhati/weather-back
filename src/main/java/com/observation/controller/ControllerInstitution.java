package com.observation.controller;

import com.observation.persistence.payload.request.DTORequestInstitution;
import com.observation.persistence.payload.response.DTOResponseInstitution;
import com.observation.service.ServiceInstitution;
import javax.validation.Valid;
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

@RestController @RequestMapping("/institution") @RequiredArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
public class ControllerInstitution implements ControllerInterface<DTOResponseInstitution, DTORequestInstitution> {

    private final ServiceInstitution serviceInstitution;

    @PostMapping("") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponseInstitution> create(@RequestBody @Valid DTORequestInstitution created){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/institution").toUriString());
        return ResponseEntity.created(uri).body(serviceInstitution.create(created));
    }
    @GetMapping("") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<Page<DTOResponseInstitution>> retrieve(@RequestParam(value = "key", required = false) String key, @RequestParam(value = "value", required = false) String value, Pageable pageable){
        return ResponseEntity.ok().body(serviceInstitution.retrieve(pageable, key, value));
    }
    @PutMapping("") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponseInstitution> update(@RequestBody @Valid DTORequestInstitution updated){
        return ResponseEntity.accepted().body(serviceInstitution.update(updated.getId(), updated));
    }
    @DeleteMapping("/{id}") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponseInstitution> delete(@PathVariable UUID id){
        return ResponseEntity.accepted().body(serviceInstitution.delete(id));
    }
    @DeleteMapping("") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<HttpStatus> delete(){
        try {
            serviceInstitution.delete();
            return new ResponseEntity<>(null, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(HttpStatus.BAD_REQUEST);
        }
    }
}