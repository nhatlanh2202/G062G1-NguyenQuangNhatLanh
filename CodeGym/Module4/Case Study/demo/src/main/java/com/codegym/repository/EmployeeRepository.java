package com.codegym.repository;

import com.codegym.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EmployeeRepository extends JpaRepository<Employee, String> {
    @Query(value = "select * from employee where name like %:keyword% or address like %:keyword% or phone_number like %:keyword%", nativeQuery = true)

    Page<Employee> findAllByAll(@Param("keyword") String keyword, Pageable pageable);
}
