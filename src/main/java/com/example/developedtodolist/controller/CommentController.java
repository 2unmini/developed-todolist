package com.example.developedtodolist.controller;

import com.example.developedtodolist.dto.comment.CreateCommentRequestDto;
import com.example.developedtodolist.dto.comment.CreateCommentResponseDto;
import com.example.developedtodolist.dto.comment.ReadCommentResponseDto;
import com.example.developedtodolist.dto.comment.UpdateCommentRequestDto;
import com.example.developedtodolist.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/{id}")
    public ResponseEntity<ReadCommentResponseDto> readComment(@PathVariable Long id) {
        ReadCommentResponseDto readCommentResponseDto = commentService.findCommentById(id);
        return new ResponseEntity<>(readCommentResponseDto,HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> updateComment(@PathVariable Long id ,@RequestBody UpdateCommentRequestDto requestDto ) {
        commentService.updateCommentById(id,requestDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
