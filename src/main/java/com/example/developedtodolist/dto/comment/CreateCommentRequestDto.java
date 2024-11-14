package com.example.developedtodolist.dto.comment;

import lombok.Getter;

@Getter
public class CreateCommentRequestDto {
    private Long userId;
    private Long scheduleId;
    private String content;
}
