package ru.geekbrains.homework.lesson_5.service;

import org.hibernate.Session;
import ru.geekbrains.homework.lesson_5.DAO.StudentDaoWithoutSession;
import ru.geekbrains.homework.lesson_5.connection.HiberConnection;
import ru.geekbrains.homework.lesson_5.entities.Student;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ServiceSessionInside implements StudentDaoWithoutSession {

    private Session session;


    private void openSession(){
        session = HiberConnection.getSessionFactory().openSession();
        session.beginTransaction();
    }

    @Override
    public void save(Student student) {
        openSession();
        session.save(student);
        session.close();
    }

    public void saveAmountRandomStudents(int amount){
        openSession();
        for (int i = 0; i < amount; i++) {
            Student student = new Student();
            student.setName("Student"+i);
            student.setMark((int) (Math.random()*10));
            session.save(student);
        }
        session.close();


    }

    @Override
    public Optional<Student> getById(int id) {
        openSession();
        Optional<Student> student =Optional.ofNullable(session.get(Student.class, id));
        session.close();
        return student;
    }

    @Override
    public List<Student> getAll() {
        List<Student> list = new ArrayList<>(1000);
        openSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Student> cq = cb.createQuery(Student.class);
        Root<Student> rootEntry = cq.from(Student.class);
        CriteriaQuery<Student> all = cq.select(rootEntry);

        TypedQuery<Student> allQuery = session.createQuery(all);
        list = allQuery.getResultList();
        session.close();
        return list;
    }

    @Override
    public void deleteById(int id) {
        openSession();
        Student s = session.get(Student.class, id);
        session.remove(s);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void update(Student student) {
        openSession();
        session.update(student);
        session.getTransaction().commit();
        session.close();
    }
}
