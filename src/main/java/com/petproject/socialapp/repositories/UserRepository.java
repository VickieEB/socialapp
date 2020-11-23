package com.petproject.socialapp.repositories;

import com.petproject.socialapp.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
