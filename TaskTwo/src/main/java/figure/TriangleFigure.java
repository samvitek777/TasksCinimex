package figure;

import domain.Point;

public class TriangleFigure implements GeometricFigure {

    private Point a, b, c;

    public TriangleFigure(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }


    @Override
    public String type() {
        return "Треугольник";
    }

    @Override
    public String entry(Point point) {
        return null;
    }
}
