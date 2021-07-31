package java.pc;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.pc.cmap.CustomHashMap;

public class CustomHashMapTest {

    private CustomHashMap<String, String> customHashMap;

    @Before
    public void beforeTest() {
        customHashMap = new CustomHashMap<>(10);
    }

    @Test
    public void givenCustomHashMapAndCheckHashValue() {
        Integer value  = customHashMap.hash("1234");
        Assert.assertNotNull(value);
    }

}
