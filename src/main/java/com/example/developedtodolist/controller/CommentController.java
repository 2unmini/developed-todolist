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
    public ResponseEntity<CreateCommentResponseDto> createComment(@RequestBody CreateCommentRequestDto requestDto) { // 댓글 생성 기능
        CreateCommentResponseDto createCommentResponseDto = commentService.saveComment(requestDto.getUserId(), requestDto.getScheduleId(), requestDto.getContent());
        return new ResponseEntity<>(createCommentResponseDto, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReadCommentResponseDto> readComment(@PathVariable Long id) { // // 요청한 id 와 일치하는 댓글 조회 기능
        ReadCommentResponseDto readCommentResponseDto = commentService.findCommentById(id);
        return new ResponseEntity<>(readCommentResponseDto, HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> updateComment(@PathVariable Long id, @RequestBody UpdateCommentRequestDto requestDto) { // // 요청한 id 와 일치하는 댓글 수정 기능 (댓글만 수정할수 있음)
        commentService.updateCommentById(id, requestDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteComment(@PathVariable Long id) { // // 요청한 id 와 일치하는 댓글 삭제 기능
        commentService.deleteCommentById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
