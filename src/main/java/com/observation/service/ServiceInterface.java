package com.observation.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface ServiceInterface<T, S, R> {
    public T create(S created);
    public T retrieve(UUID id);
    public List<T> retrieve();
    public Page<T> retrieve(Pageable pageable);
    public Page<T> retrieve(Pageable pageable, String source);
    public T update(UUID id, S updated);
    public T delete(UUID id);
    public void delete();
    public R findByName(String value);
    public boolean existsByNameIgnoreCase(String value);
}