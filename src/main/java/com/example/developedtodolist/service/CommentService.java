package com.example.developedtodolist.service;

import com.example.developedtodolist.dto.comment.CreateCommentResponseDto;
import com.example.developedtodolist.dto.comment.ReadCommentResponseDto;
import com.example.developedtodolist.dto.comment.UpdateCommentRequestDto;
import com.example.developedtodolist.entity.Comment;
import com.example.developedtodolist.entity.Schedule;
import com.example.developedtodolist.entity.User;
import com.example.developedtodolist.repository.CommentRepository;
import com.example.developedtodolist.repository.ScheduleRepository;
import com.example.developedtodolist.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final ScheduleRepository scheduleRepository;
    public CreateCommentResponseDto saveComment(Long userId,Long scheduleId,String content) {
        User user = userRepository.findByIdOrElseThrow(userId);
        Schedule schedule = scheduleRepository.findByIdOrElseThrow(scheduleId);
        Comment savedComment = commentRepository.save(new Comment(user,schedule,content));
        return new CreateCommentResponseDto(savedComment.getCommentId()
                ,savedComment.getUser().getUserId()
                ,savedComment.getSchedule().getScheduleId()
                ,savedComment.getContent()
                ,savedComment.getCreatedAt());
    }

    public ReadCommentResponseDto findCommentById(Long commentId) {
        Comment comment = commentRepository.findById(commentId).orElseThrow();

        return new ReadCommentResponseDto(comment);


    }
    @Transactional
    public void updateCommentById(Long commentId, UpdateCommentRequestDto updateCommentRequestDto) {
        Comment comment = commentRepository.findById(commentId).orElseThrow();
        comment.updateComment(updateCommentRequestDto.getContent());
    }

    public void deleteCommentById(Long id) {
        commentRepository.deleteById(id);
    }
}
