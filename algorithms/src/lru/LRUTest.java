package lru;

import org.junit.Assert;
import org.junit.Test;

public class LRUTest {
    @Test
    public void testLRU() {
        LRU<Integer, Integer> lru = new LRU<>(5);
        Assert.assertEquals(null, lru.get(1));

        lru.put(1,1);
        Assert.assertEquals(Integer.valueOf(1), lru.get(1));
        lru.put(2,2);
        lru.put(3,3);
        lru.put(4,4);
        lru.put(5,5);
        for (Integer integer : lru) {
            System.out.print(integer + " ");
        }

        System.out.println();

        Assert.assertEquals(Integer.valueOf(2), lru.get(2));
        for (Integer integer : lru) {
            System.out.print(integer + " ");
        }

        System.out.println();

        lru.put(6,6);
        for (Integer integer : lru) {
            System.out.print(integer + " ");
        }
    }
}
