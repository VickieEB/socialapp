package com.petproject.socialapp.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StudentDto {
    private Long id;
    private String name;
    private String department;
}
