package ru.geekbrains.homework.lesson_1.polymorphism;

public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle(5);
        RightTriangle rightTriangle = new RightTriangle(2, 2);
        Square square = new Square(4, 4);
        System.out.println("круг");
        circle.figureInfo();
        System.out.println("квадрат");
        square.figureInfo();
        System.out.println("треугольник");
        rightTriangle.figureInfo();
    }
}
