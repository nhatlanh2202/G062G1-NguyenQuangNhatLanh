package com.codegym.repository;


import com.codegym.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface CustomerRepository extends JpaRepository<Customer, String> {
    Page<Customer> findAll(Pageable pageable);

    Page<Customer> findAllByNameContaining(String name, Pageable pageable);

    Page<Customer> findAllByAddressContaining(String address, Pageable pageable);

    Page<Customer> findAllByEmailContaining(String email, Pageable pageable);

    Page<Customer> findAllByNameContainingAndAddressContaining(String name, String address, Pageable pageable);

    Page<Customer> findAllByNameContainingAndEmailContaining(String name, String email, Pageable pageable);

    Page<Customer> findAllByAddressContainingAndEmailContaining(String address, String email, Pageable pageable);

    Page<Customer> findAllByNameContainingAndAddressContainingAndEmailContaining(String name, String address, String email, Pageable pageable);
}
