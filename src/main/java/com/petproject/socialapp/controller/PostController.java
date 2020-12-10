package com.petproject.socialapp.controller;


import com.petproject.socialapp.dto.PostDto;
import com.petproject.socialapp.model.Post;

import com.petproject.socialapp.service.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class PostController {

    private ModelMapper modelMapper;

    private PostService postService;

    public PostController(ModelMapper modelMapper, PostService postService) {
        this.modelMapper = modelMapper;
        this.postService = postService;
    }

    @GetMapping("/posts")
    public List<PostDto> getAllPosts(){
        List<Post> posts = postService.findAll();
        return posts.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @GetMapping("/posts/{id}")
    public PostDto getPostById(@PathVariable Long id){
        Post post = postService.findById(id);
        PostDto postDto = convertToDto(post);
        return postDto;
    }

    @GetMapping("/posts/user/{id}")
    public List<PostDto> getPostsByUserId(@PathVariable Long id){

        List<Post> posts = postService.findByUserId(id);
        List<PostDto> postDtoList = posts.stream().map(this::convertToDto).collect(Collectors.toList());
        return postDtoList;

    }

    @PostMapping("/posts")
    public void addPost(@RequestBody PostDto postDto){
        Post post = convertToEntity(postDto);
        postService.save(post);
    }

    @PutMapping("/posts/{id}")
    public void updatePost(@PathVariable Long id, @RequestBody PostDto postDto){
        Post existingPost = postService.findById(id);
        BeanUtils.copyProperties(convertToEntity(postDto), existingPost);
        postService.save(existingPost);
    }

    @DeleteMapping("/posts/{id}")
    public void deletePost(@PathVariable Long id){
        postService.deleteById(id);
    }

    private PostDto convertToDto(Post post){
        PostDto postDto = modelMapper.map(post, PostDto.class);
        return postDto;
    }

    private Post convertToEntity(PostDto postDto){
        Post post = modelMapper.map(postDto, Post.class);
        return post;
    }

}
