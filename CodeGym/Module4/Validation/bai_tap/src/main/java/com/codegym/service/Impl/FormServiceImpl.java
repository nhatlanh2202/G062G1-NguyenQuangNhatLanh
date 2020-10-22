package com.codegym.service.Impl;

import com.codegym.entity.RegisterForm;
import com.codegym.repository.FormRepository;
import com.codegym.service.FormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FormServiceImpl implements FormService {

    @Autowired
    private FormRepository formRepository;


//    @Override
//    public List<RegisterForm> findAll() {
//        return this.formRepository.findAll();
//    }

    @Override
    public void save(RegisterForm registerForm) {
        formRepository.save(registerForm);
    }
}
