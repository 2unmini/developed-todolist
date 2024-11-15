package com.example.developedtodolist.exception;

import org.springframework.http.HttpStatus;

public class MismatchPasswordException extends CustomException{
    public int getStatusCode() {
        return HttpStatus.UNAUTHORIZED.value();
    }

    public String getMessage() {
        return "비밀번호가 일치 하지 않습니다.";
    }
}
