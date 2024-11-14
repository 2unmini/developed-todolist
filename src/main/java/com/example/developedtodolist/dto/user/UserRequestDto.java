package com.example.developedtodolist.dto.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
@AllArgsConstructor
@Getter
public class UserRequestDto {

    private final String username;
    private final String email;
    private final String password;
}
