package com.petproject.socialapp.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstname;
    private String lastname;

    @ManyToOne
    private Location location;

    @OneToMany
    private Set<Post> post;

    private String email;

}
