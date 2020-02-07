import domain.Point;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import services.OperationService;

public class MyOperationServiceTest extends Assert {
    private OperationService operationService = new OperationService();
    private Point pointA;
    private Point pointB;
    private Point pointC;
    private Point pointD;
    private Point pointF;
    private Point pointN;
    private Point pointG;
    private Point pointTestAbs;
    private Point pointTestStrtCooord;

    @Before
    public void setPoint(){
        pointA = new Point(1,1);
        pointB = new Point(2,3);
        pointC = new Point(4,0);
        pointD = new Point(2,2);
        pointF = new Point(5,2);
        pointN = new Point(2,0);
        pointG = new Point(1,2);
        pointTestAbs = new Point(-2, 0);
        pointTestStrtCooord = new Point(-1, -1);
    }

   /* @Test
    public void testPointAbs(){
        assertEquals(new Point(2,0), operationService.returnAbsPoint(pointTestAbs));
    }*/

    @Test
    public void testPointStartCoordinate(){
        assertEquals(new Point(3,4), operationService.returnStartCoordinat(pointB ,pointTestStrtCooord));
        assertEquals(new Point(1,2), operationService.returnStartCoordinat(pointB, pointA));
        assertEquals(new Point(3, -1), operationService.returnStartCoordinat(pointC, pointA));
        assertEquals(new Point(-3, 1), operationService.returnStartCoordinat(pointA, pointC));
    }

    @Test
    public void testIncludedInLine(){
        assertTrue(operationService.includedInLine(-1, 1, 0));
        assertFalse(operationService.includedInLine(-1, 1, 2));

    }

    @Test
    public void testSideLength(){
        assertTrue(operationService.sideLength(new Point(0,2), new Point(0, -1)) == 3);
    }
}
