package org.pc;

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
        Integer value1  = customHashMap.hash("1234");
        Assert.assertNotNull(value);
        Assert.assertEquals(value, value1);


        Integer value2  = customHashMap.hash("1235");
        Integer value3  = customHashMap.hash("1236");
        Assert.assertNotNull(value);
        Assert.assertFalse(value2.equals(value3));
    }

    @Test
    public void givenCustomHashMapAndCheckIndexReturned() {
        int index = customHashMap.index("1234");
        int index1 = customHashMap.index("1235");

        Assert.assertFalse(index1 == index);
    }

    @Test
    public void givenCustomHashMapAndPerformPutAndGetOperation() {
        customHashMap.put("1234","Hello123");
        String result = (String) customHashMap.get("1234");
        Assert.assertEquals("Hello123", result);
    }

    @Test
    public void givenCustomHashMapAndPerformDeleteOperation() {
        customHashMap.put("123","Get1234");
        String result = (String) customHashMap.get("123");
        Assert.assertEquals("Get1234", result);

        boolean response = customHashMap.remove("123");
        Assert.assertTrue(response);
        result = (String) customHashMap.get("1234");
        Assert.assertNull(result);
    }
}
