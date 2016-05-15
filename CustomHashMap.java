/**
 * Created by Syril on 09-04-2016.
 */
public class CustomHashMap <E> {


    private static final int SIZE = 16;
    private Entry entrySet[] = new Entry[SIZE];


    public static class Entry <E> {
        private final E key;
        private E value;
        Entry next;

        public Entry(E key, E value) {
            this.key = key;
            this.value = value;
        }


        public E getKey() {
            return key;
        }

        public E getValue() {
            return value;
        }

        public void setValue(E value) {
            this.value = value;
        }
    }


    public Entry get(E key) {
        int hash = key.hashCode() % SIZE;
        Entry e = entrySet[hash];

        while (e != null) {
            if (e.getKey().equals(key) || e.getKey() == key) {
                return e;
            }
            e = e.next;
        }

        return null;
    }

    public void put(E key, E value) {
        int hash = key.hashCode() % SIZE;
        hash = Math.abs(hash);
        Entry e = entrySet[hash];

        if (e != null) {
            if (e.getKey().equals(key) || e.getKey() == key) {
                e.setValue(value);
            } else {
                while (e.next != null) {
                    e = e.next;
                }
                Entry entryInOldBucket = new Entry(key, value);
                e.next = entryInOldBucket;
            }
        } else {
            Entry entryInNewBucket = new Entry(key, value);
            entrySet[hash] = entryInNewBucket;
        }
    }

    public static void main(String[] args) {
        CustomHashMap map = new CustomHashMap();
        map.put("Syril", "Test");
        map.put("Sandeep", "new Test");
        map.put("Vinay", "new Test");
        map.put("Ankur", "new Test");
        map.put("Prashanth", "new Test");
        map.put("Suhas", "new Test");
        map.put("Anju", "new Test");
        map.put("Ajit", "new Test");
        map.put("Neel", "new Test");
        map.put("Vinod", "new Test");
        map.put("Ram", "new Test");
        map.put("Sadasivan", "new Test");
        map.put("Kiran", "new Test");
        map.put("Reddy", "new Test");
        map.put("Mac", "new Test");
        map.put(1, "new Test");

        Entry e = map.get(1);
        System.out.println(e.getValue());


    }
}
