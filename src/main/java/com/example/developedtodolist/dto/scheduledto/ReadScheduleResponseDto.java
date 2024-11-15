package com.example.developedtodolist.dto.scheduledto;


import com.example.developedtodolist.entity.Schedule;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class ReadScheduleResponseDto {

    private Long scheduleId; // 일정 고유 식별자
    private Long userId; // 유저 고유 식별자
    private String title; // 제목
    private String content; // 내용
    private LocalDate createdAt; // 일정 생성일시
    private LocalDate updatedAt; // 일정 수정일시


    public ReadScheduleResponseDto(Long scheduleId, Long userId, String title, String content, LocalDate createdAt, LocalDate updatedAt) {
        this.scheduleId = scheduleId;
        this.userId = userId;
        this.title = title;
        this.content = content;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public static ReadScheduleResponseDto toScheduleResponseDto(Schedule schedule) {
        return new ReadScheduleResponseDto(schedule.getScheduleId(), schedule.getUser().getUserId(), schedule.getTitle(), schedule.getContent(), schedule.getCreatedAt(), schedule.getUpdatedAt());
    }
}
