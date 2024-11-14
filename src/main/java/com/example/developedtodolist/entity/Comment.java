package com.example.developedtodolist.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
public class Comment extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Long commentId;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "schedule_id")
    private Schedule schedule;
    @Column(name = "content")
    private String content;

    public Comment(User user,Schedule schedule,String content) {
        this.user =user;
        this.schedule=schedule;
        this.content=content;
    }

    public Comment() {
    }
}
