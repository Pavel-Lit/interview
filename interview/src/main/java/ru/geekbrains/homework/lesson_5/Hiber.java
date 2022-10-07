package ru.geekbrains.homework.lesson_5;

import org.hibernate.Session;
import ru.geekbrains.homework.lesson_5.connection.HiberConnection;
import ru.geekbrains.homework.lesson_5.entities.Student;
import ru.geekbrains.homework.lesson_5.service.ServiceSessionInside;
import ru.geekbrains.homework.lesson_5.service.StudentService;

import java.util.List;

public class Hiber {

    public static void main(String[] args) {
        Session session = HiberConnection.getSessionFactory().openSession();
//        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
//                .addAnnotatedClass(Student.class)
//                .buildSessionFactory();


//        Session session = factory.getCurrentSession();
//        Student student = new Student("Test", 88);
//        session.beginTransaction();
//        session.save(student);
//        session.remove(student);
//        Student student1 = session.get(Student.class, 1);
//        System.out.println(student1);
//
//        session.close();
//        StudentService service = new StudentService();
//        session.beginTransaction();
//        Student student = new Student();
////        insertStudents(session, service, 1000);
//        List<Student> studentList;
//        studentList = service.getAll(session);
//        Student student1 = studentList.get(44);
//        System.out.println(student1.toString());
//        System.out.println(studentList);
//        service.deleteById(6, session);
//        student = studentList.get(1);
//        student.setName("Valera");
//        student.setMark(100500);
//        service.update(student, session);
//
//
//
//
//
//        session.close();
//        HiberConnection.shutdown();
        ServiceSessionInside serviceSessionInside = new ServiceSessionInside();
//        insertStudentsWhithoutSession(serviceSessionInside, 100);
        System.out.println(serviceSessionInside.getById(100));
        List<Student> studentList;
        studentList = serviceSessionInside.getAll();
        Student student = studentList.get(2);
        student.setName("Igor");
        student.setMark(100500);
        serviceSessionInside.update(student);

    }

    private static void insertStudents(Session session, StudentService service, int amount) {

        for (int i = 0; i < amount; i++) {
            Student student = new Student();
            student.setName("student"+(i));
            student.setMark((int) (Math.random() * 10));
            service.save(student, session);
        }

    }
    private static void insertStudentsWithoutSession(ServiceSessionInside service, int amount) {

        for (int i = 0; i < amount; i++) {
            Student student = new Student();
            student.setName("student"+(i));
            student.setMark((int) (Math.random() * 10));
            service.save(student);
        }

    }

}
