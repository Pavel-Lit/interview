package ru.geekbrains.homework.lesson_7.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.homework.lesson_7.converter.Converter;
import ru.geekbrains.homework.lesson_7.dto.StudentDto;
import ru.geekbrains.homework.lesson_7.service.StudentService;

import java.util.List;


@RequestMapping("api/v1/student")
@RestController
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    private final Converter converter;
    @GetMapping()
    public List<StudentDto> getAllStudent(){
        return converter.entityToDtoList(studentService.getAllStudent());

    }
    @DeleteMapping("/{id}")
    public void deleteStudentById(@PathVariable Long id){
        studentService.deleteById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void insertNewStudent(@RequestBody StudentDto studentDto){
        studentService.insertNewStudent(studentDto);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public void updateSrudent(@RequestBody StudentDto studentDto){
        studentService.updateStudent(studentDto);
    }

}
