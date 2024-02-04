package com.microservice.microservicesspringboot.mapper;

import com.microservice.microservicesspringboot.dto.UserDto;
import com.microservice.microservicesspringboot.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AutoUserMapper {
    AutoUserMapper MAPPER = Mappers.getMapper(AutoUserMapper.class);
    UserDto mapToUserDto(User user);

    User mapToUser(UserDto userDto);
}
