package com.example.developedtodolist.dto.user;

import com.example.developedtodolist.entity.User;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class ReadUserResponseDto {

    private Long userId; // 유저 고유 식별자
    private String username; // 이름
    private String email; // 이메일
    private LocalDate createdAt; // 유저 생성일시
    private LocalDate updatedAt; // 유저 수정일시


    public ReadUserResponseDto(Long userId, String username, String email, String password, LocalDate createdAt, LocalDate updatedAt) {
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public ReadUserResponseDto(Long userId, String username, String email, LocalDate createdAt, LocalDate updatedAt) {
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public static ReadUserResponseDto toUserResponseDto(User user) {
        return new ReadUserResponseDto(user.getUserId(), user.getUsername(), user.getEmail(), user.getPassword(), user.getCreatedAt(), user.getUpdatedAt());
    }

}
