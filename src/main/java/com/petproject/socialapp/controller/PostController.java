package com.petproject.socialapp.controller;


import com.petproject.socialapp.model.Post;

import com.petproject.socialapp.service.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {

    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/posts")
    public List<Post> getAllPosts(){
        return postService.findAll();
    }

    @GetMapping("/posts/{id}")
    public Post getPostById(@PathVariable Long id){
        return postService.findById(id);
    }

    @PostMapping("/posts")
    public void addPost(@RequestBody Post post){
        postService.save(post);
    }

    @PutMapping("/posts/{id}")
    public void updatePost(@PathVariable Long id, @RequestBody Post post){
        postService.updatePost(id, post);
    }

    @DeleteMapping("/posts/{id}")
    public void deletePost(@PathVariable Long id){
        postService.deleteById(id);
    }
}
