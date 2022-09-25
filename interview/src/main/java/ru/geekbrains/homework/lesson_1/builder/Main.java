package ru.geekbrains.homework.lesson_1.builder;

public class Main {
    public static void main(String[] args) {
        Person person = Person.createBuilder()
                .withFirstName("Олег")
                .withMiddleName("Васильевич")
                .withLastName("Лабода")
                .withCountry("Россия")
                .withPhone("88003553535")
                .withGender(Gender.MALE)
                .withAge(33).build();

        System.out.println(person);


    }
}
