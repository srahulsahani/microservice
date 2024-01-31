package com.microservice.microservicesspringboot.service;

import com.microservice.microservicesspringboot.entity.User;

public interface UserService {
    User createUser(User user);

    User getUserById(Long id);
}
