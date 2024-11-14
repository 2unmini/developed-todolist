package com.example.developedtodolist.dto.scheduledto;

import com.example.developedtodolist.entity.Schedule;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class PageScheduleResponseDto { // 페이징 조회 조회시 반환할 dto
    private String title; // 할일 제목
    private String username; // 일정 작성 유저 명
    private String content; // 댓글
    private Long commentCount; // 댓글 개수
    private LocalDate createdAt; // 일정 생성일시
    private LocalDate updatedAt; // 일정 수정 일시

    public PageScheduleResponseDto(String title, String username, String content, Long commentCount, LocalDate createdAt, LocalDate updatedAt) {
        this.title = title;
        this.username = username;
        this.content = content;
        this.commentCount = commentCount;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }


    public static PageScheduleResponseDto topageScheduleResponsedto(Schedule schedule) { // 엔티티를 응답할 dto로 변환하는 기능
        return new PageScheduleResponseDto(
                schedule.getTitle()
                , schedule.getUser().getUsername()
                , schedule.getContent()
                , schedule.getCommentCount()
                , schedule.getCreatedAt()
                , schedule.getUpdatedAt()
        );
    }
}
