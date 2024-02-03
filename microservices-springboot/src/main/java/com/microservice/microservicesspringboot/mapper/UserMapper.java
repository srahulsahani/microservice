package com.microservice.microservicesspringboot.mapper;

import com.microservice.microservicesspringboot.dto.UserDto;
import com.microservice.microservicesspringboot.entity.User;

public class UserMapper {

    //Convert User JPA to  UserDto
    public static UserDto mapToUserDto(User user){
            UserDto userDto = new UserDto(
                    user.getId(),
                    user.getFirstName(),
                    user.getLastName(),
                    user.getEmail()
            );
            return userDto;
    }

    //Convert UserDto into JPA enity
    public  static User mapToUser(UserDto userDto){
        User user = new User(
                userDto.getId(),
                userDto.getFirstName(),
                userDto.getLastName(),
                userDto.getEmail()
        );
        return user;
}
