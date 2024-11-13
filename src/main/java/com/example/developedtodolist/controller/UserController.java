package com.example.developedtodolist.controller;

import com.example.developedtodolist.dto.user.UserRequestDto;
import com.example.developedtodolist.dto.user.UserResponseDto;
import com.example.developedtodolist.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/users")
    public ResponseEntity<UserResponseDto> createUser(@RequestBody UserRequestDto requestDto) {
        UserResponseDto savedUserResponseDto = userService.save(requestDto.getUsername(), requestDto.getEmail());
        return new ResponseEntity<>(savedUserResponseDto, HttpStatus.CREATED);
    }


}
