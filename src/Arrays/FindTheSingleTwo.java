package Arrays;

import org.junit.Test;

public class FindTheSingleTwo {

    public int solution(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res = res ^ nums[i];
        }
        return res;
    }

    @Test
    public void test(){
        int[] arr = {1,2,1,3,4,3,4};
        System.out.println(solution(arr));
    }
}
