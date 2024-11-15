package com.example.developedtodolist.repository;

import com.example.developedtodolist.entity.Comment;
import com.example.developedtodolist.exception.NoInformationException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    default Comment findByIdOrElseThrow(Long id) {
        return findById(id).orElseThrow(NoInformationException::new);
    }
}
