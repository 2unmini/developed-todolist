package com.example.developedtodolist.dto.comment;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class CreateCommentRequestDto { // 생성시 요청할 dto
    @NotBlank
    private Long userId; // 유저 고유식별자
    @NotBlank
    private Long scheduleId; // 일정 고유 식별자
    @NotBlank(message = "내용을 입력해주세요")
    private String content; // 댓글
}
