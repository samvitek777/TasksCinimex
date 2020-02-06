import domain.Point;
import domain.TypeFigure;
import figure.GeometricFigure;
import figure.TriangleFigure;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TriangeTest extends Assert {
    private GeometricFigure geometricFigure, geometricFigure1, geometricFigure2, geometricFigure3;
    private Point a, a1, a2, a3;
    private Point b, b1, b2, b3;
    private Point c, c1, c2, c3;

    @Before
    public void setData(){
        a = new Point(-1,-1);
        b = new Point(1,-1);
        c = new Point(0,1);
        a1 = new Point(-2, -2);
        b1 = new Point(1, -1);
        c1 = new Point(0,1);
        a2 = new Point(-1,-1);
        b2 = new Point(1,-1);
        c2 = new Point(0,1);
        a3 = new Point(0,0);
        b3 = new Point(2,0);
        c3 = new Point(0,2);

        geometricFigure = new TriangleFigure(c, b,a);
        geometricFigure1 = new TriangleFigure(a1, b1, c1);
        geometricFigure2 = new TriangleFigure(a2, b2, c2);
        geometricFigure3 = new TriangleFigure(a3, b3, c3);
    }

    @Test
    public void testType(){
        assertEquals(TypeFigure.isosceles_triangle, geometricFigure.type());
    }

    @Test
    public void testEntry(){

        assertFalse(geometricFigure.entry(new Point(2,2)));
        assertTrue(geometricFigure1.entry(new Point(0,0)));
        assertTrue(geometricFigure2.entry(new Point(0,1)));
        assertTrue(geometricFigure2.entry(new Point(0.5, 0)));
        assertFalse(geometricFigure2.entry(new Point(1,3)));
        assertTrue(geometricFigure2.entry(new Point(0,0)));
        assertTrue(geometricFigure3.entry(new Point(1,1)));
        assertFalse(geometricFigure3.entry(new Point(5,5)));

    }
}
