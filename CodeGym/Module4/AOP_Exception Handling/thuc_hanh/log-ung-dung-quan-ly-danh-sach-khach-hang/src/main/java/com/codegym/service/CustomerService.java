package com.codegym.service;

import com.codegym.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public interface CustomerService {
    List<Customer> findAll();

    Page<Customer> findAll(Pageable pageInfo);

    List<Customer> search(String keyword);

    Page<Customer> search(String keyword, Pageable pageInfo);

    Optional<Customer> findOne(Integer id);

    Customer save(Customer customer);

    List<Customer> save(List<Customer> customers);

    boolean exists(Integer id);

    List<Customer> findAll(List<Integer> ids);

    long count();

    void delete(Integer id);

    void delete(Customer customer);

    void delete(List<Customer> customers);

    void deleteAll();
}

