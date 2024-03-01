package com.example.statisticsapi;

import com.github.cloudyrock.spring.v5.EnableMongock;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableMongock
@EnableScheduling
public class StatisticsApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(StatisticsApiApplication.class, args);
    }

}
