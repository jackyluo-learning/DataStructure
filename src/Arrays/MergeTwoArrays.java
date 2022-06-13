package Arrays;

import org.junit.Assert;
import org.junit.Test;

public class MergeTwoArrays {
    public int[] merge(int[] arr1, int[] arr2){
        int len1 = arr1.length;
        int len2 = arr2.length;
        int i1 = 0;
        int i2 = 0;
        int[] result = new int[len1+len2];
        int len = result.length;
        for (int i = 0; i < len; i++) {
            if (i1>=len1){
                result[i] = arr2[i2];
                i2++;
            }else if (i2>=len2){
                result[i] = arr1[i1];
                i1++;
            }else if (arr1[i1]<=arr2[i2]){
                result[i] = arr1[i1];
                i1++;
            }else{
                result[i] = arr2[i2];
                i2++;
            }
        }
        return result;
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
        int i = m+n-1;
        m -= 1;
        n -= 1;
        while (n>=0 || m >=0){

            if(m<0){
                nums1[i] = nums2[n];
                n--;
            }else if(n<0){
                nums1[i] = nums1[m];
                m--;
            }else if(nums1[m] >= nums2[n]){
                nums1[i] = nums1[m];
                m--;
            }else{
                nums1[i] = nums2[n];
                n--;
            }
            i--;
        }
    }

    @Test
    public void test(){
        int[] arr1 = new int[]{-4, -1, 2, 3, 4};
        int[] arr2 = new int[]{1, 2, 4, 9, 10};
        Assert.assertArrayEquals(new int[]{-4, -1, 1, 2, 2, 3, 4, 4, 9, 10}, merge(arr1, arr2));

        int[] arr3 = new int[]{1,2,3,0,0,0};
        int[] arr4 = new int[]{2,5,6};
        merge(arr3, 3, arr4, 3);
        Assert.assertArrayEquals(new int[]{1,2,2,3,5,6}, arr3);
    }
}
