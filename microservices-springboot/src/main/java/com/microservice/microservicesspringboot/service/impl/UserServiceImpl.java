package com.microservice.microservicesspringboot.service.impl;

import com.microservice.microservicesspringboot.entity.User;
import com.microservice.microservicesspringboot.repository.UserRepository;
import com.microservice.microservicesspringboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }
}
