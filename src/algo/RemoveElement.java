package algo;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class RemoveElement {
    /*
    Given an array nums and a value val, remove all instances of that value in-place and return the new length.
    Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
    The order of elements can be changed. It doesn't matter what you leave beyond the new length.
    Example 1:
    Given nums = [3,2,2,3], val = 3,
    Your function should return length = 2, with the first two elements of nums being 2.
    It doesn't matter what you leave beyond the returned length.
     */

    @Test
    public void test(){
        int[] input = new int[]{2,3,2};
        int[] input2 = new int[]{0,2,1,2,2,3,4,4,5,3,2};
        Assert.assertArrayEquals(new int[]{3}, Arrays.copyOfRange(input, 0, removeElement(input,2)));
        Assert.assertArrayEquals(new int[]{0,1,3,4,4,5,3}, Arrays.copyOfRange(input2, 0, removeElement2(input2,2)));
    }

    public static int removeElement(int[] nums, int val){
        int len = nums.length;
        if(len == 0) return 0;
        int t = 0;
        int i = 0;
        for (int k = 0; k<len; k++){
            if(nums[k]==val){
                t++;
            }
        }
        boolean flag = false;
        for (int j = 0; j<len; j++){
            if(nums[j] == val){
                flag = true;
                i = j;
                while(i<len){
                    if(nums[i]!=val){
                        int temp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = temp;
                        break;
                    }
                    i++;
                }
            }
        }
        if(!flag) {
            return len;
        }
        return len-t;
    }

    public static int removeElement2(int[] nums, int val){
        int len = nums.length;
        int i = 0;
        for(int j = 0; j<len; j++){
            if(nums[j]!=val){
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }

}
