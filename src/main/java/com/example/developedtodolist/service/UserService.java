package com.example.developedtodolist.service;

import com.example.developedtodolist.config.PasswordEncoder;
import com.example.developedtodolist.dto.user.LoginUserRequestDto;
import com.example.developedtodolist.dto.user.UserResponseDto;
import com.example.developedtodolist.entity.User;
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


    public UserResponseDto save(String username, String email, String password) {
        User user = new User(username, email,passwordEncoder.encode(password));
        User savedUser = userRepository.save(user);
        return new UserResponseDto(
                savedUser.getUserId()
                , savedUser.getUsername()
                , savedUser.getEmail()
        );
    }

    public List<UserResponseDto> findAll() {
        List<User> userList = userRepository.findAll();
        return userList.stream().map(UserResponseDto::toUserResponseDto).toList();

    }

    public UserResponseDto findById(Long id) {
        User user = userRepository.findByIdOrElseThrow(id);
        return new UserResponseDto(user.getUserId()
                , user.getUsername()
                , user.getEmail()
        );

    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

   /* public UserResponseDto login(String email, String password, HttpServletRequest request) {
       *//* Long userId = userRepository.findByEmailAndPassword(email, password);
        if (userId!=null){
            HttpSession session = request.getSession();
            User loginUser = userRepository.findByIdOrElseThrow(userId);
            session.setAttribute("user_id", loginUser);
            return new UserResponseDto(userId,email,password);
        }
*//*
        throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
    }*/

    public boolean login(LoginUserRequestDto requestDto, HttpServletRequest request) {
        User user = userRepository.findUserByEmail(requestDto.getEmail());
        if(user.getUserId()!=null&& passwordEncoder.matches(requestDto.getPassword(),user.getPassword())){
            HttpSession session = request.getSession();
            session.setAttribute("loginUser",user.getUserId());
            return true;

        }
        throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
    }

    public void logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if(session!=null) {
            session.invalidate();
        }
    }
}
