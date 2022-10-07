package ru.geekbrains.homework.lesson_5.connection;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.geekbrains.homework.lesson_5.entities.Student;

public class HiberConnection {

    private static SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        return new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown(){
        getSessionFactory().close();
    }
}
