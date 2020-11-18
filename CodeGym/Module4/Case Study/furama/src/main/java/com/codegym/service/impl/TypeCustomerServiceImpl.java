package com.codegym.service.impl;


import com.codegym.entity.CustomerType;
import com.codegym.repository.TypeCustomerRepository;
import com.codegym.service.TypeCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeCustomerServiceImpl implements TypeCustomerService {

    @Autowired
    private TypeCustomerRepository typeCustomerRepository;


    @Override
    public List<CustomerType> findAll() {
        return typeCustomerRepository.findAll();
    }
}
