import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
/**
 * Задача 3
 * Реализовать кэш с временем жизни элементов.
 * 1. У кэша и его элементов существуют несколько параметров:
 *       timeToLive - время жизни любого элемента в кэше,  задется при создании экземпляра кэша,
 *       может быть изменено в любой момент,  данный параметр может задаваться в милисекундах, секундах, минутах, часах
 *       addTime - время добавления элемента в кэш
 *       currentTime - текущее время
 * 2. Каждый элемент в кэше содержаться в течении времени timeToLive. В случае,
 *      если для какого либо элемента currentTime - addTime > timeToLive, данный элемент должен быть удален из кэша
 * 3. Для кэша задается параметр checkTime - временной интервал запуска автоматической проверки элементов кэша по правилу,
 *      описанному в пункте 2.
 * 4. Кэш должен поддерживать следующие операции:
 *    1. Добавление нового элемента
 *    2. Получение элемента
 *    3. Автоматическая проверка элементов кэша и удаление "протухщих"
 *    4. Изменение параметра timeToLive в любой момент жизненного цикла кэша
 *    5. Очистка кэша
 *    6. Обновление времени добавления addTime элемента
 *  @autor Самойленко Виктор
 *  @version 1.0
 */
public class Main {
    private final ScheduledExecutorService scheduler =
        Executors.newScheduledThreadPool(1);
    public static void main(String[] args){
        try {
            MyCache<Integer, Test> myCache = new MyCache<>(10000);
            myCache.put(1, new Test("Test"));
            System.out.println(myCache.get(1));
            myCache.cleanСache();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
