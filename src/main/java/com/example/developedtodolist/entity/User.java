package com.example.developedtodolist.entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId; // 유저 고유 식별자
    @Column(name = "user_name")
    private String username; // 유저 이름
    private String email; //이메일
    private String password; //패스워드
    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE) // 일대다 관계, 유저가 삭제되면 관련된 일정도 연쇄적 삭제
    private List<Schedule> schedules = new ArrayList<>();
    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE) // 일대다 관계, 유저가 삭제되면 관련된 댓글도 연쇄적 삭제
    private List<Comment> comments = new ArrayList<>();


    public User() {
    }

    public User(String username, String email) {
        this.username = username;
        this.email = email;
    }

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }
}
