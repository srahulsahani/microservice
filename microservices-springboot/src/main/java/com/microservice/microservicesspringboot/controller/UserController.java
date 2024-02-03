package com.microservice.microservicesspringboot.controller;

import com.microservice.microservicesspringboot.entity.User;
import com.microservice.microservicesspringboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        User savedUser = userService.createUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long id){
        User user = userService.getUserById(id);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> allusers = userService.getALlUsers();
        return new ResponseEntity<>(allusers,HttpStatus.OK);
    }

    @PutMapping({"id"})
    public ResponseEntity<User> updatedUser(@PathVariable("id") Long userId,User user){
        User updatedUser = userService.updateUser(user);
        user.setId(userId);
        return new ResponseEntity<>(updatedUser,HttpStatus.OK);
    }

}
