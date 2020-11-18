package com.codegym.service.Impl;

import com.codegym.entity.EducationDegree;
import com.codegym.repository.EducationRepository;
import com.codegym.service.EducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationServiceImpl implements EducationService {
    @Autowired
    private EducationRepository educationRepository;


    @Override
    public List<EducationDegree> findAll() {
        return this.educationRepository.findAll();
    }
}
