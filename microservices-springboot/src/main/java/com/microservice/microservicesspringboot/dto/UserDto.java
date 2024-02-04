package com.microservice.microservicesspringboot.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private  long id;
    @NotEmpty(message = "User first name shouldn't be empty")
    private String firstName;
    //User last name shouldn't be empty
    @NotEmpty(message = "User last name shouldn't be empty")
    private String lastName;
    @NotEmpty(message = "User email shouldn't be empty")
    @Email(message = "Email address should be valid")
    private String email;
}
