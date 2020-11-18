package com.codegym.repository;


import com.codegym.entity.CustomerType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeCustomerRepository extends JpaRepository<CustomerType, Long> {
}
