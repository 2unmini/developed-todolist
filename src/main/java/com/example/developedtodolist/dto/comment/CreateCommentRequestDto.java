package com.example.developedtodolist.dto.comment;

import lombok.Getter;

@Getter
public class CreateCommentRequestDto { // 생성시 요청할 dto
    private Long userId; // 유저 고유식별자
    private Long scheduleId; // 일정 고유 식별자
    private String content; // 댓글
}
