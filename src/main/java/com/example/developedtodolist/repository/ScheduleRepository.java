package com.example.developedtodolist.repository;

import com.example.developedtodolist.entity.Schedule;
import com.example.developedtodolist.exception.NoInformationException;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

    default Schedule findByIdOrElseThrow(Long id) {
        return findById(id).orElseThrow(NoInformationException::new);
    }

    @Query(value = "select s.schedule_id, s.user_id, s.title, s.content, s.created_at, s.updated_at, (SELECT COUNT(content) FROM comment c WHERE c.schedule_id = s.schedule_id) AS comment_count FROM schedule s ORDER BY s.updated_at DESC;", nativeQuery = true)
    List<Schedule> countContent(Pageable pageable);


}
