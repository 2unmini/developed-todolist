package com.example.developedtodolist.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class) // 공통으로 사용되는 등록일 수정일을 추상메소드로 생성
public abstract class BaseEntity {
    @CreatedDate
    @Column(updatable = false)
    private LocalDate createdAt;
    @LastModifiedDate
    private LocalDate updatedAt;
}
