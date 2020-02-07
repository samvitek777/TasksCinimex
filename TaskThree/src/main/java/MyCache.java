import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

public class MyCache<K,V> {
    private volatile ConcurrentHashMap<Key, V> globalMap = new ConcurrentHashMap<>();
    private long timeToLive;

    public MyCache(long timeToLive) throws Exception {
        //Проверка
        if (timeToLive < 10) {
            throw new Exception("Слишком короткий интервал для хранения в кеше. Интервал должен быть больше чем 10 mc");
        }
        this.timeToLive = timeToLive;
    }

    public void setTimeToLiveMilliseconds(long timeToLive) throws Exception {
        if (timeToLive < 10) {
            throw new Exception("Слишком короткий интервал для хранения в кеше. Интервал должен быть больше чем 10 mc");
        }
        this.timeToLive = timeToLive;
    }

    public void setTimeToLiveSeconds(long timeToLive) throws Exception {
        if (timeToLive < 0) {
            throw new Exception("Интервал не может быть меньше или равен 0");
        }
        timeToLive *= 1000;
        this.timeToLive = timeToLive;
    }

    public void setTimeToLiveMinutes(long timeToLive) throws Exception {
        if (timeToLive < 0) {
            throw new Exception("Интервал не может быть меньше или равен 0");
        }
        timeToLive *= 60000;
        this.timeToLive = timeToLive;
    }

    public void setTimeToLiveHour(long timeToLive) throws Exception {
        if (timeToLive < 0) {
            throw new Exception("Интервал не может быть меньше или равен 0");
        }
        timeToLive *= 3600000;
        this.timeToLive = timeToLive;
    }

    private static class Key {

        private final Object key;
        private long addTime;
        private long timeToLive;


        public Key(Object key, long timeOut) {
            this.key = key;
            this.addTime = System.currentTimeMillis();
            this.timeToLive = addTime + timeOut;
        }

        public Key(Object key) {
            this.key = key;
        }

        public Object getKey() {
            return key;
        }

        public boolean isLive(long currentTimeMillis) {
            return currentTimeMillis < timeToLive;
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
