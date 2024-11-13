package com.example.developedtodolist.repository;

import com.example.developedtodolist.dto.scheduledto.ScheduleResponseDto;
import com.example.developedtodolist.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;
@Repository
public interface ScheduleRepository extends JpaRepository<Schedule,Long> {

    default Schedule findByIdOrElseThrow(Long id){
       return findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
