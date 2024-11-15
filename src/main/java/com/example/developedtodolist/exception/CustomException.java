package com.example.developedtodolist.exception;

public abstract class CustomException extends RuntimeException {
    public abstract int getStatusCode();

    public abstract String getMessage();
}
