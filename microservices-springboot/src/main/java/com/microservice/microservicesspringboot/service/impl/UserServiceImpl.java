package com.microservice.microservicesspringboot.service.impl;

import com.microservice.microservicesspringboot.dto.UserDto;
import com.microservice.microservicesspringboot.entity.User;
import com.microservice.microservicesspringboot.mapper.UserMapper;
import com.microservice.microservicesspringboot.repository.UserRepository;
import com.microservice.microservicesspringboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDto createUser(UserDto userDto) {

        //Convert UserDto into JPA entity
        User user = UserMapper.mapToUser(userDto);
        User savedUser = userRepository.save(user);

        //Convert User JPA to  UserDto
        UserDto savedUserDto = UserMapper.mapToUserDto(savedUser);
        return savedUserDto;
    }

    @Override
    public UserDto getUserById(Long userId ){
        Optional<User> optionalUser = userRepository.findById(userId);
        User savedUser = optionalUser.get();
        return UserMapper.mapToUserDto(savedUser);
    }

    @Override
    public List<UserDto> getALlUsers() {
        List<User> users =  userRepository.findAll();
        return users.stream().map(UserMapper::mapToUserDto).collect(Collectors.toList());
    }

    @Override
    public UserDto updateUser(UserDto user) {
        User existingUser = userRepository.findById(user.getId()).get();
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());
        User updatedUser = userRepository.save(existingUser);
        return UserMapper.mapToUserDto(updatedUser);
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }


}
