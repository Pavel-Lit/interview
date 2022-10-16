package ru.geekbrains.homework.lesson_7.converter;

import org.springframework.stereotype.Component;
import ru.geekbrains.homework.lesson_7.dto.StudentDto;
import ru.geekbrains.homework.lesson_7.entities.Student;

import java.util.ArrayList;
import java.util.List;

@Component
public class Converter {

    public List<StudentDto> entityToDtoList(List<Student> students){
        List<StudentDto> list = new ArrayList<>();
        for (Student  student:students ) {


            StudentDto s = new StudentDto();
            s.setAge(student.getAge());
            s.setId(student.getId());
            s.setName(student.getName());
            list.add(s);
        }
        return list;
    }


}
