package com.petproject.socialapp.service;

import com.petproject.socialapp.model.User;
import com.petproject.socialapp.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll(){
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }

    public User findById(Long id){
        return userRepository.findById(id).orElse(null);
    }


    public List<User> findUsersByLocationId(Long locationId){
        List<User> users = new ArrayList<>();
        userRepository.findUserByLocationId(locationId).forEach(users::add);
        return users;
    }


    public void save(User user){
        userRepository.save(user);
    }

    public void deleteById(Long id){
        userRepository.deleteById(id);
    }

    public void delete(User user){
        userRepository.delete(user);
    }
}
