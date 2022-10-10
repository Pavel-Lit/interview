package ru.geekbrains.homework.lesson_5;

import ru.geekbrains.homework.lesson_5.entities.Student;
import ru.geekbrains.homework.lesson_5.service.ServiceSessionInside;

import java.util.List;

public class Hiber {

    public static void main(String[] args) {


        homeWorkSessionInside();

    }

    private static void homeWorkSessionInside() {
        ServiceSessionInside serviceSessionInside = new ServiceSessionInside();
        serviceSessionInside.saveAmountRandomStudents(1000);
        System.out.println(serviceSessionInside.getById(100));
        List<Student> studentList;
        studentList = serviceSessionInside.getAll();
        Student student = studentList.get(2);
        student.setName("Igor");
        student.setMark(100500);
        serviceSessionInside.update(student);
    }




}
