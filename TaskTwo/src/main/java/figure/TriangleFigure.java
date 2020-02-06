package figure;

import domain.Point;
import domain.TypeFigure;
import services.OperationService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TriangleFigure implements GeometricFigure {

    private List<Point> points;
    private OperationService operationService;

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
        System.out.println(points);
        return TypeFigure.isosceles_triangle;
    }

    @Override
    public boolean entry(Point point) {
        return operationService.entryPointTriangle(points.get(0), points.get(1), points.get(2), point);
    }
}
