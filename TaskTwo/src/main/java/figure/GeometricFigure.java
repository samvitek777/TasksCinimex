package figure;

import domain.Point;
import domain.TypeFigure;

/**
 * Интерфейс описывающий основные методы фигур
 */
public interface GeometricFigure {

    /**
     * Метод определяющий тип фигуры
     * @return - тип фигуры
     */
    TypeFigure type();

    /**
     * Мктод вхождение точки в фигуру
     * @param point - точка на плоскости
     * @return - возвращет true - если входит и false -  если нет
     */
    boolean entry(Point point);
}
