package MemoryLeak;

import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Map;

public class MemoryLeakTest {
    //Run this program with a low Java heap setting to get the exception quickly. i.e -Xmx64M
    @Test(expected = OutOfMemoryError.class)
    public void givenMap_whenNoEqualsNoHashCodeMethods_thenOutOfMemory()
            throws IOException, URISyntaxException {
        Map< Object, Object> map = System.getProperties();
        while (true) {
            map.put(new Key("key"), "value");
        }
    }
}
