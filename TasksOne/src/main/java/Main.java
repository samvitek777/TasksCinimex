import services.CollectionService;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String fileName = "test.txt";

        File file = new File(fileName);
        Path path = Paths.get(fileName);

        CollectionService collectionService = new CollectionService();

        List<Integer> list = collectionService.readFile(file);

        int randomNum = (int) (Math.random() * list.size());

        int deleteNum = list.get(randomNum);

        list.remove(randomNum);

        Collections.shuffle(list);

        //тестирование junit

        System.out.println("Сохранненое удаленое число ранно: " + deleteNum);
        System.out.println("Удаленое число через поиск равно: " + collectionService.searchNum(file, list));


    }
}