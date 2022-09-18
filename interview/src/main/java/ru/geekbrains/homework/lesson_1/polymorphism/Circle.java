package ru.geekbrains.homework.lesson_1.polymorphism;

public class Circle extends GeometricFigure{

    private int radius;

    public Circle(int radius) {
        this.radius = radius;
    }

    private Double calcPerimeter(){
        return (double) (2 * 3.14 * this.radius);
    }

    private Double calcArea(){
        double sq = Math.pow(this.radius, 2);
        return (double) (3.14* sq);
    }

    @Override
    void figureInfo() {
        System.out.println("периметр фигуры: "+calcPerimeter());
        System.out.println("площадь фигуры: "+calcArea());
    }
}
