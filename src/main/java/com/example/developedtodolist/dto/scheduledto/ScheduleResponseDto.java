package com.example.developedtodolist.dto.scheduledto;


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
}
