package algo;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class RemoveDuplicates {

    @Test
    public void test(){
        int[] input1 = {1,1};
        int[] input2 = {0,0,1,1,2,2,2,3,3,4,4,4};
        Assert.assertArrayEquals(new int[]{1}, Arrays.copyOfRange(input1, 0, removeDuplicates1(input1)));
        Assert.assertArrayEquals(new int[]{0,1,2,3,4}, Arrays.copyOfRange(input2, 0, removeDuplicates2(input2)));
        HashMap<Character, Integer> countMap = new HashMap<>();
        Set<Map.Entry<Character, Integer>> entries = countMap.entrySet();

    }


    public static int removeDuplicates1(int[] nums) {
        int len = nums.length;
        int count = 1;
        boolean flag = true;
        for(int i = 1; i<len; i++){
            int pointer = i;
            int current = nums[i];
            int previous = nums[i-1];
            while(pointer<len){
                if(nums[pointer]>previous){
                    nums[i] = nums[pointer];
                    count++;
                    System.out.println(i+" "+nums[pointer]+" "+previous);
                    break;
                }
                pointer++;
            }
            if(pointer>=len){
                break;
            }
        }
        return count;
    }

    public static int removeDuplicates2(int[] nums){
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
}
