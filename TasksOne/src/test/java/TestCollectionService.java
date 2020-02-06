import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import services.CollectionService;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

//Пункт 5
public class TestCollectionService extends Assert {
    private File file;
    private CollectionService collectionService;
    private List<Integer> list;

    @Before
    public void setData(){
        file = new File("test.txt");
        collectionService = new CollectionService();
    }

    @Test
    public void TestReadFile(){
        list = new LinkedList<>();
        for (int i =1; i <=10; i++){
            list.add(i);
        }
        assertEquals(list, collectionService.readFile(file));
    }

    @Test
    public void TestSearchNum(){
        list = collectionService.readFile(file);
        int x = list.size();
        int num = list.get(0);
        collectionService.listShuffle(list);
        assertFalse(num == list.get(0));
        collectionService.deleteNum(list);
        assertEquals(x-1, list.size());
        int deleteNum = collectionService.searchNum(file, list);
        assertEquals(deleteNum, collectionService.getDeleteNumber());
    }
}
