package com.codegym.thi.service.impl;


import com.codegym.thi.entity.TypeProduct;
import com.codegym.thi.repository.TypeProductRepository;
import com.codegym.thi.service.TypeProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeProductServiceImpl implements TypeProductService {
    @Autowired
    private TypeProductRepository typeProductRepository;


    @Override
    public List<TypeProduct> findAll() {
        return this.typeProductRepository.findAll();
    }
}
