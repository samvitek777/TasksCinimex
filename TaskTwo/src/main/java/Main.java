import domain.Point;
import figure.CircleFigure;
import figure.RectangleFigure;

public class Main {
    public static void main(String[] args) {
        CircleFigure circleFigure = new CircleFigure(new Point(1, 1), 3);
        System.out.println(circleFigure.entry(new Point(4, 2)));
        RectangleFigure rectangleFigure = new RectangleFigure(
                new Point(-2,-2), new Point(-2, 2), new Point(2, 2), new Point(2,-2));
        System.out.println(rectangleFigure.entry(new Point(2,3)));

    }
}
