package algo;

import org.junit.Assert;
import org.junit.Test;

public class ReverseInteger {

    @Test
    public void test() {
        Assert.assertEquals(0, reverseInteger1(1534236469));
        Assert.assertEquals(0, reverseInteger2(1534236469));
    }


    public static int reverseInteger1(int x) {
        Boolean flag = false;
        if(x < 0){
            x = -x;
            flag = true;
        }
        int result = 0;
        while(x>=1){
            int i = x % 10;
            x = x / 10;
            if (result > Integer.MAX_VALUE/10 || (result == Integer.MAX_VALUE / 10 && i > 7))
                return 0;
            if (result < Integer.MIN_VALUE/10 || (result == Integer.MIN_VALUE / 10 && i < -8))
                return 0;
            result = result * 10 + i;
        }
        if(flag){
            result = -result;
        }
        return result;
    }

    public static int reverseInteger2(int x){
        int result = 0;
        if(x<0){
            String input = String.valueOf(-x);
            StringBuilder sb = new StringBuilder(input);
            try {
                result = Integer.parseInt(sb.reverse().insert(0, '-').toString());
            }catch (NumberFormatException e){
                return 0;
            }
        }
        else{
            String input = String.valueOf(x);
            StringBuilder sb = new StringBuilder(input);
            try {
                result = Integer.parseInt(sb.reverse().toString());
            }catch (NumberFormatException e){
                return 0;
            }
        }
        return result;
    }
}
