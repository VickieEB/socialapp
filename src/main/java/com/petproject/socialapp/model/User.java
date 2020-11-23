package com.petproject.socialapp.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class User {
    private Long id;
    private String firstname;
    private String lastname;
    private Location location;
    private String email;

}
