package ru.geekbrains.homework.lesson_1.polymorphism;

public class Square extends GeometricFigure{

    private int sideA;
    private int sideB;

    @Override
    void figureInfo() {
        System.out.println("периметр фигуры: "+calcPerimeter());
        System.out.println("площадь фигуры: "+calcArea());
    }

    private double calcArea() {
        return (double)(2*this.sideA+2*this.sideB);
    }

    public Square(int sideA, int sideB) {
        this.sideA = sideA;
        this.sideB = sideB;
    }

    private double calcPerimeter() {
        return (double) (this.sideA*this.sideB);
    }
}
