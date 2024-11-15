package com.example.developedtodolist.dto.comment;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class CreateCommentResponseDto { // 생성 시 반환할 dto
    private Long commentId; // 댓글 고유식별자
    private Long userId; // 유저 고유 식별자
    private Long scheduleId; // 일정 고유 식별자
    private String content; // 댓글
    private LocalDate createdAt; // 생성 일시

    public CreateCommentResponseDto(Long commentId, Long userId, Long scheduleId, String content, LocalDate createdAt) {
        this.commentId = commentId;
        this.userId = userId;
        this.scheduleId = scheduleId;
        this.content = content;
        this.createdAt = createdAt;
    }
}
