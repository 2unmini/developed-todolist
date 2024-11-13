package com.example.developedtodolist.dto.scheduledto;


import com.example.developedtodolist.entity.Schedule;
import lombok.Getter;

@Getter
public class ScheduleResponseDto {

    private Long scheduleId;
    private String username;
    private String title;
    private String content;


    public ScheduleResponseDto(Long scheduleId, String username, String title, String content) {
        this.scheduleId=scheduleId;
        this.username=username;
        this.title=title;
        this.content=content;
    }

    public static ScheduleResponseDto toDto(Schedule schedule) {
        return new ScheduleResponseDto(schedule.getScheduleId(),schedule.getUsername(),schedule.getTitle(),schedule.getContent());
    }
}
