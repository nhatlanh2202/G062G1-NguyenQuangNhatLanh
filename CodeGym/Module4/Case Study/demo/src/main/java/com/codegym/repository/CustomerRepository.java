package com.codegym.repository;


import com.codegym.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface CustomerRepository extends JpaRepository<Customer, String> {
    @Query(value = "select * from customer where name like %:keyword% or address like %:keyword% or phone_number like %:keyword%",nativeQuery = true)

    Page<Customer> findAllByAll(@Param("keyword") String keyword, Pageable pageable);
}
