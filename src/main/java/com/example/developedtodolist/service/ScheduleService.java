package com.example.developedtodolist.service;

import com.example.developedtodolist.dto.scheduledto.ScheduleResponseDto;
import com.example.developedtodolist.entity.Schedule;
import com.example.developedtodolist.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@RequiredArgsConstructor
@Service
public class ScheduleService {
    private final ScheduleRepository scheduleRepository;
    public ScheduleResponseDto savedSchedule(String username, String title, String content) {
        Schedule schedule = new Schedule(username, title, content);
        Schedule savedSchedule = scheduleRepository.save(schedule);
        return new ScheduleResponseDto(
                savedSchedule.getScheduleId()
                ,savedSchedule.getUsername()
                ,savedSchedule.getTitle()
                ,savedSchedule.getContent()
                );
    }

    public List<ScheduleResponseDto> findAll() {
        List<Schedule> scheduleList = scheduleRepository.findAll();
        return scheduleList.stream().map(ScheduleResponseDto::toDto).toList();

    }

    public ScheduleResponseDto findById(Long id) {
        Schedule schedule = scheduleRepository.findByIdOrElseThrow(id);
        return ScheduleResponseDto.toDto(schedule);

    }
}
