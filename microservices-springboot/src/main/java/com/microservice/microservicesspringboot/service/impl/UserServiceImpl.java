package com.microservice.microservicesspringboot.service.impl;

import com.microservice.microservicesspringboot.entity.User;
import com.microservice.microservicesspringboot.repository.UserRepository;
import com.microservice.microservicesspringboot.service.UserService;

public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }
}
