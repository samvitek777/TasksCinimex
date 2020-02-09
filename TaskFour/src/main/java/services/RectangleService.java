package services;

import domain.Point;
import figure.RectangleFigure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class RectangleService {

    public HashMap<Point, Optional<RectangleFigure>> pointInRectangle(long [] masPointsRectangle, long [] massPoints) throws Exception {
        HashMap<Point, Optional<RectangleFigure>> pointData = new HashMap<>();
        if (masPointsRectangle.length % 8 != 0) {
            throw new Exception("Ошибочное количество значений для квадрата");
        } else if(massPoints.length % 2 != 0){
            throw new Exception("Ошибочное количество значений для точки");
        }
        List<RectangleFigure> rectanglesList = new ArrayList<>();
        List<Point> pointsList  = new ArrayList<>();

        int numberIterationsRectangle = masPointsRectangle.length/8;
        int numberIterationsPoint = massPoints.length/2;

        for (int i = 0, count = 0; i < numberIterationsRectangle; i++){
            Point a = new Point(masPointsRectangle[count++],masPointsRectangle[count++] );
            Point b = new Point(masPointsRectangle[count++],masPointsRectangle[count++] );
            Point c = new Point(masPointsRectangle[count++],masPointsRectangle[count++] );
            Point d = new Point(masPointsRectangle[count++],masPointsRectangle[count++] );
            rectanglesList.add(new RectangleFigure(a,b,c,d));
        }
        for(int i = 0, count = 0; i < numberIterationsPoint; i++){
            long x = massPoints[count++];
            long y = massPoints[count++];
            pointsList.add(new Point(x, y));
        }

        for (RectangleFigure rectangleFigure : rectanglesList){
            for (Point point: pointsList){
                if (rectangleFigure.entry(point)) {
                    pointData.put(point, Optional.ofNullable(rectangleFigure));
                } else {
                    pointData.put(point, Optional.empty());
                }
            }
        }

        System.out.println(pointsList);
        System.out.println(rectanglesList);

        return pointData;
    }
}
