package com.example.developedtodolist.repository;

import com.example.developedtodolist.dto.scheduledto.PageScheduleResponseDto;
import com.example.developedtodolist.entity.Schedule;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule,Long> {

    default Schedule findByIdOrElseThrow(Long id){
       return findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Query(value = "select *, (Select Count(content) FROM comment AS comment_count) from schedule ",nativeQuery = true)
    List<Schedule> countContent(Pageable pageable);


}
