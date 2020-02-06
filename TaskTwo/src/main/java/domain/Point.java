package domain;


import java.util.Objects;

/**
 * Класс позиции точки в координатной оси(x,y)
 * @author Самойленко Виктор
 * @version 1.0
 */

public class Point implements Comparable  {
    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return Double.compare(point.x, x) == 0 &&
                Double.compare(point.y, y) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        Point tmp = (Point) o;
        if(this.getX() <= tmp.getX()){
            return -1;
        } else return 1;
    }
}
