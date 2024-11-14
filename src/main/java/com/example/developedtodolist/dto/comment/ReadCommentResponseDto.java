package com.example.developedtodolist.dto.comment;

import com.example.developedtodolist.entity.Comment;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class ReadCommentResponseDto { // 조회시 반환할 dto
    private Long commentId; // 댓글 고유식별자
    private Long userId; // 유저 고유식별자
    private Long scheduleId; // 일정 고유 식별자
    private String content; // 댓글
    private LocalDate createdAt; // 댓글 생성 일시
    private LocalDate updatedAt; // 댓글 수정 일시

    public ReadCommentResponseDto(Comment comment) {
        this.commentId = comment.getCommentId();
        this.userId = comment.getUser().getUserId();
        this.scheduleId = comment.getSchedule().getScheduleId();
        this.content = comment.getContent();
        this.createdAt = comment.getCreatedAt();
        this.updatedAt = comment.getUpdatedAt();
    }
}
