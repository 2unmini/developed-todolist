package com.example.developedtodolist.entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class User extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;
    @Column(name = "user_name")
    private String username;
    private String email;
    private String password;
    @OneToMany(mappedBy = "user",cascade = CascadeType.REMOVE)
    private List<Schedule> schedules =new ArrayList<>();
    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private List<Comment> comments =new ArrayList<>();




    public User() {
    }

    public User(String username, String email) {
        this.username = username;
        this.email = email;
    }
    public User(String username,String email,String password) {
        this.username = username;
        this.email = email;
        this.password=password;
    }
}
