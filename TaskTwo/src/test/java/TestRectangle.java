import domain.Point;
import domain.TypeFigure;
import figure.GeometricFigure;
import figure.RectangleFigure;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestRectangle extends Assert {
    private GeometricFigure geometricFigure;
    @Before
    public void setData(){
        Point a = new Point(-2, -2);
        Point b = new Point(-2, 3);
        Point c = new Point(1, 3);
        Point d = new Point(1, -2);
        geometricFigure = new RectangleFigure(d,c,b,a);
    }

    @Test
    public void testType(){
       assertEquals(TypeFigure.rectangle, geometricFigure.type());
    }

    @Test
    public void testEntry(){
        Point point = new Point(1,1);
        assertTrue(geometricFigure.entry(point));
        assertFalse(geometricFigure.entry(new Point(-3, 0)));
    }
}
