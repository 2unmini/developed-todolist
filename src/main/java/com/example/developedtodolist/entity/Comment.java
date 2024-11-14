package com.example.developedtodolist.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
public class Comment extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Long commentId; // 댓글 고유 식별자
    @ManyToOne // 다대일 관계
    @JoinColumn(name = "user_id") // 조인할 컬럼명
    private User user;
    @ManyToOne //다대일 관계
    @JoinColumn(name = "schedule_id")// 조인할 컬럼명
    private Schedule schedule;
    @Column(name = "content")
    private String content;

    public Comment(User user, Schedule schedule, String content) {
        this.user = user;
        this.schedule = schedule;
        this.content = content;
    }

    public Comment() {
    }

    public void updateComment(String content) {
        this.content = content;
    }
}
