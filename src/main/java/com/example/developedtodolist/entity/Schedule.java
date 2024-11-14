package com.example.developedtodolist.entity;

import jakarta.persistence.*;
import lombok.Getter;


@Getter
@Entity
public class Schedule extends BaseEntity {
    @Id
    @Column(name = "schedule_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long scheduleId; // 일정 고유식별자
    @ManyToOne // 다대일 관계
    @JoinColumn(name = "user_id")// 조인할 컬럼명
    private User user;
    private String title;  // 제목
    private String content; // 내용
    @Column(name = "comment_count")
    private Long commentCount; // 댓글 수

    public Schedule() {

    }

    public Schedule(User user, String title, String content) {
        this.user = user;
        this.title = title;
        this.content = content;
    }

    public void updateSchedule(String title, String content) {

        this.title = title;
        this.content = content;

    }

    public Schedule(Long scheduleId, User user, String title, String content, Long commentCount) {
        this.scheduleId = scheduleId;
        this.user = user;
        this.title = title;
        this.content = content;
        this.commentCount = commentCount;
    }


}
