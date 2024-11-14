package com.example.developedtodolist.controller;

import com.example.developedtodolist.dto.user.CreateUserResponseDto;
import com.example.developedtodolist.dto.user.LoginUserRequestDto;
import com.example.developedtodolist.dto.user.SignupUserRequestDto;
import com.example.developedtodolist.dto.user.ReadUserResponseDto;

import com.example.developedtodolist.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/create")
    public ResponseEntity<CreateUserResponseDto> createUser(@Validated @RequestBody SignupUserRequestDto requestDto) { // 회원가입 기능
        CreateUserResponseDto savedUserResponseDto = userService.save(requestDto.getUsername(), requestDto.getEmail(), requestDto.getPassword());
        return new ResponseEntity<>(savedUserResponseDto, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ReadUserResponseDto>> findUserAll() { //유저 정보 조회 기능
        List<ReadUserResponseDto> readUserResponseDtoList = userService.findAll();
        return new ResponseEntity<>(readUserResponseDtoList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReadUserResponseDto> findUserById(@PathVariable Long id) { // 요청한 id 와 일치하는 유저 정보 조회 기능
        ReadUserResponseDto readUserResponseDto = userService.findById(id);
        return new ResponseEntity<>(readUserResponseDto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) { // 요청한 id 와 일치하는 유저 정보 삭제 기능
        userService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<Void> login(@RequestBody LoginUserRequestDto requestDto, HttpServletRequest request) { // 로그인 기능
        if (userService.login(requestDto, request)) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/logout")
    public ResponseEntity<Void> logout(HttpServletRequest request) {
        userService.logout(request);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
