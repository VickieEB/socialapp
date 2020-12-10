package com.petproject.socialapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private Long id;
    private String firstname;
    private String lastname;


    private LocationDto locationDto;


    private Set<PostDto> postDtos;

    private String email;
}
