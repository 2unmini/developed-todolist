package com.example.developedtodolist.service;

import com.example.developedtodolist.dto.scheduledto.PageScheduleResponseDto;
import com.example.developedtodolist.dto.scheduledto.ScheduleResponseDto;
import com.example.developedtodolist.entity.Comment;
import com.example.developedtodolist.entity.Schedule;
import com.example.developedtodolist.entity.User;
import com.example.developedtodolist.repository.CommentRepository;
import com.example.developedtodolist.repository.ScheduleRepository;
import com.example.developedtodolist.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import java.util.List;


@RequiredArgsConstructor
@Service
public class ScheduleService {
    private final ScheduleRepository scheduleRepository;
    private final UserRepository userRepository;
    private final CommentRepository commentRepository;
    public ScheduleResponseDto savedSchedule(Long userId,String title, String content) {
        User user = userRepository.findByIdOrElseThrow(userId);
        Schedule schedule = new Schedule(user ,title, content);
        Schedule savedSchedule = scheduleRepository.save(schedule);
        return new ScheduleResponseDto(
                savedSchedule.getScheduleId(),
                savedSchedule.getUser().getUserId()
                ,savedSchedule.getTitle()
                ,savedSchedule.getContent()
                );
    }

    public List<ScheduleResponseDto> findAll() {
        List<Schedule> scheduleList = scheduleRepository.findAll();
        return scheduleList.stream().map(ScheduleResponseDto::toScheduleResponseDto).toList();

    }

    public ScheduleResponseDto findById(Long id) {
        Schedule schedule = scheduleRepository.findByIdOrElseThrow(id);
        return ScheduleResponseDto.toScheduleResponseDto(schedule);

    }
    @Transactional
    public void updateSchedule(Long id, String title,String content ) {
        Schedule schedule = scheduleRepository.findByIdOrElseThrow(id);
        schedule.updateSchedule(title,content);
    }

    public void deleteSchedule(Long id) {
        Schedule schedule = scheduleRepository.findByIdOrElseThrow(id);
        scheduleRepository.delete(schedule);
    }

    public List<PageScheduleResponseDto> findByPage(Integer page, Integer pageSize) {
        Pageable pageable = PageRequest.of(page-1, pageSize, Sort.by("updated_at").descending());
        List<Schedule> scheduleList = scheduleRepository.countContent(pageable);
        /*
        todo
         */

        return scheduleList.stream().map(PageScheduleResponseDto::topageScheduleResponsedto).toList();
    }


}
