package services;

import domain.Point;

/**
 * Класс со вспомогательными методами для расчета операций с координатами точек.
 * @autor Самойленко Виктор
 * @version 1.0
 */

public class OperationService {

    /**
     * Метод меняющее значение точки относительно началу координат и меняющее положение точки в 1 четверть
     * @param point - координаты точки которую нужно изменить
     * @param center - координаты точки относительно какой будет начало координатной оси
     * @return - измененную точку
     */
    public Point returnStartCoordinat(Point point, Point center){
        return new Point(Math.abs(point.getX()) - center.getX(), Math.abs(point.getY()) - center.getY());
    }

    /**
     * Метод для нахождения точки в отрезке или вне его
     * @param a - точка начала отрезка
     * @param b - точка конца отрезка
     * @param point - точка для которой нужно найти входит она ли в этот отрезок
     * @return - входит или нет
     */
    public boolean includedInLine(double a, double b, double point){
        if(a <= point && point <= b) return true;
        return false;
    }

    /**
     *  Метод  для определения длинны отрезка по двум точкам на плоскости
     * @param a - точка начала отрезка на плоскости
     * @param b - точка конца отрезка на плоскости
     * @return - длинны отрезка
     */
    public double sideLength(Point a, Point b){

        return Math.sqrt(Math.pow(a.getX() - b.getX(), 2) + Math.pow(a.getY() - b.getY(), 2));
    }

    /**
     * Метод вычесляющий положение точки относительно прямой
     * @param pointOne - координаты точки начала прямой
     * @param pointTwo - координаты точки конца прямой
     * @param pointX - координаты точки отношение которой нужно узнать
     * @return - число. Если оно больше 0, то точка находится правее отрезка.
     *                  Если оно меньше 0, то точка находится левее отрезка.
     *                  Если оно равно 0, то точка находится на отрезке
     */
    private double pointRelativeLine(Point pointOne, Point pointTwo, Point pointX){
        return (pointX.getX()-pointOne.getX())*(pointTwo.getY()-pointOne.getY())
                -(pointX.getY()-pointOne.getY())*(pointTwo.getX()-pointOne.getX());
    }

    /**
     * Метод для оперделения лежат ли точки 2 точки C и D по одну сторону с отрезком AB
     * @param pointA - первая точка прямоугольника
     * @param pointB - вторая точка треугольника
     * @param pointC - третья точка треугольника
     * @param pointD - точка на плоскости для которой нужно определить вхождения в фигуру
     * @return true - лежат, false - не лежат
     */
    private boolean pointsSideLine(Point pointA, Point pointB, Point pointC, Point pointD){
        return pointRelativeLine(pointA, pointB, pointC) * pointRelativeLine(pointA, pointB, pointD) >= 0;
    }

    /**
     *  Метод определяющий вхождение точки d в треугольник abc
     * @param a - первая точка прямоугольника
     * @param b - вторая точка треугольника
     * @param c - третья точка треугольника
     * @param d - точка на плоскости для которой нужно определить вхождения в фигуру
     * @return - вхождение точки в треугольник
     */
    public boolean entryPointTriangle(Point a, Point b, Point c, Point d){
        return pointsSideLine(a,b,c,d) && pointsSideLine(b,c,a,d) && pointsSideLine(c,a,b,d);
    }
}
