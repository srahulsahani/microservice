package com.microservice.microservicesspringboot.service;

import com.microservice.microservicesspringboot.entity.User;

import java.util.List;

public interface UserService {
    User createUser(User user);

    User getUserById(Long id);

    List<User> getALlUsers();
}
