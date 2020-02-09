import domain.Point;
import figure.RectangleFigure;
import services.RectangleService;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 *Задача 4
 * Есть плоскость, на этой плоскости лежат прямоугольники.
 * Каждый их них задан 4мя точками. Прямоугольники достаточно похожи друг на друга
 * (ширина самого большого не более чем в 2 раза больше ширины самого маленького, с высотой так же).
 * Прямоугольники не пересекаются. Прямоугольников n. На вход приходит массив точек размером m,
 * надо для каждой сказать или внутри какого прямоугольника она лежит (его номер), или что она не лежит ни в каком.
 */

public class Main {
    public static void main(String[] args) {
        HashMap<Point, Optional<RectangleFigure>> pointData;
        RectangleService rectangleService = new RectangleService();
        long[] massPointsRectangle = new long[16];
        long[] massPoints = new long[4];
        for (int i = 0; i < massPoints.length; i++){
            massPoints[i] = i;
        }
        for (int i = 0; i < massPointsRectangle.length; i++){
            massPointsRectangle[i] = i;
        }
        try {
            pointData = rectangleService.pointInRectangle(massPointsRectangle, massPoints);
            for(Map.Entry<Point, Optional<RectangleFigure>> pair : pointData.entrySet())
            {
                Optional<RectangleFigure> value = pair.getValue();
                Point point = pair.getKey();
                System.out.println(
                        point + " " + (value.isPresent()?value.get():"Не входит в ни в один квадрат")
                );
            }
        } catch (Exception e){
            e.printStackTrace();
        }

    }
}
