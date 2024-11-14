package com.example.developedtodolist.dto.user;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class SignupUserRequestDto { // 회원가입시 요청하는 dto
    @NotBlank(message = "이름을 입력해주세요 ") // 필수 값 null,"" 금지
    private final String username; // 이름
    @NotBlank(message = "이메일을 입력해주세요") // 필수 값 null,"" 금지, 이메일 형식 확인
    @Pattern(regexp = "^[a-zA-Z0-9+-_.]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$", message = "올바른 이메일 형식이 맞지 않습니다")
    private final String email;
    @NotBlank(message = "비밀번호를 입력해주세요")
    @Size(min = 5, message = "비밀번호는 최소 5자 이상입니다 ") // 필수 값 null,"" 금지 , 5자리 이상인지 확인
    private final String password; // 비밀번호
}
