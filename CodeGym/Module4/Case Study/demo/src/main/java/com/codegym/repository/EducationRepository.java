package com.codegym.repository;

import com.codegym.entity.EducationDegree;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EducationRepository extends JpaRepository<EducationDegree, Long> {
}
