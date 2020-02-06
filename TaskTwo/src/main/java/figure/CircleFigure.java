package figure;

import domain.Point;
import domain.TypeFigure;
import services.OperationService;

/**
 * Класс окружности
 * @autor Самойленко Виктор
 * @version 1.0
 */
public class CircleFigure implements GeometricFigure {

    private Point center;
    private double radius;
    private OperationService operationService;

    /**
     * Конструктор создания окружности
     * @param center - центр окружности
     * @param radius - радиус окружности
     */
    public CircleFigure(Point center, double radius) {
        this.center = center;
        this.radius = radius;
        operationService = new OperationService();
        if(type()==TypeFigure.none){
            System.out.println("Ошибка в запонение фигуры!!! Радус " + radius + " <= 0");
            return;
        }
    }

    @Override
    public TypeFigure type() {
        if(radius <= 0){
            return TypeFigure.none;
        }
        return TypeFigure.circle;
    }

    @Override
    public boolean entry(Point point) {
        Point pointStartCoord = operationService.returnStartCoordinat(point, center);

        //Нахождение гипотенузы треугольника
        double hypotenuse = operationService.hypotenuseTriangle(pointStartCoord.getX(), pointStartCoord.getY());

        //сравнение гипотинузы и радиуса
        if(hypotenuse > radius){
            return false;
        }
        return true;
    }
}
