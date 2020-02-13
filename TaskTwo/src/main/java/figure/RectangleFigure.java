package figure;

import domain.Point;
import domain.TypeFigure;
import services.OperationService;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * Класс прямоугольника
 * @autor Самойленко Виктор
 * @version 1.0
 */
public class RectangleFigure implements GeometricFigure {
    private OperationService operationService;
    private List<Point> points;

    /**
     * Конструктор прямоугольника и сортировка коллекции по возврастанию x
     * @param a, b, c, d - точки на координатной оси прямоугольника
     *
     */
    public RectangleFigure(Point a, Point b, Point c, Point d) {
        points = new ArrayList<>();
        points.add(a);
        points.add(b);
        points.add(c);
        points.add(d);

        Collections.sort(points);
        operationService = new OperationService();
    }

    @Override
    public TypeFigure type() {
        Point a = points.get(0);
        Point b = points.get(1);
        Point c = points.get(2);
        Point d = points.get(3);
        Point x = new Point();

        pointСheck(a, b, x);
        pointСheck(a, c, x);

        // Если найденная 4 точка равна стороне прямоугольника,то фигура прямоугольник
        if(d.equals(x) || c.equals(x)){
            return TypeFigure.rectangle;
        } else {
            return  TypeFigure.none;
        }
    }

    /**
     * Нахождение точки координаты 4 точки
     * @param a - точка A начальная от которой будет отталкиваться
     * @param b - вторая точка у которой если или координта x или y четвертой точки
     * @param x -  4 точка
     */
    private void pointСheck(Point a, Point b, Point x){
        if(a.getX() == b.getX()){
            x.setY(b.getY());
        } else {
            x.setX(b.getX());
        }
    }


    /**
     * Мутод сравнимает точку по отрезкам прямоугольника minX - maxX и minY - maxY если точка подходит по
     * параметрам то точка лежит в фигуре
     */
    @Override
    public boolean entry(Point point) {
        Point pointA = points.get(0).getY() < points.get(1).getY() ? points.get(0) : points.get(1);
        Point pointB = points.get(3).getY() > points.get(2).getY() ? points.get(3) : points.get(2);

        if (operationService.includedInLine(pointA.getX(), pointB.getX(), point.getX())
                && operationService.includedInLine(pointA.getY(), pointB.getY(), point.getY())) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "\nКвадрат со сторонами: "  +
                " a = ( " + points.get(0).getX() + " , " + points.get(0).getY() + " ), " +
                " b = ( " + points.get(1).getX() + " , " + points.get(1).getY() + " ), " +
                " c = ( " + points.get(2).getX() + " , " + points.get(2).getY() + " ), " +
                " d = ( " + points.get(3).getX() + " , " + points.get(3).getY() + " ), ";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RectangleFigure that = (RectangleFigure) o;
        return Objects.equals(points, that.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }
}
