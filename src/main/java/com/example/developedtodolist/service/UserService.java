package com.example.developedtodolist.service;

import com.example.developedtodolist.dto.user.UserResponseDto;
import com.example.developedtodolist.entity.User;
import com.example.developedtodolist.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public UserResponseDto save(String username,String email) {
        User user = new User(username,email);
        User savedUser = userRepository.save(user);
        return new UserResponseDto(
                savedUser.getUserId()
                ,savedUser.getUsername()
                ,savedUser.getEmail());
    }
}
