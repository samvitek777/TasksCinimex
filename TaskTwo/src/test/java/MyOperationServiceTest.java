import domain.Point;
import org.junit.Assert;
import org.junit.Test;
import services.OperationService;

public class MyOperationServiceTest extends Assert {
    private OperationService operationService = new OperationService();

    @Test
    public void testPointAbs(){
        Point point = operationService.returnAbsPoint(new Point(-2, 2));
        assertEquals(new Point(2,2), point);

    }
}
