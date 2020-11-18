package com.codegym.service.impl;

import com.codegym.entity.AppUser;
import com.codegym.entity.Employee;
import com.codegym.repository.DivisionRepository;
import com.codegym.repository.EmployeeRepository;
import com.codegym.repository.PositionRepository;
import com.codegym.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;


    @Override
    public Page<Employee> findAll(String search, Pageable pageable) {
        return this.employeeRepository.findAllByAll(search, pageable);
    }

    @Override
    public List<Employee> findAll() {
        return this.employeeRepository.findAll();
    }

    @Override
    public void save(Employee employee) {
        this.employeeRepository.save(employee);
    }

    @Override
    public Employee findById(String id) {
        return this.employeeRepository.findById(id).orElse(null);
    }

    @Override
    public void remove(String id) {
        this.employeeRepository.deleteById(id);
    }

}
