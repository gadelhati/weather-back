package com.observation.controller;

import com.observation.persistence.payload.request.DTORequestHarbor;
import com.observation.persistence.payload.response.DTOResponseHarbor;
import com.observation.service.ServiceHarbor;
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

@RestController @RequestMapping("/harbor") @RequiredArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
public class ControllerHarbor implements ControllerInterface<DTOResponseHarbor, DTORequestHarbor> {

    private final ServiceHarbor serviceHarbor;

    @PostMapping("") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponseHarbor> create(@RequestBody @Valid DTORequestHarbor created){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/harbor").toUriString());
        return ResponseEntity.created(uri).body(serviceHarbor.create(created));
    }
    @GetMapping("") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<Page<DTOResponseHarbor>> retrieve(@RequestParam(value = "key", required = false) String key, @RequestParam(value = "value", required = false) String value, Pageable pageable){
        return ResponseEntity.ok().body(serviceHarbor.retrieve(pageable, key, value));
    }
    @PutMapping("") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponseHarbor> update(@RequestBody @Valid DTORequestHarbor updated){
        return ResponseEntity.accepted().body(serviceHarbor.update(updated.getId(), updated));
    }
    @DeleteMapping("/{id}") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponseHarbor> delete(@PathVariable UUID id){
        return ResponseEntity.accepted().body(serviceHarbor.delete(id));
    }
    @DeleteMapping("") @PreAuthorize("hasAnyRole('MODERATOR', 'ADMIN')")
    public ResponseEntity<HttpStatus> delete(){
        try {
            serviceHarbor.delete();
            return new ResponseEntity<>(null, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(HttpStatus.BAD_REQUEST);
        }
    }
}