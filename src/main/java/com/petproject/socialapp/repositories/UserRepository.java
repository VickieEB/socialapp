package com.petproject.socialapp.repositories;

import com.petproject.socialapp.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long>{
    public List<User> findUserByLocationId(Long locationId);
}
