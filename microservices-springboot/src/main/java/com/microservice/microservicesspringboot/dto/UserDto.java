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
    //User first name shouldn't be empty
    @NotEmpty
    private String firstName;
    //User last name shouldn't be empty
    @NotEmpty
    private String lastName;
    //User email shouldn't be empty, it should be valid
    @NotEmpty
    @Email
    private String email;
}
