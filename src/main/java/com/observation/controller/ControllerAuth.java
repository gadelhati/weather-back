package com.observation.controller;

import com.observation.persistence.payload.request.DTORequestAuth;
import com.observation.persistence.payload.response.DTOResponseAuth;
import com.observation.service.ServiceAuth;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController @RequestMapping("/auth") @RequiredArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
public class ControllerAuth {

    private final ServiceAuth serviceAuth;

    @PostMapping("")
    public ResponseEntity<DTOResponseAuth> login(@RequestBody @Valid DTORequestAuth value){
        return ResponseEntity.accepted().body(serviceAuth.login(value));
    }
}