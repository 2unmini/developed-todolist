package com.example.developedtodolist.dto.user;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;

@Getter
public class UserResponseDto {

    private Long userId;
    private String username;
    private String email;


    public UserResponseDto(Long userId ,String username, String email) {
        this.userId =userId;
        this.username = username;
        this.email = email;
    }

}
