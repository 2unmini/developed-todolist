package com.example.developedtodolist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class DevelopedTodolistApplication {

    public static void main(String[] args) {
        SpringApplication.run(DevelopedTodolistApplication.class, args);
    }

}
