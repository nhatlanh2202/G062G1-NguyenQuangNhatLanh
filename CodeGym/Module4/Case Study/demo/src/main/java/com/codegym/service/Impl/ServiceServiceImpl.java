package com.codegym.service.Impl;


import com.codegym.entity.Services;
import com.codegym.repository.ServiceRepository;
import com.codegym.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ServiceServiceImpl implements ServiceService {
    @Autowired
    private ServiceRepository serviceRepository;


    @Override
    public Page<Services> findAll(String search, Pageable pageable) {
        return this.serviceRepository.findAllByAll(search, pageable);
    }

    @Override
    public List<Services> findAll() {
        return this.serviceRepository.findAll();
    }

    @Override
    public void save(Services services) {
        this.serviceRepository.save(services);
    }

    @Override
    public Services findById(String id) {
        return this.serviceRepository.findById(id).orElse(null);
    }

    @Override
    public void remove(String id) {
        this.serviceRepository.deleteById(id);
    }
}
