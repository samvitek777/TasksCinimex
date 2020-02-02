package figure;

import domain.Point;

public class CircleFigure implements GeometricFigure {

    private Point center;
    private double radius;

    public CircleFigure(Point center, double radius) {
        this.center = center;
        this.radius = radius;
    }

    @Override
    public String type() {
        return "Круг";
    }

    @Override
    public String entry(Point point) {
        //Преобразование точки в 1четверть и смещение точки в начало координат
        double x = Math.abs(point.getX()) - center.getX();
        double y = Math.abs(point.getY()) - center.getY();
        //Нахождение гипотенузы треугольника
        double hypotenuse = Math.sqrt(x*x + y*y);

        if(hypotenuse > radius){
            return "Точка не входит";
        }
        return "Точка входит";
    }
}
