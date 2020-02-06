package services;

import java.io.*;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

    /**
     * Класс со вспомогательными методами для работы с коллекцией.
     * @autor Самойленко Виктор
     * @version 1.0
     */
public class CollectionService {
    private int deleteNumber;

    //Не подходящие методы
    /*public int[] readArray(File file){

        int[] array = null;
        try(BufferedReader in = new BufferedReader(new FileReader(file))) {
            array = in.lines().mapToInt(Integer::parseInt).toArray();
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
        return array;
    }
        public List<String> readNumbers(Path path){
            List<String> array = new ArrayList<>();
            try(Stream<String> stream = Files.newBufferedReader(path).lines()) {
                array = stream.collect(Collectors.toList());
            } catch (IOException e) {
                e.printStackTrace();
            }
            return array;
        }*/


    /**
     * Метод возвращаемый коллекцию чисел из файла
     * @param file - исходный файл с числами
     * @return - LinkedList с числами
     */
    public List<Integer> readFile(File file){
        List<Integer> array = new LinkedList<>();
        String line;
        try(BufferedReader in = new BufferedReader(new FileReader(file))) {
            while ((line = in.readLine()) != null)
                array.add(Integer.parseInt(line));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return array;
    }

    /**
     * Метод удаляет случайное число из коллекции и запоминает удаленое число
     * @param list - исходная коллекция
     * @return - LinkedList с удаленным рандомным числом
     */
    public void deleteNum(List<Integer> list){
        int randomNum = (int) (Math.random() * list.size());
        deleteNumber = list.get(randomNum);
        list.remove(randomNum);
    }

    /**
     * Метод возвращающий удаленое число
     * @return - удаленое число
     */
    public int getDeleteNumber() {
        return deleteNumber;
    }

    /**
     * Метод перемешивания коллекции
     * @param list - исходная коллекция
     */
    public void listShuffle(List<Integer> list){
        Collections.shuffle(list);
    }

    /**
     * Метод сравнивает две коллекции и ищет число которого нет
     * @param file - исходный файл с числами
     * @param array - коллеция с удаленным числом
     * @return - удаленное число
     */
    public int searchNum(File file, List<Integer> array){
        List<Integer> list = readFile(file);
        for(int i = 0; i < array.size(); i++){
            int num = array.get(i);
            for (int n = 0; n < list.size(); n++){
                if(num == list.get(n)){
                    list.remove(n);
                }
            }
        }
        return list.get(0);
    }
}
