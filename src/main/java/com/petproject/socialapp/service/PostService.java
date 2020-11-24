package com.petproject.socialapp.service;


import com.petproject.socialapp.model.Post;
import com.petproject.socialapp.repositories.PostRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class PostService {

    private PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }


    public List<Post> findAll(){
        List<Post> posts = new ArrayList<>();
        postRepository.findAll().forEach(posts::add);
        return posts;
    }

    public Post findById(Long id){
        return postRepository.findById(id).orElse(null);
    }

    public void save(Post post){
        postRepository.save(post);
    }

    public void deleteById(Long id){
        postRepository.deleteById(id);
    }

    public void delete(Post post){
        postRepository.delete(post);
    }

}
