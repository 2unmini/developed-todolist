package com.example.developedtodolist.dto.scheduledto;

import com.example.developedtodolist.entity.Schedule;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class PageScheduleResponseDto {
    private String title;
    private String username;
    private String content;
    private Long commentCount;
    private LocalDate createdAt;
    private LocalDate updatedAt;
    public PageScheduleResponseDto(String title, String username, String content, Long commentCount, LocalDate createdAt, LocalDate updatedAt) {
        this.title = title;
        this.username = username;
        this.content = content;
        this.commentCount = commentCount;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }



    public static PageScheduleResponseDto topageScheduleResponsedto(Schedule schedule) {
        return new PageScheduleResponseDto(
                schedule.getTitle()
                ,schedule.getUser().getUsername()
                ,schedule.getContent()
                , schedule.getCommentCount()
                , schedule.getCreatedAt()
                ,schedule.getUpdatedAt()
        );
    }
}
