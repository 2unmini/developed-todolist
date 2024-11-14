package com.example.developedtodolist.dto.comment;

import com.example.developedtodolist.entity.Comment;
import lombok.Getter;

import java.time.LocalDate;
@Getter
public class ReadCommentResponseDto {
    private Long commentId;
    private Long userId;
    private Long scheduleId;
    private String content;
    private LocalDate createdAt;
    private LocalDate updatedAt;

    public ReadCommentResponseDto(Comment comment) {
        this.commentId = comment.getCommentId();
        this.userId = comment.getUser().getUserId();
        this.scheduleId = comment.getSchedule().getScheduleId();
        this.content = comment.getContent();
        this.createdAt = comment.getCreatedAt();
        this.updatedAt = comment.getUpdatedAt();
    }
}
