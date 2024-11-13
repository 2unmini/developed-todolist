package com.example.developedtodolist.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
public class Schedule extends BaseEntity{
    @Id
    @Column(name = "schedule_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long scheduleId;
    @Column(name = "user_id")
    private  Long userId;
    private  String title;
    private  String content;

    public Schedule() {

    }

    public Schedule(Long userId, String title, String content) {
        this.userId=userId;
        this.title=title;
        this.content=content;
    }

    public void updateSchedule(Long userId, String title, String content) {
        this.userId=userId;
        this.title=title;
        this.content=content;
    }

}
