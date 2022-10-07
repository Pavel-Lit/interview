package ru.geekbrains.homework.lesson_5.DAO;

import org.hibernate.Session;
import ru.geekbrains.homework.lesson_5.entities.Student;

import java.util.List;
import java.util.Optional;

public interface StudentDao {

    void save(Student student, Session session);

    Optional<Student> getById(int id, Session session);

    List<Student> getAll(Session session);

    void deleteById(int id, Session session);

    void update(Student student, Session session);
}
