package com.petproject.socialapp.repositories;

import com.petproject.socialapp.model.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Long> {
}
