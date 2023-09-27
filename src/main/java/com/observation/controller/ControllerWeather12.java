package com.observation.controller;

import com.observation.persistence.payload.request.DTORequestWeather12;
import com.observation.persistence.payload.response.DTOResponseWeather12;
import com.observation.service.ServiceWeather12;
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

@RestController @RequestMapping("/weather12") @RequiredArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
public class ControllerWeather12 implements ControllerInterface<DTOResponseWeather12, DTORequestWeather12> {

    private final ServiceWeather12 serviceWeather12;

    @PostMapping("") @PreAuthorize("hasAnyWeather12('MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponseWeather12> create(@RequestBody @Valid DTORequestWeather12 created){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/role").toUriString());
        return ResponseEntity.created(uri).body(serviceWeather12.create(created));
    }
    @GetMapping("")
    public ResponseEntity<Page<DTOResponseWeather12>> retrieve(@RequestParam(name = "key", defaultValue = "", required = false) String key, @RequestParam(name="value", defaultValue = "", required = false) String value, Pageable pageable){
        return ResponseEntity.ok().body(serviceWeather12.retrieve(pageable, key, value));
    }
    @PutMapping("") @PreAuthorize("hasAnyWeather12('MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponseWeather12> update(@RequestBody @Valid DTORequestWeather12 updated){
        return ResponseEntity.accepted().body(serviceWeather12.update(updated.getId(), updated));
    }
    @DeleteMapping("/{id}") @PreAuthorize("hasAnyWeather12('MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponseWeather12> delete(@PathVariable UUID id){
        return ResponseEntity.accepted().body(serviceWeather12.delete(id));
    }
    @DeleteMapping("") @PreAuthorize("hasAnyWeather12('MODERATOR', 'ADMIN')")
    public ResponseEntity<HttpStatus> delete(){
        try {
            serviceWeather12.delete();
            return new ResponseEntity<>(null, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(HttpStatus.BAD_REQUEST);
        }
    }
}