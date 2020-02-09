package figure;

import domain.Point;
import domain.TypeFigure;
import services.OperationService;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

        return TypeFigure.rectangle;
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
        return "Квадрат со сторонами: "  +
                " a " + points.get(0) +
                ", b " + points.get(1) +
                ", c " + points.get(2) +
                ", d " + points.get(3);
    }
}
