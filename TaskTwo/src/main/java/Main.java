import domain.Point;
import figure.CircleFigure;

public class Main {
    public static void main(String[] args) {
        CircleFigure circleFigure = new CircleFigure(new Point(1, 1), 3);
        System.out.println(circleFigure.entry(new Point(4, 2)));
    }
}
