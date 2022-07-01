package algo;

import org.junit.Test;

public class NumberOf1Bits {
    public int hammingWeight(int n) {
        int count = 0;
        int flag = 1;
        while (flag != 0){
            if((n & flag) != 0){
                count++;
            }
            flag <<= 1;
        }
        return count;
    }

    @Test
    public void test(){
//        System.out.println(hammingWeight(11111111111111111111111111111101));
    }
}
