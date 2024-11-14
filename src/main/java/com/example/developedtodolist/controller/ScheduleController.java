package com.example.developedtodolist.controller;

import com.example.developedtodolist.dto.scheduledto.PageScheduleResponseDto;
import com.example.developedtodolist.dto.scheduledto.ScheduleRequestDto;
import com.example.developedtodolist.dto.scheduledto.ScheduleResponseDto;
import com.example.developedtodolist.dto.scheduledto.UpdateScheduleRequestDto;
import com.example.developedtodolist.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/schedules")
public class ScheduleController {

    private final ScheduleService scheduleService;

    @PostMapping("/{user_id}")
    public ResponseEntity<ScheduleResponseDto> createSchedule(@PathVariable Long user_id, @RequestBody ScheduleRequestDto requestDto) { // 일정 생성 기능

        ScheduleResponseDto scheduleResponseDto = scheduleService.savedSchedule(user_id, requestDto.getTitle(), requestDto.getContent());
        return new ResponseEntity<>(scheduleResponseDto, HttpStatus.CREATED);

    }

    @GetMapping
    public ResponseEntity<List<ScheduleResponseDto>> findScheduleAll() { // 전체 일정 조회 기능
        List<ScheduleResponseDto> list = scheduleService.findAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ScheduleResponseDto> findScheduleById(@PathVariable Long id) { // 상세 일정 조회 기능
        ScheduleResponseDto scheduleResponseDto = scheduleService.findById(id);
        return new ResponseEntity<>(scheduleResponseDto, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateSchedule(@PathVariable Long id, @RequestBody UpdateScheduleRequestDto requestDto) { // 요청한 id 와 일치하는 일정 수정 기능
        scheduleService.updateSchedule(id, requestDto.getTitle(), requestDto.getContent());

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSchedule(@PathVariable Long id) { // 요청한 id 와 일치하는 일정 삭제 기능
        scheduleService.deleteSchedule(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/page")
    public ResponseEntity<List<PageScheduleResponseDto>> pagingSchedule(@RequestParam Integer page, @RequestParam(defaultValue = "10") Integer pageSize) {
        List<PageScheduleResponseDto> pageScheduleList = scheduleService.findByPage(page, pageSize);
        return new ResponseEntity<>(pageScheduleList, HttpStatus.OK);
    }


}
