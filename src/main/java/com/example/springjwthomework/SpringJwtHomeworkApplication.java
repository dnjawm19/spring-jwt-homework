package com.example.springjwthomework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class SpringJwtHomeworkApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringJwtHomeworkApplication.class, args);
    }

}
