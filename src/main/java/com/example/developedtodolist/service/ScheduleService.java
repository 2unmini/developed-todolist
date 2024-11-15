package com.example.developedtodolist.service;

import com.example.developedtodolist.dto.scheduledto.CreateScheduleResponseDto;
import com.example.developedtodolist.dto.scheduledto.PageScheduleResponseDto;
import com.example.developedtodolist.dto.scheduledto.ReadScheduleResponseDto;
import com.example.developedtodolist.entity.Schedule;
import com.example.developedtodolist.entity.User;
import com.example.developedtodolist.repository.ScheduleRepository;
import com.example.developedtodolist.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;


@RequiredArgsConstructor
@Service
public class ScheduleService {
    private final ScheduleRepository scheduleRepository;
    private final UserRepository userRepository;

    public CreateScheduleResponseDto savedSchedule(Long userId, String title, String content) { // 일정 생성 로직
        User user = userRepository.findByIdOrElseThrow(userId);
        Schedule schedule = new Schedule(user, title, content);
        Schedule savedSchedule = scheduleRepository.save(schedule);
        return new CreateScheduleResponseDto(
                savedSchedule.getScheduleId(),
                savedSchedule.getUser().getUserId()
                , savedSchedule.getTitle()
                , savedSchedule.getContent()
                , savedSchedule.getCreatedAt()
        );
    }

    public List<ReadScheduleResponseDto> findAll() {
        List<Schedule> scheduleList = scheduleRepository.findAll(); // 전체 일정 정보 조회 로직
        return scheduleList.stream().map(ReadScheduleResponseDto::toScheduleResponseDto).toList();

    }

    public ReadScheduleResponseDto findById(Long id) { // 상세 일정 조회 로직
        Schedule schedule = scheduleRepository.findByIdOrElseThrow(id);
        return ReadScheduleResponseDto.toScheduleResponseDto(schedule);

    }

    @Transactional
    public void updateSchedule(Long id, String title, String content) { // 일정 수정 로직
        Schedule schedule = scheduleRepository.findByIdOrElseThrow(id);
        schedule.updateSchedule(title, content);
    }

    public void deleteSchedule(Long id) { // 유저 삭제 로직
        Schedule schedule = scheduleRepository.findByIdOrElseThrow(id);
        scheduleRepository.delete(schedule);
    }

    public List<PageScheduleResponseDto> findByPage(Integer page, Integer pageSize) { // 페이지별 조회 로직
        Pageable pageable = PageRequest.of(page - 1, pageSize, Sort.by("updated_at").descending());
        List<Schedule> scheduleList = scheduleRepository.countContent(pageable);
        /*
        todo
         */

        return scheduleList.stream().map(PageScheduleResponseDto::topageScheduleResponsedto).toList(); // ResponseDto 형태의 리스트로 변환후 리턴
    }

}
