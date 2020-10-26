package com.codegym.service;

import com.codegym.entity.Province;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface ProvinceService {
    List<Province> findAll();

    Province findOne(Integer id);

    Province save(Province Province);

    List<Province> save(List<Province> Provinces);

    boolean exists(Integer id);

    List<Province> findAll(List<Integer> ids);

    long count();

    void delete(Integer id);

    void delete(Province Province);

    void delete(List<Province> Provinces);

    void deleteAll();
}
