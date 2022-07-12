package algo;

import org.junit.Test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public class GetRandomFromHashSet {
    public int getRandomFromArray (Set<Integer> set) {
        Integer[] array = set.toArray(new Integer[set.size()]);
        Random r = new Random();
        int randomIndex = r.nextInt(set.size());
        return array[randomIndex];
    }

    public int getRandomWithIterator (Set<Integer> set) {
        Random r = new Random();
        int randomIndex = r.nextInt(set.size());
        Iterator<Integer> iterator = set.iterator();
        int index = 0;
        int result = -1;
        while (iterator.hasNext()) {
            int value = iterator.next();
            if (index == randomIndex) {
                result = value;
            }
            index++;
        }
        return result;
    }

    @Test
    public void test () {
        Set<Integer> hs = new HashSet<Integer>();

        hs.add(11);
        hs.add(24);
        hs.add(34);
        hs.add(43);
        hs.add(55);
        hs.add(66);
        hs.add(72);
        hs.add(80);
        hs.add(99);


        System.out.println("Random element: "
                + getRandomFromArray(hs));

        System.out.println("Random element: "
                + getRandomWithIterator(hs));
    }
}
