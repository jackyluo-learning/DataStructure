package algo;

import org.junit.Assert;
import org.junit.Test;

public class AddBinary {
    /*
    Given two binary strings, return their sum (also a binary string).
    The input strings are both non-empty and contains only characters 1 or 0.
     */
    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        char[] ca = a.toCharArray();
        char[] cb = b.toCharArray();
        int carry = 0;
        int ia = ca.length - 1;
        int ib = cb.length - 1;
        while (true) {
            if (ia < 0 && ib < 0) {
                break;
            } else {
                int ai = 0;
                int bi = 0;
                if (ia >= 0) {
                    ai = Character.getNumericValue(ca[ia]);
                    ia--;
                }
                if (ib >= 0) {
                    bi = Character.getNumericValue(cb[ib]);
                    ib--;
                }
                int tmp = ai + bi + carry;
                if (tmp >= 2) {
                    tmp = tmp % 2;
                    carry = 1;
                } else {
                    carry = 0;
                }
                result.insert(0, tmp);
            }
        }
        if (carry > 0) {
            result.insert(0, 1);
        }
        return result.toString();
    }

    @Test
    public void test() {
        Assert.assertEquals("10101", addBinary("1010", "1011"));
        Assert.assertEquals("100", addBinary("11", "1"));
    }
}
