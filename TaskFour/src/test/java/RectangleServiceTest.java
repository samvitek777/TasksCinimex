import domain.Point;
import figure.RectangleFigure;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import services.RectangleService;

import java.util.HashMap;
import java.util.Optional;

public class RectangleServiceTest extends Assert {

    private RectangleService rectangleService = new RectangleService();
    private long[] massPointsRectangle = {0, 0, 0, 2, 2, 2, 2, 0};
    private long[] massPoints = {1, 1, 3, 3};
    private HashMap<Point, Optional<RectangleFigure>> pointData;
    private RectangleFigure rectangleOne;

    @Before
    public void setData(){
        Point a = new Point(0,0);
        Point b = new Point(0,2);
        Point c = new Point(2,2);
        Point d = new Point(2,0);
        rectangleOne= new RectangleFigure(a,b,c,d);
    }

    @Test
    public void rectangleServiceTest(){
        try {
            pointData = rectangleService.pointInRectangle(massPointsRectangle, massPoints);
        } catch (Exception e){
            e.printStackTrace();
        }
        assertEquals(pointData.get(new Point(1,1)).get(), rectangleOne);
        assertFalse(pointData.get(new Point(3,3)).isPresent());
    }
}
