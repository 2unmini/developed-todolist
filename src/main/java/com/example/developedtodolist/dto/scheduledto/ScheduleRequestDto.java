package com.example.developedtodolist.dto.scheduledto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class ScheduleRequestDto {
    @NotNull(message = "제목을 입력해주세요") //필수 값
    private String title; // 제목
    @NotNull(message = "내용을 입력해주세요") // 필수 값
    private String content; // 내용
}
