package com.example.developedtodolist.controller;

import com.example.developedtodolist.dto.scheduledto.ScheduleRequestDto;
import com.example.developedtodolist.dto.scheduledto.ScheduleResponseDto;
import com.example.developedtodolist.entity.Schedule;
import com.example.developedtodolist.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class ScheduleController {

    private final ScheduleService scheduleService;

    @PostMapping("/schedules")
    public ResponseEntity<ScheduleResponseDto> createSchedule(@RequestBody ScheduleRequestDto requestDto) {

        ScheduleResponseDto scheduleResponseDto = scheduleService.savedSchedule(requestDto.getUsername(), requestDto.getTitle(), requestDto.getContent());
        return new ResponseEntity<>(scheduleResponseDto, HttpStatus.CREATED);

    }
    @GetMapping("/schedules")
    public ResponseEntity<List<Schedule>> findScheduleAll() {
        List<Schedule> scheduleList = scheduleService.findAll();
        return new ResponseEntity<>(scheduleList,HttpStatus.OK);
    }
}
