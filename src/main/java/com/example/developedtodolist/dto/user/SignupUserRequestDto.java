package com.example.developedtodolist.dto.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
@AllArgsConstructor
@Getter
public class SignupUserRequestDto {
    @NotBlank(message = "이름을 입력해주세요 ")
    private final String username;
    @NotBlank(message = "이메일을 입력해주세요")
    @Pattern(regexp = "^[a-zA-Z0-9+-_.]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$",message = "올바른 이메일 형식이 맞지 않습니다")
    private final String email;
    @NotBlank(message = "비밀번호를 입력해주세요")
    @Size(min = 5,message = "비밀번호는 최소 5자 이상입니다 ")
    private final String password;
}
