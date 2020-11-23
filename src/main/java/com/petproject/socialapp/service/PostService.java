package com.petproject.socialapp.service;

import com.petproject.socialapp.model.Location;
import com.petproject.socialapp.model.Post;
import com.petproject.socialapp.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class PostService {

    Location lagos = Location.builder().id(1L).name("Lagos State").build();
    Location abuja = Location.builder().id(2L).name("South Africa").build();

    User user1 = User.builder().id(1L).firstname("Naomi").lastname("Osaka").email("no@gmail.com").location(lagos).build();
    User user2 = User.builder().id(2L).firstname("Zizi").lastname("Tonzi").email("zizi@gmail.com").location(lagos).build();

    Post post1 = Post.builder().id(1L).details("I kinda like the Emily in Paris show").postdate("07/11/2020").user(user1).build();
    Post post2 = Post.builder().id(2L).details("#EndSars").postdate("18/10/2020").user(user2).build();

    List<Post> posts = new ArrayList<>(Arrays.asList(post1, post2));

    public List<Post> findAll(){
        return posts;
    }

    public Post findById(Long id){
        return posts.stream().filter(p -> id.equals(p.getId())).findFirst().orElse(null);
    }

    public void save(Post post){
        posts.add(post);
    }

    public void updatePost(Long id, Post post) {
        posts.forEach(postToModify -> {
            if(postToModify.getId().equals(post.getId())){
                postToModify.setDetails(post.getDetails());
                postToModify.setPostdate(post.getPostdate());
                postToModify.setUser(post.getUser());
            }
        });
    }

    public void deleteById(Long id) {
        posts.removeIf(postTodelete -> postTodelete.getId().equals(id));
    }
}
