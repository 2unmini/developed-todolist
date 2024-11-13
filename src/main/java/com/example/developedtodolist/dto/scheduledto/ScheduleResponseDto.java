package com.example.developedtodolist.dto.scheduledto;


import com.example.developedtodolist.entity.Schedule;
import lombok.Getter;

@Getter
public class ScheduleResponseDto {

    private Long scheduleId;
    private Long userId;
    private String title;
    private String content;


    public ScheduleResponseDto(Long scheduleId, Long userId, String title, String content) {
        this.scheduleId=scheduleId;
        this.userId=userId;
        this.title=title;
        this.content=content;
    }

    public static ScheduleResponseDto toDto(Schedule schedule) {
        return new ScheduleResponseDto(schedule.getScheduleId(),schedule.getUserId(),schedule.getTitle(),schedule.getContent());
    }
}
