package ru.geekbrains.homework.lesson_1.polymorphism;

public class RightTriangle extends GeometricFigure{
    private int cathetA;
    private int cathetB;

    public RightTriangle(int cathetA, int cathetB) {
        this.cathetA = cathetA;
        this.cathetB = cathetB;
    }

    @Override
    void figureInfo() {
        System.out.println("периметр фигуры: "+calcPerimeter());
        System.out.println("площадь фигуры: "+calcArea());
    }

    private double calcPerimeter(){
        double hipo = Math.sqrt((Math.pow(this.cathetA, 2)+Math.pow(this.cathetB,2)));
        double temp = hipo+this.cathetB+this.cathetA;
        return temp;
    }

    private double calcArea(){
        return (this.cathetA * this.cathetB)*0.5;
    }
}
