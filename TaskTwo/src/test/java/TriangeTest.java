import domain.Point;
import domain.TypeFigure;
import figure.GeometricFigure;
import figure.TriangleFigure;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TriangeTest extends Assert {
    private GeometricFigure geometricFigure, geometricFigure1, geometricFigure2, geometricFigure3, geometricFigure4, geometricFigure5;
    private Point a, a1, a2, a3, a4, a5;
    private Point b, b1, b2, b3, b4, b5;
    private Point c, c1, c2, c3, c4, c5;

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
        a4 = new Point(0,0);
        b4 = new Point(1,-2);
        c4 = new Point(0,3);
        a5 = new Point(0,0);
        b5 = new Point(1,-1);
        c5 = new Point(0,0);

        geometricFigure = new TriangleFigure(c, b,a);
        geometricFigure1 = new TriangleFigure(a1, b1, c1);
        geometricFigure2 = new TriangleFigure(a2, b2, c2);
        geometricFigure3 = new TriangleFigure(a3, b3, c3);
        geometricFigure4 = new TriangleFigure(a4, b4, c4);
        geometricFigure5 = new TriangleFigure(a5, b5, c5);
    }

    @Test
    public void testType(){
        assertEquals(TypeFigure.isosceles_triangle, geometricFigure.type());
        assertEquals(TypeFigure.acute_triangle, geometricFigure1.type());
        assertEquals(TypeFigure.isosceles_triangle, geometricFigure2.type());
        assertEquals(TypeFigure.right_triangle, geometricFigure3.type());
        assertEquals(TypeFigure.obtuse_triangle, geometricFigure4.type());
        assertEquals(TypeFigure.none, geometricFigure5.type());
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
