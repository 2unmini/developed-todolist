package com.example.developedtodolist.dto.user;

import com.example.developedtodolist.entity.User;
import lombok.Getter;

@Getter
public class UserResponseDto {

    private Long userId; // 유저 고유 식별자
    private String username; // 이름
    private String email; // 이메일


    public UserResponseDto(Long userId, String username, String email, String password) {
        this.userId = userId;
        this.username = username;
        this.email = email;
    }

    public UserResponseDto(Long userId, String username, String email) {
        this.userId = userId;
        this.username = username;
        this.email = email;
    }

    public static UserResponseDto toUserResponseDto(User user) {
        return new UserResponseDto(user.getUserId(), user.getUsername(), user.getEmail(), user.getPassword());
    }

}
