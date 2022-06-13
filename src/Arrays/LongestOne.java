package Arrays;

import org.junit.Test;

public class LongestOne {
    public int longestOne(int[] arr){
        int len = arr.length;
        int j = 0;
        int max = 0;
        for (int i = 0; i < len; i++){
            if(arr[i] == 1){
                j++;
            }else{
                if(j >= max) max = j;
                j = 0;
            }
        }
        if(j >= max) max = j;
        return max;
    }

    @Test
    public void test(){
        int[] arr = {1,1,0,0,1,1,1};
        System.out.println(longestOne(arr));
    }
}
