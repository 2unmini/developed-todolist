package com.example.developedtodolist.service;

import com.example.developedtodolist.dto.scheduledto.ScheduleResponseDto;
import com.example.developedtodolist.entity.Schedule;
import com.example.developedtodolist.entity.User;
import com.example.developedtodolist.repository.ScheduleRepository;
import com.example.developedtodolist.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;


@RequiredArgsConstructor
@Service
public class ScheduleService {
    private final ScheduleRepository scheduleRepository;
    private final UserRepository userRepository;
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
}
