package LinkedList;

import org.junit.Assert;
import org.junit.Test;

public class TestClass {

    @Test
    public void test () {
        /**
         * ["LRUCache","put","put","get","put","get","put","get","get","get"]
         * [[2],[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]
         */
        LRU lru = new LRU(2);
        lru.put(1,1);
        lru.put(2,2);
        Assert.assertEquals(1, lru.get(1));
        lru.put(3,3);
        Assert.assertEquals(-1, lru.get(2));
        lru.put(4,4);
        Assert.assertEquals(-1, lru.get(1));
        Assert.assertEquals(3, lru.get(3));
        Assert.assertEquals(4, lru.get(4));
    }
}

