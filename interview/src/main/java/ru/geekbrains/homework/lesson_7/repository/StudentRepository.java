package ru.geekbrains.homework.lesson_7.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.homework.lesson_7.entities.Student;


@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {


}