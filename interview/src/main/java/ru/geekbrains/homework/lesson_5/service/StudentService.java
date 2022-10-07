package ru.geekbrains.homework.lesson_5.service;

import org.hibernate.Session;
import ru.geekbrains.homework.lesson_5.DAO.StudentDao;
import ru.geekbrains.homework.lesson_5.connection.HiberConnection;
import ru.geekbrains.homework.lesson_5.entities.Student;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StudentService implements StudentDao {

//    private Session session = HiberConnection.getSessionFactory().openSession();
    private Session session;


    private void openSession(){
        this.session = HiberConnection.getSessionFactory().openSession();
        this.session.beginTransaction();
    }


    @Override
    public void save(Student student, Session session) {
//        openSession();
        session.save(student);
//        session.getTransaction().isActive();
//        session.close();
    }

    @Override
    public Optional<Student> getById(int id, Session session) {
//        Optional<Student> student = new Student();
//            session.beginTransaction();
            Optional<Student> student = Optional.ofNullable(session.get(Student.class, id));
//            session.close();
        return Optional.empty();
    }

    @Override
    public List<Student> getAll(Session session) {
        List<Student> list = new ArrayList<>(1000);
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Student> cq = cb.createQuery(Student.class);
        Root<Student> rootEntry = cq.from(Student.class);
        CriteriaQuery<Student> all = cq.select(rootEntry);

        TypedQuery<Student> allQuery = session.createQuery(all);

        return allQuery.getResultList();
    }

    @Override
    public void deleteById(int id, Session session) {
        Student student = session.get(Student.class, id);
        session.remove(student);
        session.getTransaction().commit();
    }

    @Override
    public void update(Student student, Session session) {
        session.update(student);
        session.getTransaction().commit();


    }
}
