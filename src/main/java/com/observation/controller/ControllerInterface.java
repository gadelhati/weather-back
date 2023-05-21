package com.observation.controller;

import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

public interface ControllerInterface<T, S> {
    ResponseEntity<T> create(@RequestBody @Valid S created);
    ResponseEntity<Page<T>> retrieve(@RequestParam("filter") String filter, Pageable pageable);
    ResponseEntity<T> update(@RequestBody @Valid S updated);
    ResponseEntity<T> delete(@PathVariable("id") UUID id);
    ResponseEntity<HttpStatus> delete();
}