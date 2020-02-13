package services;

import domain.Point;
import figure.RectangleFigure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class RectangleService {

    /**
     *
     * @param masPointsRectangle - массив чисел для прямоугольника
     * @param massPoints - массив чисел для точек
     * @return - Коллекцию точек в каком квадрате они лежат или не лежат
     * @throws Exception - ошибочное количество чисел для составления прямоугольника или точки
     */
    public HashMap <Point, Optional<RectangleFigure>> pointInRectangle(long [] masPointsRectangle, long [] massPoints)
            throws Exception {

        HashMap<Point, Optional<RectangleFigure>> pointData = new HashMap<>();

        //Проверка на правильность массивов
        if (masPointsRectangle.length % 8 != 0) {
            throw new Exception("Ошибочное количество значений для квадрата");
        } else if(massPoints.length % 2 != 0){
            throw new Exception("Ошибочное количество значений для точки");
        }

        List<RectangleFigure> rectanglesList = new ArrayList<>();
        List<Point> pointsList  = new ArrayList<>();
        int numberIterationsRectangle = masPointsRectangle.length/8;
        int numberIterationsPoint = massPoints.length/2;

        //Заполнение коллекции прямоугольников
        for (int i = 0, count = 0; i < numberIterationsRectangle; i++){
            Point a = new Point(masPointsRectangle[count++],masPointsRectangle[count++] );
            Point b = new Point(masPointsRectangle[count++],masPointsRectangle[count++] );
            Point c = new Point(masPointsRectangle[count++],masPointsRectangle[count++] );
            Point d = new Point(masPointsRectangle[count++],masPointsRectangle[count++] );
            rectanglesList.add(new RectangleFigure(a,b,c,d));
        }

        //Заполнение коллекции точек
        for(int i = 0, count = 0; i < numberIterationsPoint; i++){
            long x = massPoints[count++];
            long y = massPoints[count++];
            pointsList.add(new Point(x, y));
        }

        // Проверка вхождения точек в прямоугольник
        for(Point point : pointsList){
            boolean flag = false;
            for (RectangleFigure rectangleFigure : rectanglesList){
                if(rectangleFigure.entry(point)){
                    pointData.put(point, Optional.ofNullable(rectangleFigure));
                    flag = true;
                    break;
                }
            }
            if(!flag){
                pointData.put(point, Optional.empty());
            }
        }
        return pointData;
    }
}
