package com.codegym.repository;

import com.codegym.entity.RegisterForm;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FormRepository extends JpaRepository<RegisterForm , Integer> {
}
