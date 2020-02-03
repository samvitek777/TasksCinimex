package figure;

import domain.Point;
import services.OperationService;

public class RectangleFigure implements GeometricFigure {
    private Point a, b, c, d;
    private OperationService operationService;

    public RectangleFigure(Point a, Point b, Point c, Point d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        operationService = new OperationService();
    }

    @Override
    public String type() {
        return "Прямоугольник";
    }

    @Override
    public String entry(Point point) {
        double minX = min(min(a.getX(),b.getX()),min(c.getX(),d.getX()));
        double minY = min(min(a.getY(),b.getY()),min(c.getY(),d.getY()));
        double maxX = max(max(a.getX(),b.getX()),max(c.getX(),d.getX()));
        double maxY = max(max(a.getY(),b.getY()), max(c.getY(),d.getY()));

        System.out.println(minX + " " + minY + " " + maxX + " " + maxY);
        System.out.println(operationService.returnAbsPoint(a));

        if(point.getX() >= minX && point.getX() <= maxX && point.getY() >= minY && point.getY() <= maxY){
            return "Точка входит";
        }

        return "Точка не входит";
    }

    private double min(double x, double y){
        return x < y ? x : y;
    }

    private double max(double x, double y){
        return x > y ? x : y;
    }

}
