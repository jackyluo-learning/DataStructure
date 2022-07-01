package algo;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

public class RomanToInteger {
    @Test
    public void test(){
        Assert.assertEquals(1994, romanToInt("MCMXCIV"));
    }

    public static int romanToInt(String s) {
        int result = 0;
        HashMap<Character, Integer> romanTable = new HashMap<>();
        romanTable.put('I', 1);
        romanTable.put('V', 5);
        romanTable.put('X', 10);
        romanTable.put('L', 50);
        romanTable.put('C', 100);
        romanTable.put('D', 500);
        romanTable.put('M', 1000);
        int len = s.length();
        int i = 0;
        while (i < len - 1) {
            if (romanTable.get(s.charAt(i)) < romanTable.get(s.charAt(i+1))) {
                result -= romanTable.get(s.charAt(i));
            } else {
                result += romanTable.get(s.charAt(i));
            }
            i++;
        }
        return result + romanTable.get(s.charAt(len - 1));
    }
}
