package algo;

import org.junit.Assert;
import org.junit.Test;

public class PlusOne {

    public int[] plusOne(int[] digits){
        int len = digits.length;
        int add = 1;
//        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = len-1; i>=0; i--){
            int d = digits[i];
            int r = (d+add)%10;
//            stack.push(r);
            digits[i] = r;
//            if(r == 0 && i == 0){
//                stack.push(add);
//            }
            if(r!=0){
                add = 0;
            }
        }
        if(add != 0){
            digits = new int[digits.length+1];
            digits[0] = 1;
        }
//        int[] resultDigits = stack.stream().mapToInt(Integer::valueOf).toArray();
        return digits;
    }

    public int[] plusOneBetter(int[] digits)
    {
        int carry = 1;
        int index = digits.length - 1;
        while (index >= 0 && carry > 0)
        {
            digits[index] = (digits[index] + carry) % 10;
            carry = digits[index] == 0 ? 1 : 0;
            index--;
        }

        if (carry > 0)
        {
            digits = new int[digits.length + 1];
            digits[0] = 1;
        }

        return digits;
    }

    public int[] plusOneBest(int[] digits){
        int carry = 1;
        for (int i = digits.length-1; i>= 0; i--) {
            digits[i] += carry;
            if (digits[i] <= 9) // early return
                return digits;
            digits[i] = 0;
        }
        int[] ret = new int[digits.length+1];
        ret[0] = 1;
        return ret;
    }

    @Test
    public void test(){
        Assert.assertArrayEquals(new int[]{1,0,0,0,0}, plusOne(new int[]{9,9,9,9}));
        Assert.assertArrayEquals(new int[]{1,0,0,0,0}, plusOneBetter(new int[]{9,9,9,9}));
    }
}
