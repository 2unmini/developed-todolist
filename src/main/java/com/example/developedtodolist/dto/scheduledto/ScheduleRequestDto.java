package com.example.developedtodolist.dto.scheduledto;

import lombok.Getter;

@Getter
public class ScheduleRequestDto {
    private Long userId;
    private String title;
    private String content;
}
