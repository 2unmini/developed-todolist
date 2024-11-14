package com.example.developedtodolist.controller;

import com.example.developedtodolist.dto.comment.CreateCommentRequestDto;
import com.example.developedtodolist.dto.comment.CreateCommentResponseDto;
import com.example.developedtodolist.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/comments")
public class CommentController {
    private final CommentService commentService;
    @PostMapping
    public ResponseEntity<CreateCommentResponseDto> createComment(@RequestBody CreateCommentRequestDto requestDto) {
        CreateCommentResponseDto createCommentResponseDto = commentService.saveComment(requestDto.getUserId(), requestDto.getScheduleId(), requestDto.getContent());
        return new ResponseEntity<>(createCommentResponseDto, HttpStatus.CREATED);
    }
}
