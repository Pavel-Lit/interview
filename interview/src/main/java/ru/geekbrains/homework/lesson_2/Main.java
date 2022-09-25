package ru.geekbrains.homework.lesson_2;

public class Main {

    public static void main(String[] args) {
        SimpleArrayList<Integer> test = new SimpleArrayList<>();

        test.add(1);
        test.add(2);
        test.add(3);
        test.add(4);
        test.add(5);
        System.out.println(test.getElementByIndex(1));
        test.removeElementByIndex(1);
        System.out.println(test);
        SimpleLinkedList<Integer> integerSimpleLinkedList = new SimpleLinkedList<>();
        integerSimpleLinkedList.add(1);
        integerSimpleLinkedList.add(2);
        integerSimpleLinkedList.add(3);
        integerSimpleLinkedList.add(4);
        integerSimpleLinkedList.remove(3);
        System.out.println("LinkedList");
        System.out.println(integerSimpleLinkedList);
    }
}
