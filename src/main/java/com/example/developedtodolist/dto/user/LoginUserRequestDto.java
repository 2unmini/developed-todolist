package com.example.developedtodolist.dto.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class LoginUserRequestDto {

    private final String email;
    private final String password;
}
