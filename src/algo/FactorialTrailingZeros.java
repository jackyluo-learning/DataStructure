package algo;

import org.junit.Test;

public class FactorialTrailingZeros {
    public int trailingZeroes1(int n) {
        int fac = fac(n);
        System.out.println(fac);
        int count = 0;
        if(n <= 0) return count;
        while (fac >= 1){
            int i = fac % 10;
            if( i == 0) count++;
            fac /= 10;
        }
        return count;
    }

    public int fac(int n){
        if(n <= 1) return 1;

        return n * fac(n-1);
    }

    public int trailingZeroes(int n) {
        int count = 0;
        while(n > 0){
            count += n/5;
            n /= 5;
        }
        return count;
    }

    @Test
    public void test(){
        System.out.println(trailingZeroes1(7));
        System.out.println(trailingZeroes(7));
    }
}
