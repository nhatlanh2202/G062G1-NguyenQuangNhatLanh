package com.codegym.repository;


import com.codegym.entity.Services;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRepository extends JpaRepository<Services,String> {
    @Query(value = "select * from service where name_service like %:keyword% or status like %:keyword% or area like %:keyword%",nativeQuery = true)
    Page<Services> findAllByAll(@Param("keyword") String keyword, Pageable pageable);
}
