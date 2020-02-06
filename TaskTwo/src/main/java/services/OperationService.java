package services;

import domain.Point;

/**
 * Класс со вспомогательными методами для расчета операций с координатами точек.
 * @autor Самойленко Виктор
 * @version 1.0
 */

public class OperationService {

    /**
     * Метод возвращаемый положительное значение точки, нужен для отображения фигуры в 1четверти
     * @param point - координаты точки с положительными или отрицательными значениями
     * @return - модуль по двум точкам x и y
     */
    private Point returnAbsPoint (Point point){
        return new Point(Math.abs(point.getX()), Math.abs(point.getY()));
    }

    /**
     * Возможно обьединить методы модуля с этим
     *
     * Метод меняющее значение точки относительно началу координат и меняющее положение точки в 1 четверть
     * @param point - координаты точки которую нужно изменить
     * @param center - координаты точки относительно какой будет начало координатной оси
     * @return - измененную точку
     */
    public Point returnStartCoordinat(Point point, Point center){
        return new Point(Math.abs(point.getX()) - center.getX(), Math.abs(point.getY()) - center.getY());
    }

    public double hypotenuseTriangle(double a, double b){
        return Math.sqrt(Math.pow(a,2)+Math.pow(b,2));
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

    private boolean pointsSideLine(Point pointA, Point pointB, Point pointC, Point pointD){
        return pointRelativeLine(pointA, pointB, pointC) * pointRelativeLine(pointA, pointB, pointD) >= 0;
    }

    public boolean entryPointTriangle(Point a, Point b, Point c, Point d){
        return pointsSideLine(a,b,c,d) && pointsSideLine(b,c,a,d) && pointsSideLine(c,a,b,d);
    }
}
