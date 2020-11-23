package com.petproject.socialapp.service;

import com.petproject.socialapp.model.Location;
import com.petproject.socialapp.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class UserService {

    Location lagos = Location.builder().id(1L).name("Lagos State").build();
    User user1 = User.builder().id(1L).firstname("Naomi").lastname("Osaka").email("no@gmail.com").location(lagos).build();
    User user2 = User.builder().id(2L).firstname("Zizi").lastname("Tonzi").email("zizi@gmail.com").location(lagos).build();
    List<User> users = new ArrayList<>(Arrays.asList(user1, user2));

    public List<User> findAll(){
        return users;
    }

    public User findById(Long id){
        return users.stream().filter(user -> id.equals(user.getId())).findFirst().orElse(null);
    }

    public void save(User user){
        users.add(user);
    }

    public void updateUser(Long id, User user) {
        users.forEach(userToModify -> {
            if(userToModify.getId().equals(user.getId())){
                userToModify.setEmail(user.getEmail());
                userToModify.setFirstname(user.getFirstname());
                userToModify.setLastname(user.getLastname());
                userToModify.setLocation(user.getLocation());
            }
        });
    }

    public void deleteById(Long id) {
        users.removeIf(userToDelete -> userToDelete.getId().equals(id));
    }


}
