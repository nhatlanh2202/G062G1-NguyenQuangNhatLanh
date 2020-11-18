package com.codegym.service.impl;


import com.codegym.entity.Customer;
import com.codegym.repository.CustomerRepository;
import com.codegym.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;


//    @Override
//    public Page<Customer> findAll() {
//        return this.customerRepository.findAll();
//    }


    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return this.customerRepository.findAll(pageable);
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public Customer findById(String id) {
        return this.customerRepository.findById(id).orElse(null);
    }

    @Override
    public void remove(String id) {
        customerRepository.deleteById(id);
    }

    @Override
    public Page<Customer> findAllByNameContaining(String name, Pageable pageable) {
        return this.customerRepository.findAllByNameContaining(name,pageable);
    }

    @Override
    public Page<Customer> findAllByAddressContaining(String address, Pageable pageable) {
        return this.customerRepository.findAllByAddressContaining(address, pageable);
    }

    @Override
    public Page<Customer> findAllByEmailContaining(String email, Pageable pageable) {
        return this.customerRepository.findAllByEmailContaining(email, pageable);
    }

    @Override
    public Page<Customer> findAllByNameContainingAndAddressContaining(String name, String address, Pageable pageable) {
        return this.customerRepository.findAllByNameContainingAndAddressContaining(name,address, pageable);
    }

    @Override
    public Page<Customer> findAllByNameContainingAndEmailContaining(String name, String email, Pageable pageable) {
        return this.customerRepository.findAllByNameContainingAndEmailContaining(name, email, pageable);
    }

    @Override
    public Page<Customer> findAllByAddressContainingAndEmailContaining(String address, String email, Pageable pageable) {
        return this.customerRepository.findAllByAddressContainingAndEmailContaining(address, email, pageable);
    }

    @Override
    public Page<Customer> findAllByNameContainingAndAddressContainingAndEmailContaining(String name, String address, String email, Pageable pageable) {
        return this.customerRepository.findAllByNameContainingAndAddressContainingAndEmailContaining(name,address,email,pageable);
    }
}
