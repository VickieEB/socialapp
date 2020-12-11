package com.petproject.socialapp.controller;

import com.petproject.socialapp.dto.UserDto;
import com.petproject.socialapp.model.Location;
import com.petproject.socialapp.model.User;
import com.petproject.socialapp.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class UserController {

    private UserService userService;

    private ModelMapper modelMapper;

    public UserController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/users")
    public List<UserDto> getAllUsers(){
        List<User> users = userService.findAll();
        return users.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @GetMapping("/users/{id}")
    private UserDto getUsersById(@PathVariable Long id){
        User user = userService.findById(id);
        return convertToDto(user);
    }

    @GetMapping("/users/location/{id}")
    public List<UserDto> getUsersByLocationId(@PathVariable Long id){
        List<User> usersByLocationId = userService.findUsersByLocationId(id);
        return usersByLocationId.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @PostMapping("/users")
    public void addUser(@RequestBody UserDto userDto){
        userService.save(convertToEntity(userDto));
    }

    @PutMapping("/users/{id}")
    public void updateUser(@PathVariable Long id, @RequestBody UserDto userDto){
        User existingUser = userService.findById(id);
        BeanUtils.copyProperties(convertToEntity(userDto),existingUser);
        userService.save(existingUser);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable Long id){
        userService.deleteById(id);
    }

    private UserDto convertToDto(User user){
        return modelMapper.map(user, UserDto.class);
    }

    private User convertToEntity(UserDto userDto){
        return modelMapper.map(userDto, User.class);
    }

}
