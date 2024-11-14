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
    @ManyToOne
    @JoinColumn(name = "user_id")
    private  User user;
    private  String title;
    private  String content;

    public Schedule() {

    }

    public Schedule( User user ,String title, String content) {
        this.user = user;
        this.title=title;
        this.content=content;
    }

    public void updateSchedule(String title,String content) {

        this.title=title;
        this.content=content;

    }


}
