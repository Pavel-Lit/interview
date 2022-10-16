package ru.geekbrains.homework.lesson_7.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class StudentDto {

    private Long id;
    private String name;
    private int age;
}
