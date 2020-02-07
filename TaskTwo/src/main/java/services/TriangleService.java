package services;

import domain.Point;
import figure.TriangleFigure;
import org.decimal4j.util.DoubleRounder;

/**
 * Класс со вспомогательными методами для работы с треугольником.
 * @autor Самойленко Виктор
 * @version 1.0
 */
public class TriangleService {
    private OperationService operationService = new OperationService();

    /**
     * Метод для опеределения подобия по отношению длинны сторон треугольников (AB/A1B1 = BC/B1C1 = CA/C1A1)
     * @param triangleFigureOne - первый треугольник
     * @param triangleFigureTwo - второй треугольник
     * @return - true подобны, false-не подобны
     */
    public boolean similarityTriangles(TriangleFigure triangleFigureOne, TriangleFigure triangleFigureTwo){
        double ratioAB = ratio(triangleFigureOne.getA(), triangleFigureOne.getB(), triangleFigureTwo.getA(),triangleFigureTwo.getB());
        double ratioBC = ratio(triangleFigureOne.getB(), triangleFigureOne.getC(), triangleFigureTwo.getB(), triangleFigureTwo.getC());
        double ratioCA = ratio(triangleFigureOne.getC(), triangleFigureOne.getA(), triangleFigureTwo.getC(), triangleFigureTwo.getA());
        return ratioAB == ratioBC && ratioBC == ratioCA;
    }

    /**
     * Метод для определения отношения длинны 2х отрезков
     * @param AOne - начало 1точки отрезка на плоскости
     * @param BOne - конец 1точки отрезка на плоскости
     * @param ATwo - начало 2точки отрезка на плоскости
     * @param BTwo - конец 2точки отрезка на плоскости
     * @return Округленное число отношения
     */
    private double ratio(Point AOne, Point BOne, Point ATwo, Point BTwo){
        double x = operationService.sideLength(AOne, BOne)
                / operationService.sideLength(ATwo, BTwo);

        double xRounder = DoubleRounder.round(x, 10);
        return xRounder;
    }

    /**
     * Метод для определения гипотенузы треугольника
     * @param a - первый катет теругольника
     * @param b - второй катет треугольника
     * @return - гипотенуза
     */
    public double hypotenuseTriangle(double a, double b){
        return Math.sqrt(Math.pow(a,2)+Math.pow(b,2));
    }
}
