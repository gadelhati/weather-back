package com.observation.controller;

import com.observation.persistence.payload.request.DTORequestAuth;
import com.observation.persistence.payload.response.DTOResponseAuth;
import com.observation.service.ServiceAuth;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController @RequestMapping("/auth") @RequiredArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
public class ControllerAuth {

    private final ServiceAuth serviceAuth;

    @PostMapping("/login")
    public ResponseEntity<DTOResponseAuth> login(@RequestBody @Valid DTORequestAuth value){
        return ResponseEntity.accepted().body(serviceAuth.login(value));
    }
    @PostMapping("/logout")
    public ResponseEntity<HttpStatus> logout(@Valid @RequestBody DTORequestAuth dtoRequestAuth) {
        try {
            serviceAuth.logout(dtoRequestAuth);
            return new ResponseEntity<>(null, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(HttpStatus.BAD_REQUEST);
        }
    }
}