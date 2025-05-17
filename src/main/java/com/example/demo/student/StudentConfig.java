package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            Student vannda = new Student(
                    "Kung Sovannda",
                    LocalDate.of(2006, Month.NOVEMBER, 18),
                    "vannda@gmail.com"
            );
            Student nit = new Student(
                    "Hiem Sreynit",
                    LocalDate.of(2005, Month.DECEMBER, 22),
                    "nit@gmail.com"
            );
            repository.saveAll(List.of(vannda, nit));
        };
    }
}
