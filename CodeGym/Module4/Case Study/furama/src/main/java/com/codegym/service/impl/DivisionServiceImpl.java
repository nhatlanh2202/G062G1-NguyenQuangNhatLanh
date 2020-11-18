package com.codegym.service.impl;


import com.codegym.entity.Division;
import com.codegym.repository.DivisionRepository;
import com.codegym.service.DivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DivisionServiceImpl implements DivisionService {
    @Autowired
    private DivisionRepository divisionRepository;


    @Override
    public List<Division> findAll() {
        return this.divisionRepository.findAll();
    }
}
