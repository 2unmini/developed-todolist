package com.example.developedtodolist.exception;


import lombok.Getter;

@Getter
public class ErrorResponse { // 오류 코드와 오류 메시지를 저장하는 Response 객체
    private int errorCode; // 오류 코드
    private String message; // 오류 메시지

    public ErrorResponse(int errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }
}
