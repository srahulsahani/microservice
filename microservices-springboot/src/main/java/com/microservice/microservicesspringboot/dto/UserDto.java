package com.microservice.microservicesspringboot.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(
        description = "UserDto model information"
)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private  long id;

    @Schema(description = "User First Name")
    @NotEmpty(message = "User first name shouldn't be empty")
    private String firstName;


    @Schema(description = "User Last Name")
    @NotEmpty(message = "User last name shouldn't be empty")
    private String lastName;

    @Schema(description = "User Email Address")
    @NotEmpty(message = "User email shouldn't be empty")
    @Email(message = "Email address should be valid")
    private String email;
}
