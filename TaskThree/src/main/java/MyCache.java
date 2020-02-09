import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.*;

import static java.util.concurrent.TimeUnit.MILLISECONDS;

/**
 * Класс кэша
 * @param <K> - ключ
 * @param <V> - значение
 * @author Самойленко Виктор
 * @version 1.0
 */
public class MyCache<K,V> {
    private volatile ConcurrentHashMap<Key, V> myCacheMap = new ConcurrentHashMap<>();
    // Из задания так и не понял как задавать время на проверку
    private final long checkTime = 1000;
    private long timeToLive;
    private final ScheduledExecutorService scheduler =
            Executors.newScheduledThreadPool(1);


    /**
     * Конструктор кэша и запуск проверки жизни элементов в нем
     * @param timeToLive - время жизни
     * @throws Exception - проверка на маленькое значение времени
     */
    public MyCache(long timeToLive) throws Exception {
        if (timeToLive < 10) {
            throw new Exception("Слишком короткий интервал для хранения в кеше. Интервал должен быть больше чем 10 мc");
        }
        this.timeToLive = timeToLive;
        checkCache();
    }



    /**
     * Медот для изменения времени жизни элементов в кэше в миллисекундах
     * @param timeToLive - миллисекунды хранения в кэше
     * @throws Exception - проверка на слишком короткий интервал
     */
    public void setTimeToLiveMilliseconds(long timeToLive) throws Exception {
        if (timeToLive < 10) {
            throw new Exception("Слишком короткий интервал для хранения в кеше. Интервал должен быть больше чем 10 мc");
        }
        this.timeToLive = timeToLive;
        setTimeToLive();
    }

    /**
     * Медот для изменения времени жизни элементов в кэше в секундах
     * @param timeToLive - секунды хранения в кэше
     */
    public void setTimeToLiveSeconds(long timeToLive){
        this.timeToLive = timeToLive * 1000;
        setTimeToLive();
    }

    /**
     * Медот для изменения времени жизни элементов в кэше в минутах
     * @param timeToLive - минуты хранения в кэше
     */
    public void setTimeToLiveMinutes(long timeToLive){
        this.timeToLive = timeToLive * 60000;
        setTimeToLive();
    }

    /**
     * Медот для изменения времени жизни элементов в кэше в часах
     * @param timeToLive - часы хранения в кэше
     */
    public void setTimeToLiveHour(long timeToLive){
        this.timeToLive = timeToLive * 3600000;
        setTimeToLive();
    }

    /**
     * Добавления элемента в кеш
     * @param key - ключ
     * @param data - значение
     */
    public void put(K key, V data){
        myCacheMap.put(new Key(key, timeToLive), data);
    }

    /**
     * Мутод для возврата значения по ключу
     * @param key - ключ по которому искать значение
     * @return - значение из кэша
     */
    public V get(K key) {
        return myCacheMap.get(new Key(key));
    }

    /**
     * Очистка кэша от всех элементов
     */
    public void cleanСache() {
        myCacheMap.clear();
    }

    /**
     * Изменение времени добавления обьекта в кэш
     * @param value - обьект в кэше
     */
    public void update(V value){
        Optional<Key> result = myCacheMap.entrySet()
                .stream()
                .filter(entry -> value.equals(entry.getValue()))
                .map(Map.Entry::getKey)
                .findFirst();

        result.get().updateAddTime(10000);
    }


    /**
     * Запуск проверки кэша каждые checkTime миллисекунд
     */
    private void checkCache() {
        scheduler.scheduleAtFixedRate(() -> {
            long currentTime = System.currentTimeMillis();
            for (Key k : myCacheMap.keySet()){
                if(k.isLive(currentTime)){
                    myCacheMap.remove(k);
                }
            }
        }, 1, checkTime, MILLISECONDS);
    }

    /**
     *  Изменение времени жизни в кэше
     */
    private void setTimeToLive(){
        for (Key k : myCacheMap.keySet()){
            k.setTimeToLive(timeToLive);
        }
    }

    /**
     * Класс ключа
     */
    private static class Key {
        private final Object key;
        private long addTime;
        private long timeToLive;

        /**
         * Конструктор задающий начальные значения и время добавления в кеш
         * @param key - ключ по которому хранится значение
         * @param timeToLive - время жизни в кэше
         */
        public Key(Object key, long timeToLive) {
            this.key = key;
            this.addTime = System.currentTimeMillis();
            this.timeToLive = timeToLive;
        }

        /**
         * Конструктор создания ключа для поиска значения
         * @param key - ключ по которому хранится значение
         */
        public Key(Object key) {
            this.key = key;
        }

        /**
         * Изменение времени существования в кэше
         * @param timeToLive - новое время
         */
        public void setTimeToLive(long timeToLive) {
            this.timeToLive = timeToLive;
        }

        /**
         * Обновление времени добавления в кэш
         * @param time - время на которое нужно обновить
         */
        public void updateAddTime(long time) {
            addTime += time;
        }

        /**
         * Проверка на удаление из кэша
         * @param currentTime - текущее время в кэше
         */
        public boolean isLive(long currentTime) {
            return currentTime - addTime > timeToLive;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Key key1 = (Key) o;
            return key.equals(key1.key);
        }

        @Override
        public int hashCode() {
            return Objects.hash(key);
        }

        @Override
        public String toString() {
            return "Key{" +
                    "key=" + key +
                    '}';
        }
    }
}
