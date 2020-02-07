import domain.Point;
import figure.GeometricFigure;
import figure.TriangleFigure;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import services.TriangleService;

public class TestTriangleService extends Assert {
     private Point a, b, c, a1, b1, c1;
     private TriangleService triangleService;
     private TriangleFigure triangleFigure1, triangleFigure2;


    @Before
    public void setData(){
        a = new Point(0,0);
        b = new Point(1,1);
        c = new Point(2,0);
        a1 = new Point(0,0);
        b1 = new Point(2,2);
        c1 = new Point(4,0);

        triangleFigure1 = new TriangleFigure(b,a,c);
        triangleFigure2 = new TriangleFigure(a1,b1,c1);

        triangleService = new TriangleService();
    }

    @Test
    public void triangleServiceTest(){
        assertTrue(triangleService.similarityTriangles(triangleFigure1, triangleFigure2));
    }
}
