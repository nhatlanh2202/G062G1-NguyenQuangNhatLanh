package com.vn.service.impl;

import com.vn.model.User;
import com.vn.repository.UserRepository;
import com.vn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public User findByUsername(String name) {
        return userRepository.findByUsername(name);
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public List<User> findAllByStatusTrueAndRole_IdRole(Long id) {
        return userRepository.findAllByStatusTrueAndRole_IdRole(id);
    }

    @Override
    public boolean existsByUsername(String userName) {
        return userRepository.existsByUsername(userName);
    }
}
