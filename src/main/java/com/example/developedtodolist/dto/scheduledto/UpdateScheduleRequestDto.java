package com.example.developedtodolist.dto.scheduledto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class UpdateScheduleRequestDto {
    @NotNull(message = "제목을 입력해주세요")
    private String title;
    @NotNull(message = "내용을 입력해주세요")
    private String content;

    public UpdateScheduleRequestDto(Long userId, String title, String content) {
        this.title = title;
        this.content = content;
    }

}
