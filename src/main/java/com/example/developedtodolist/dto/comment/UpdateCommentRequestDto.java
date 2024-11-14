package com.example.developedtodolist.dto.comment;

import lombok.Getter;

@Getter
public class UpdateCommentRequestDto {
    private String content;

    public UpdateCommentRequestDto(String content) {
        this.content = content;
    }
}
