package com.example.developedtodolist.dto.scheduledto;


import com.example.developedtodolist.entity.Schedule;
import lombok.Getter;

@Getter
public class ScheduleResponseDto {

    private Long scheduleId; // 일정 고유 식별자
    private Long userId; // 유저 고유 식별자
    private String title; // 제목
    private String content; // 내용


    public ScheduleResponseDto(Long scheduleId, Long userId, String title, String content) {
        this.scheduleId = scheduleId;
        this.userId = userId;
        this.title = title;
        this.content = content;
    }

    public static ScheduleResponseDto toScheduleResponseDto(Schedule schedule) {
        return new ScheduleResponseDto(schedule.getScheduleId(), schedule.getUser().getUserId(), schedule.getTitle(), schedule.getContent());
    }
}
