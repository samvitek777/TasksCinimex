package services;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectionService {

    public int[] readArray(File file){
        int[] array = null;
        try(BufferedReader in = new BufferedReader(new FileReader(file))) {
            array = in.lines().mapToInt(Integer::parseInt).toArray();
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
        return array;
    }

    public List<Integer> readFile(File file){
        List<Integer> array = new ArrayList<>();
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

    public List<String> readNumbers(Path path){
        List<String> array = new ArrayList<>();
        try(Stream<String> stream = Files.newBufferedReader(path).lines()) {
            array = stream.collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return array;
    }

    //сделать линкедлист
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
    }}
