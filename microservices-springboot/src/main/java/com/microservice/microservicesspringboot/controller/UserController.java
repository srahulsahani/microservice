package com.microservice.microservicesspringboot.controller;

import com.microservice.microservicesspringboot.dto.UserDto;
import com.microservice.microservicesspringboot.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Tag(
        name = "CRUD REST API for user Resource",
        description = "Create,Update,Get,Delete User"
)
@Controller
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Operation(
            summary = "Create User REST API",
            description = "createUser REST API is used to save a user in database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "Http Status 201 CREATED"
    )
    @PostMapping
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto user){
        UserDto savedUser = userService.createUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }


    @Operation(
            summary = "get User by id REST API",
            description = "getUserById REST API is used to get a single user from database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Http Status 201 SUCCESS"
    )
    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("id") Long id){
        UserDto userDto = userService.getUserById(id);
        return new ResponseEntity<>(userDto,HttpStatus.OK);
    }


    @Operation(
            summary = "Get All User REST API",
            description = "getAllUSer REST API is used to get all the users from database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Http Status 200 SUCCESS"
    )
    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers(){
        List<UserDto> allusers = userService.getALlUsers();
        return new ResponseEntity<>(allusers,HttpStatus.OK);
    }

    @Operation(
            summary = "Update User REST API",
            description = "updateUser REST API is used to update a particular user in database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Http Status 200 SUCCESS"
    )
    @PutMapping({"id"})
    public ResponseEntity<UserDto> updatedUser(@PathVariable("id") Long userId,
                                               @Valid UserDto user){
        UserDto updatedUser = userService.updateUser(user);
        user.setId(userId);
        return new ResponseEntity<>(updatedUser,HttpStatus.OK);
    }


    @Operation(
            summary = "Delete User REST API",
            description = "deleteUser REST API is used to get all the users from database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Http Status 200 SUCCESS"
    )
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long userId){
        userService.deleteUser(userId);
        return new ResponseEntity<>("User delete Successfully",HttpStatus.OK);
    }

}
