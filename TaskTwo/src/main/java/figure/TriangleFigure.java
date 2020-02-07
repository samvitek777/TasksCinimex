package figure;

import domain.Point;
import domain.TypeFigure;
import org.decimal4j.util.DoubleRounder;
import services.OperationService;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Класс треугольника
 * @autor Самойленко Виктор
 * @version 1.0
 */
public class TriangleFigure implements GeometricFigure {

    private List<Point> points;
    private OperationService operationService;

    /**
     * Конструктор треугольника записывающий точки в коллекцию и сортирующию ее
     * по возрастанию x (нужно для определения подобия треугольников и удобства)
     * @param a, b, c - точки треугольника на плоскости
     */
    public TriangleFigure(Point a, Point b, Point c) {
        points = new ArrayList<>();
        points.add(a);
        points.add(b);
        points.add(c);

        Collections.sort(points);
        operationService = new OperationService();
    }


    @Override
    public TypeFigure type() {

        //проверка на нахождении одинаковых точек
        if(points.get(0).equals(points.get(1)) || points.get(1).equals(points.get(2)) || points.get(2).equals(points.get(0))){
            return TypeFigure.none;
        }

        //коллекция длин сторон треугольника и нахождения самой длинной из них
        List<Double> list = new ArrayList<>();
        list.add(operationService.sideLength(points.get(0), points.get(1)));
        list.add(operationService.sideLength(points.get(1), points.get(2)));
        list.add(operationService.sideLength(points.get(2), points.get(0)));
        Collections.sort(list);

        //вычисление кватрада самой длиной стороны и суммы кватратов других сторон
        double cc = Math.pow(list.get(2), 2);
        double ab = Math.pow(list.get(0), 2) + Math.pow(list.get(1), 2);
        //округление результатов
        double cRounder = DoubleRounder.round(cc, 10);
        double abRounder = DoubleRounder.round(ab, 10);

        //определение типа треугольника
        if(cRounder == abRounder){
            return TypeFigure.right_triangle;
        }
        else if(list.get(0).equals(list.get(1)) || list.get(1).equals(list.get(2)) || list.get(2).equals(list.get(0))){
            return TypeFigure.isosceles_triangle;
        }

        else if (cRounder < abRounder){
            return TypeFigure.acute_triangle;
        }
        else {
            return TypeFigure.obtuse_triangle;
        }
    }

    @Override
    public boolean entry(Point point) {
        return operationService.entryPointTriangle(points.get(0), points.get(1), points.get(2), point);
    }

    public Point getA() {
        return points.get(0);
    }

    public Point getB() {
        return points.get(1);
    }

    public Point getC() {
        return points.get(2);
    }
}
