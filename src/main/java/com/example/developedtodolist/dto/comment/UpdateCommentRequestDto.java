package com.example.developedtodolist.dto.comment;

import lombok.Getter;

@Getter
public class UpdateCommentRequestDto { // 수정시 요청할 dto
    private String content; // 수정할 댓글

}
