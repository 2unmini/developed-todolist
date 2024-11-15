package com.example.developedtodolist.dto.user;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class CreateUserResponseDto {
    private Long userId; // 유저 고유 식별자
    private String username; // 이름
    private String email; // 이메일
    private LocalDate createdAt; // 유저 생성일시


    public CreateUserResponseDto(Long userId, String username, String email, LocalDate createdAt) {
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.createdAt = createdAt;
    }
}
