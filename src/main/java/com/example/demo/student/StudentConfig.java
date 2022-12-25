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
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {
            Student thimal = new Student(
                    "Thimal Ushara",
                    "thimal@gmail.com",
                    LocalDate.of(1999,Month.SEPTEMBER,21)
            );

            Student kasun = new Student(
                    "Kasun Kalhara",
                    "kasun@gmail.com",
                    LocalDate.of(1979,Month.MAY,11)
            );
            Student avishka = new Student(
                    "Avishka Bandara",
                    "avishka@gmail.com",
                    LocalDate.of(1989,Month.JANUARY,8)
            );

            repository.saveAll(
                    List.of(thimal, kasun, avishka)
            );

        };
    }
}
