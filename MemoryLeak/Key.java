package MemoryLeak;

import java.util.Objects;

public class Key {
    public String key;

    public Key(String key) {
        this.key = key;
    }

/*
A simple but very common example that can lead to a memory leak is to use a HashSet with objects that are missing their
hashCode() or equals() implementations. Specifically, when we start adding duplicate objects into a Set – this will only
ever grow, instead of ignoring duplicates as it should. We also won’t be able to remove these objects, once added.
 */

    /*@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Key key1 = (Key) o;
        return Objects.equals(key, key1.key);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key);
    }*/
}
