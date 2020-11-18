package com.codegym.service;


import com.codegym.entity.Services;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ServiceService {
    Page<Services> findAll(String search, Pageable pageable);

    List<Services> findAll();

    void save(Services services);

    Services findById(String id);

    void remove(String id);
}
