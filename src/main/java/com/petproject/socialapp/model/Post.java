package com.petproject.socialapp.model;

import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Post {

    private Long id;
    private String postdate;
    private User user;
    private String details;

}
