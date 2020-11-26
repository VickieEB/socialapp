package com.petproject.socialapp.repositories;

import com.petproject.socialapp.model.Post;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PostRepository extends CrudRepository<Post, Long> {

    public List<Post> findByUserId(Long userId);
}
