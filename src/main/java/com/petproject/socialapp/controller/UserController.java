package com.petproject.socialapp.controller;

import com.petproject.socialapp.model.Location;
import com.petproject.socialapp.model.User;
import com.petproject.socialapp.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userService.findAll();
    }

    @GetMapping("/users/{id}")
    private User getUsersById(@PathVariable Long id){
        return userService.findById(id);
    }

    @PostMapping("/users")
    public void addUser(@RequestBody User user){
        userService.save(user);
    }

    @PutMapping("/users/{id}")
    public void updateUser(@PathVariable Long id, @RequestBody User user){
        userService.updateUser(id, user);

    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable Long id){
        userService.deleteById(id);
    }

}
