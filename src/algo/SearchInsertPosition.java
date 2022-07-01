package algo;

import org.junit.Assert;
import org.junit.Test;

public class SearchInsertPosition {

    @Test
    public void test(){
        int[] intput = {1,3,5,6};
        Assert.assertEquals(2, searchInsertPos(intput, 5));
        Assert.assertEquals(4, searchInsertPos(intput, 7));
        Assert.assertEquals(0, searchInsertPos(intput, 0));
        Assert.assertEquals(1, searchInsertPos(intput, 2));
    }

    public static int searchInsertPos(int[] nums, int target) {
        int len = nums.length;
        return divideCon(nums, 0, len-1, target);
    }

    public static int divideCon(int[] nums, int left, int right, int target) {
        if (left == right) {
            if (nums[left] >= target) return left;
            else return left + 1;
        }
        int mid = (left + right) / 2;
        if (nums[mid] >= target) {
            return divideCon(nums, left, mid, target);
        } else {
            return divideCon(nums, mid + 1, right, target);
        }
    }

    public static int searchInsert(int[] nums, int target) {
        int len = nums.length;
        int index = 0;
        for (int i = 0; i<len;i++){
            if(nums[i] == target){
                return i;
            }
            if(target>nums[i]){
                index = i+1;
            }
        }
        return index;
    }
}
