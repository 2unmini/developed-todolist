package com.example.developedtodolist.dto.comment;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class UpdateCommentRequestDto { // 수정시 요청할 dto
    @NotBlank(message = "내용을 입력해주세요")
    private String content; // 수정할 댓글

}
