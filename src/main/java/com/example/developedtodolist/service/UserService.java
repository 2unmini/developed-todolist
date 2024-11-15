package com.example.developedtodolist.service;

import com.example.developedtodolist.config.PasswordEncoder;
import com.example.developedtodolist.dto.user.CreateUserResponseDto;
import com.example.developedtodolist.dto.user.LoginUserRequestDto;
import com.example.developedtodolist.dto.user.ReadUserResponseDto;
import com.example.developedtodolist.entity.User;
import com.example.developedtodolist.exception.MismatchPasswordException;
import com.example.developedtodolist.repository.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    public CreateUserResponseDto save(String username, String email, String password) { // 회원가입 로직
        User user = new User(username, email, passwordEncoder.encode(password));
        User savedUser = userRepository.save(user);
        return new CreateUserResponseDto(
                savedUser.getUserId()
                , savedUser.getUsername()
                , savedUser.getEmail()
                , savedUser.getCreatedAt()
        );
    }

    public List<ReadUserResponseDto> findAll() { // 전체 유저 조회 로직
        List<User> userList = userRepository.findAll();
        return userList.stream().map(ReadUserResponseDto::toUserResponseDto).toList();

    }

    public ReadUserResponseDto findById(Long id) { // 상세 유저 조회 로직
        User user = userRepository.findByIdOrElseThrow(id);
        return new ReadUserResponseDto(user.getUserId()
                , user.getUsername()
                , user.getEmail()
                , user.getCreatedAt()
                , user.getUpdatedAt()
        );

    }

    public void deleteById(Long id) { //회원 삭제 로직
        User user = userRepository.findByIdOrElseThrow(id);
        userRepository.delete(user);
    }

    public boolean login(LoginUserRequestDto requestDto, HttpServletRequest request) { // 로그인 로직
        User user = userRepository.findUserByEmail(requestDto.getEmail());
        if (user.getUserId() != null && passwordEncoder.matches(requestDto.getPassword(), user.getPassword())) {
            HttpSession session = request.getSession();
            session.setAttribute("loginUser", user.getUserId());
            return true;

        }
        throw new MismatchPasswordException();
    }

    public void logout(HttpServletRequest request) { // 로그아웃 로직
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
    }
}
