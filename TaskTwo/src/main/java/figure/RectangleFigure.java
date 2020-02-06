package figure;

import domain.Point;
import domain.TypeFigure;
import services.OperationService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
     * Конструктор прямоугольника и сортировка массива для нахождения самого мальнького значения и самого большого
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

        /*Collections.sort(points, new Comparator<Point>() {
            @Override
            public int compare(Point point, Point t1) {
                if(point.getX() <= t1.getX() && point.getY() <= t1.getY()){
                    return -1;
                } else return 1;
            }
        });*/
        operationService = new OperationService();
    }

    @Override
    public TypeFigure type() {
        Point pointA = points.get(0);
        Point pointB = points.get(3);

        //Доделать проверку

        return TypeFigure.rectangle;

    }


    @Override
    public boolean entry(Point point) {
        Point pointA = points.get(0);
        Point pointB = points.get(3).getY() > points.get(2).getY() ? points.get(3) : points.get(2);

        if (operationService.includedInLine(pointA.getX(), pointB.getX(), point.getX())
                && operationService.includedInLine(pointA.getY(), pointB.getY(), point.getY())) {
            return true;
        }
        return false;
    }
}
