package com.codegym.service;

import com.codegym.entity.AppUser;
import com.codegym.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EmployeeService {
    Page<Employee> findAll(String search, Pageable pageable);

    List<Employee> findAll();

    void save(Employee employee);

    Employee findById(String id);

    void remove(String id);

}
