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
    public Point returnAbsPoint (Point point){
        return new Point(Math.abs(point.getX()), Math.abs(point.getY()));
    }

    /**
     * Метод меняющее значение точки относительно началу координат
     * @param point - координаты точки которую нужно изменить
     * @param center - координаты точки относительно какой будет начало координатной оси
     * @return - измененную точку
     */
    public Point returnStartCoordinat(Point point, Point center){
        return new Point(point.getX() - center.getX(), point.getY()-center.getY());
    }

    /**
     * Метод вычесляющий положение точки отночительно прямой
     * @param pointOne - координаты точки начала прямой
     * @param pointTwo - координаты точки конца прямой
     * @param pointX - координаты точки отношение которой нужно узнать
     * @return - число. Если оно больше 0, то точка находится правее отрезка.
     *                  Если оно меньше 0, то точка находится левее отрезка.
     *                  Если оно равно 0, то точка находится на отрезке
     */
    public double pointRelativeLine(Point pointOne, Point pointTwo, Point pointX){
        return (pointX.getX()-pointOne.getX())*(pointTwo.getY()-pointOne.getY())
                -(pointX.getY()-pointOne.getY())*(pointTwo.getX()-pointOne.getX());
    }
}
