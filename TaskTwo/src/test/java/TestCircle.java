import domain.Point;
import domain.TypeFigure;
import figure.CircleFigure;
import figure.GeometricFigure;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestCircle extends Assert {
    private GeometricFigure geometricFigure;
    private GeometricFigure geometricFigure2;

    @Before
    public void setData(){
        geometricFigure = new CircleFigure(new Point(1,1), 2);
    }

    @Test
    public void testType(){
        assertEquals(TypeFigure.circle, geometricFigure.type());
    }

    @Test
    public void testEntry(){

        Point point = new Point(0,1);
        Point point1 = new Point(1, 1);
        Point point2 = new Point(2,2);
        assertTrue(geometricFigure.entry(point));
        assertTrue(geometricFigure.entry(point1));
        assertTrue(geometricFigure.entry(point2));
    }
}
