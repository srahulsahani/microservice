package com.microservice.microservicesspringboot.service;

import com.microservice.microservicesspringboot.dto.UserDto;
import com.microservice.microservicesspringboot.entity.User;

import java.util.List;

public interface UserService {
    UserDto createUser(UserDto user);

    UserDto getUserById(Long id);

    List<User> getALlUsers();

    User updateUser(User user);
    void deleteUser(Long userId);
}
