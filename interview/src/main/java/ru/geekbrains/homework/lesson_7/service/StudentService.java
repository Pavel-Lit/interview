package ru.geekbrains.homework.lesson_7.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.homework.lesson_7.dto.StudentDto;
import ru.geekbrains.homework.lesson_7.entities.Student;
import ru.geekbrains.homework.lesson_7.repository.StudentRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService  {

    private final StudentRepository studentRepository;

    public List<Student> getAllStudent(){
        return studentRepository.findAll();

    }

    public void deleteById(Long id){
        studentRepository.deleteById(id);
    }

    public void insertNewStudent(StudentDto studentDto){
        Student student = new Student();
        student.setAge(studentDto.getAge());
        student.setName(studentDto.getName());
        studentRepository.save(student);


    }
    @Transactional
    public void updateStudent(StudentDto studentDto){
        Student student = studentRepository.findById(studentDto.getId()).orElseThrow(()->new IllegalStateException("student not found with name "+studentDto.getId()));
        student.setName(studentDto.getName());
        student.setAge(studentDto.getAge());
        studentRepository.save(student);
    }
}
