package com.example.developedtodolist.dto.comment;

import com.example.developedtodolist.entity.Schedule;
import com.example.developedtodolist.entity.User;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDate;
@Getter
public class CreateCommentResponseDto {

    private Long commentId;
    private Long userId;
    private Long scheduleId;
    private String content;
    private LocalDate createdAt;

    public CreateCommentResponseDto(Long commentId, Long userId, Long scheduleId, String content, LocalDate createdAt) {
        this.commentId = commentId;
        this.userId = userId;
        this.scheduleId = scheduleId;
        this.content = content;
        this.createdAt = createdAt;
    }
}
