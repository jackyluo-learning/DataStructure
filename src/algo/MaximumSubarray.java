package algo;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class MaximumSubarray {
    /*
    Given an integer array nums,
    find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
     */
    //1: dynamic programming: dp[i] = max{num[i]+dp[i-1], num[i]}
    public int maxSubArray1(int[] nums) {
        int currentMax = nums[0];
        int finalMax = currentMax;
        for (int i = 1; i < nums.length; i++) {
            currentMax = Math.max(nums[i] + currentMax, nums[i]);
            finalMax = Math.max(currentMax, finalMax);
        }
        return finalMax;
    }

    //2. divide and conquer
    public int maxSubArray2(int[] nums) {
        int len = nums.length;
        int mid = (len-1) / 2;
        if(len == 1){
            return nums[0];
        }
        else{
            int leftSum = maxSubArray2(Arrays.copyOfRange(nums,0, mid+1));
            int rightSum = maxSubArray2((Arrays.copyOfRange(nums, mid+1, len)));
            int midSum1 = nums[mid];
            int midSum2 = nums[mid+1];
            int resultLeft = nums[mid];
            int resultRight = nums[mid+1];
            for (int i = mid-1; i>=0; i--){
                resultLeft += nums[i];
                if(resultLeft >= midSum1){
                    midSum1 = resultLeft;
                }
            }
            for (int i = mid+2; i < len; i++){
                resultRight += nums[i];
                if(resultRight >= midSum2){
                    midSum2 = resultRight;
                }
            }
            int midSum = midSum1+midSum2;
            int finalResult = rightSum>(midSum>leftSum?midSum:leftSum)?rightSum:(midSum>leftSum?midSum:leftSum);
            return finalResult;
        }
    }

    @Test
    public void test(){
        Assert.assertEquals(6, maxSubArray1(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
        Assert.assertEquals(-1, maxSubArray1(new int[]{-2,-1}));
        Assert.assertEquals(1, maxSubArray1(new int[]{1, -1, 1}));

    }
}
