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
    @Column(name = "user_name")
    private  String username;
    private  String title;
    private  String content;

    public Schedule() {

    }

    public Schedule(String username, String title, String content) {
        this.username=username;
        this.title=title;
        this.content=content;
    }
}
