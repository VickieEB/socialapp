package com.petproject.socialapp.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDto {
    private Long id;
    private String details;
    private String postdate;

    private UserDto userDto;

}
