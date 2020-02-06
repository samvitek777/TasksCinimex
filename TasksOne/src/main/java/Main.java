import services.CollectionService;

import java.io.File;
import java.util.List;

    /**Задача 1
     Из  файла считывается последовательность чисел от 1 до N. Из  полученной последовательности удаляется случайное число.
     После чего, полученная последовательность перемешивается.  Необходимо найти удаленное число.
     Реализовать методы
        1.Считывания последовательности из файла
        2.Удаления случайного числа и его  сохранения для дальнейшей проверки
        3.Перемешивания последовательности
        4.Поиска удаленного  числа
        5.Реализовать методы модульного тестирования функционала программы
     * @autor Самойленко Виктор
     * @version 1.0
     */
public class Main {
    public static void main(String[] args) {
        String fileName = "list.txt";
        File file = new File(fileName);
        CollectionService collectionService = new CollectionService();
        //Пункт 1
        List<Integer> list = collectionService.readFile(file);
        //Пункт 2
        collectionService.deleteNum(list);
        //Пункт 3
        collectionService.listShuffle(list);
        //Пункт 4
        int num = collectionService.searchNum(file, list);

        System.out.println("Сохранненое удаленое число ранно: " + collectionService.getDeleteNumber());
        System.out.println("Удаленое число через поиск равно: " + num);


    }
}