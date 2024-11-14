package com.example.developedtodolist.dto.user;

import com.example.developedtodolist.entity.User;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;

@Getter
public class UserResponseDto {

    private Long userId;
    private String username;
    private String email;
    private String password;


    public UserResponseDto(Long userId ,String username, String email,String password) {
        this.userId =userId;
        this.username = username;
        this.email = email;
        this.password=password;
    }
    public UserResponseDto(Long userId ,String username, String email) {
        this.userId =userId;
        this.username = username;
        this.email = email;
    }

    public static UserResponseDto toUserResponseDto(User user) {
        return new UserResponseDto(user.getUserId(), user.getUsername(),user.getEmail(),user.getPassword());
    }

}
