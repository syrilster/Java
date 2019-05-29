/**
 * Created by Syril on 09-04-2016.
 */
public class CustomHashMap<E> {


    private static final int SIZE = 16;
    private Entry[] entrySet = new Entry[SIZE];


    public static class Entry<E> {
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
        map.put("Syril", "Syril");
        map.put("Sandeep", "Sandeep");
        map.put("Vinay", "Vinay");
        map.put("Ankur", "Ankur");
        map.put("Prashanth", "Prashanth");
        map.put("Suhas", "Suhas");
        map.put("Anju", "Anju");
        map.put("Ajit", "Ajit");
        map.put("Neel", "Neel");
        map.put("Vinod", "Vinod");
        map.put("Ram", "Ram");
        map.put("Sadasivan", "Sadasivan");

        Entry e = map.get("Suhas");
        System.out.println(e.getValue());
    }
}
