package com.microservice.microservicesspringboot.service.impl;

import com.microservice.microservicesspringboot.dto.UserDto;
import com.microservice.microservicesspringboot.entity.User;
import com.microservice.microservicesspringboot.mapper.AutoUserMapper;
import com.microservice.microservicesspringboot.mapper.UserMapper;
import com.microservice.microservicesspringboot.repository.UserRepository;
import com.microservice.microservicesspringboot.service.UserService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    private ModelMapper modelMapper;


    @Override
    public UserDto createUser(UserDto userDto) {

        //Convert UserDto into JPA entity
//        User user = UserMapper.mapToUser(userDto);

//        User user = modelMapper.map(userDto,User.class);

        User user = AutoUserMapper.MAPPER.mapToUser(userDto);



        User savedUser = userRepository.save(user);

        //Convert User JPA to  UserDto
//        UserDto savedUserDto = UserMapper.mapToUserDto(savedUser);
//        UserDto savedUserDto = modelMapper.map(savedUser, UserDto.class);

        UserDto savedUserDto = AutoUserMapper.MAPPER.mapToUserDto(savedUser);

        return savedUserDto;
    }

    @Override
    public UserDto getUserById(Long userId ){
        Optional<User> optionalUser = userRepository.findById(userId);
        User savedUser = optionalUser.get();
//        return UserMapper.mapToUserDto(savedUser);
//        return modelMapper.map(savedUser, UserDto.class);
        return AutoUserMapper.MAPPER.mapToUserDto(savedUser);
    }

    @Override
    public List<UserDto> getALlUsers() {
        List<User> users =  userRepository.findAll();
//        return users.stream().map((user)-> modelMapper.map(user, UserDto.class)).collect(Collectors.toList());
        return users.stream().map((user)-> AutoUserMapper.MAPPER.mapToUserDto(user)).collect(Collectors.toList());

    }

    @Override
    public UserDto updateUser(UserDto user) {
        User existingUser = userRepository.findById(user.getId()).get();
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());
        User updatedUser = userRepository.save(existingUser);
//        return modelMapper.map(updatedUser, UserDto.class);
        return AutoUserMapper.MAPPER.mapToUserDto(updatedUser);

    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }


}
