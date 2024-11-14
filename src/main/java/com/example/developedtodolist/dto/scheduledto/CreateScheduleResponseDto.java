package com.example.developedtodolist.dto.scheduledto;

import com.example.developedtodolist.entity.Schedule;
import lombok.Getter;

import java.time.LocalDate;
@Getter
public class CreateScheduleResponseDto {
    private Long scheduleId; // 일정 고유 식별자
    private Long userId; // 유저 고유 식별자
    private String title; // 제목
    private String content; // 내용
    private LocalDate createdAt; // 일정 생성 일시


    public CreateScheduleResponseDto(Long scheduleId, Long userId, String title, String content,LocalDate createdAt) {
        this.scheduleId = scheduleId;
        this.userId = userId;
        this.title = title;
        this.content = content;
        this.createdAt=createdAt;
    }

    /*public static CreateScheduleResponseDto toScheduleResponseDto(Schedule schedule) {
        return new CreateScheduleResponseDto(schedule.getScheduleId(), schedule.getUser().getUserId(), schedule.getTitle(), schedule.getContent());
    }*/
}
